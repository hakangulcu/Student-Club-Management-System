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
        Activity activityById = activityRepository.findById(activity.getId()).orElse(null);;


        // customize
        if(activity.getId() != null) {
            if(activityById == null)
                throw new IllegalStateException("activity does not exist");
            else {
                activityById.setActivityName(activity.getActivityName());
                activityById.setDate(activity.getDate());
                activityById.setCapacity(activity.getCapacity());
                activityById.setGe250Point(activity.getGe250Point());
                activityById.setActivityDescription(activity.getActivityDescription());
                activityById.setParticipantList(activity.getParticipantList());
                activityById.setPlace(activity.getPlace());
            }
        }

        else
            activityRepository.save(activity);
    }

    @Transactional
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
        Activity activity = activityRepository.findActivityByActivityName(activityName);
        if(activity != null)
            return activity.getId();
        throw new IllegalStateException("activity with that name does not exist");
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

    @Transactional
    public void customizeActivity(Long activityId, Activity activity) {
        Activity activityById = activityRepository.findById(activityId).orElse(null);
        if(activityById == null)
            throw new IllegalStateException("activity does not exist");

        activityById.setActivityName(activity.getActivityName());
        activityById.setDate(activity.getDate());
        activityById.setCapacity(activity.getCapacity());
        activityById.setGe250Point(activity.getGe250Point());
        activityById.setActivityDescription(activity.getActivityDescription());
        activityById.setParticipantList(activity.getParticipantList());
        activityById.setPlace(activity.getPlace());
        activityById.setGuests(activity.getGuests());
    }
}
