package cs319.spring.proje.berk.service;

import cs319.spring.proje.berk.entity.*;
import cs319.spring.proje.berk.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class ActivityService {
    private final ActivityRepository activityRepository;
    // private final StudentService studentService;
    private final DescriptionService descriptionService;

    @Autowired
    public ActivityService(ActivityRepository activityRepository, DescriptionService descriptionService) {  //, StudentService studentService) {
        this.activityRepository = activityRepository;
        // this.studentService = studentService;
        this.descriptionService = descriptionService;
    }

    public List<Activity> listActivities() {
        List<Activity> activityList = activityRepository.findAll();
        // System.out.println("size is " + activityList.get(0).getParticipantList().size());

        return activityRepository.findAll();
    }

    public Activity getActivity(Long id) {
        Activity activityById = activityRepository.findById(id).orElse(null);

        if(activityById == null) {
            throw new IllegalStateException("activity with id " + id + " does not exist");
        }

        else {
            return activityById;
        }
    }

    @Transactional
    public void addNewActivity(Activity activity) {
        System.out.println("add activity in service");
        Activity activityByActivityName = activityRepository.findActivityByActivityName(activity.getActivityName());

        if(activityByActivityName == null) {
            activityRepository.save(activity);
        }

        else {
            activityByActivityName.setDate(activity.getDate());
            activityByActivityName.setCapacity(activity.getCapacity());
            activityByActivityName.setGe250Point(activity.getGe250Point());
            activityByActivityName.setActivityDescription(activity.getActivityDescription());
            activityByActivityName.setParticipantList(activity.getParticipantList());
            activityByActivityName.setPlace(activity.getPlace());
        }
    }

    public void deleteActivity(Long id) {
        Activity activityById = activityRepository.findById(id).orElseThrow(() -> new IllegalStateException("activity with id " +
                id + " does not exist"));

        if(activityById != null) {
            activityRepository.deleteById(id);
        }
    }

    @Transactional
    public void addStudentToActivity(Student student, Long activityId) {
        Activity activityById = activityRepository.findById(activityId).orElse(null);
        if(activityById == null)
            throw new IllegalStateException("activity does not exist");

        for(int i = 0; i < student.getActivityList().size(); i++) {
            if(Objects.equals(student.getActivityList().get(i).getId(), activityId)) {
                activityById.getParticipantList().add(student);
                return;
            }
        }

        throw new IllegalStateException("student does not have this activity");
    }

    /*
    @Transactional
    public void addDescriptionToActivity(Description description, Long activityId) {
        Activity activity = activityRepository.findById(activityId).orElse(null);

        if(activity == null)
            throw new IllegalStateException("activity does not exist");

        activity.setActivityDescription(description);
    }

     */

    public Long getActivityIdByName(String activityName) {
        return activityRepository.findActivityByActivityName(activityName).getId();
    }

    // TODO: Check if this method works properly

    @Transactional
    public void addClubToActivity(Club clubById, Long activityId) {
        Activity activity = activityRepository.findById(activityId).orElse(null);

        if(activity == null)
            throw new IllegalStateException("activity does not exist");

        activity.getOrganizerClubList().add(clubById);

        List<Club> organizerClubList = activity.getOrganizerClubList();
        boolean activityFoundInClub = false;

        for (Club club : organizerClubList) {
            for (int j = 0; j < club.getActivityList().size(); j++) {
                if (Objects.equals(club.getActivityList().get(j).getId(), activityId)) {
                    activity.getOrganizerClubList().add(club);
                    activityFoundInClub = true;
                    break;
                }
            }
        }

        if(!activityFoundInClub)
            throw new IllegalStateException("activity does not exist in clubs");
    }

    @Transactional
    public void addEvaluationToActivity(Activity activity, EvaluationBar evaluationBar) {
        activity.getEvaluationList().add(evaluationBar);
    }

    @Transactional
    public void addCommentToActivity(Activity activity, Comment comment) {
        activity.getCommentList().add(comment);
    }

    @Transactional
    public void addScheduleToActivity(Activity activity, Schedule schedule) {
        for(int i = 0; i < schedule.getActivityList().size(); i++) {
            if(Objects.equals(schedule.getActivityList().get(i).getId(), activity.getId())) {
                activity.setSchedule(schedule);
                return;
            }
        }

        throw new IllegalStateException("activity is not in any schedule");
    }

    public List<Student> getParticipantList(Long activityId) {
        Activity activity = activityRepository.findById(activityId).orElse(null);

        if(activity == null) throw new IllegalStateException("activity does not exist");

        return activity.getParticipantList();
    }

    @Transactional
    public void removeStudentFromActivity(Student student, Long activityId) {
        Activity activity = activityRepository.findById(activityId).orElse(null);
        if(activity == null)
            throw new IllegalStateException("activity does not exist");

        if(activity.getParticipantList().contains(student)) {
            activity.getParticipantList().remove(student);
        }
        else
            throw new IllegalStateException("student does not exist in activity participants list");
    }
}
