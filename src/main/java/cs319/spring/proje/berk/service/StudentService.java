package cs319.spring.proje.berk.service;

import cs319.spring.proje.berk.entity.Activity;
import cs319.spring.proje.berk.entity.Club;
import cs319.spring.proje.berk.entity.Notification;
import cs319.spring.proje.berk.entity.Student;
import cs319.spring.proje.berk.repository.ActivityRepository;
import cs319.spring.proje.berk.repository.ClubRepository;
import cs319.spring.proje.berk.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final ClubService clubService;
    private final ActivityService activityService;

    @Autowired
    public StudentService(StudentRepository studentRepository, ClubService clubService, ActivityService activityService) {
        this.studentRepository = studentRepository;
        this.clubService = clubService;
        this.activityService = activityService;
    }

    public List<Student> listStudents() {
        return studentRepository.findAll();
    }

    @Transactional
    public void addNewStudent(Student student) {
        Student studentByEmail = studentRepository.findStudentByEmail(student.getEmail());


        if(studentByEmail == null) {
            studentRepository.save(student);
        }

        else {
            studentByEmail.setEmail(student.getEmail());
            studentByEmail.setName(student.getName());
            studentByEmail.setSurname(student.getSurname());
            studentByEmail.setUserId(student.getUserId());
            studentByEmail.setEmail(student.getEmail());
            studentByEmail.setPassword(student.getPassword());

            // Lombok is a little weird when it comes to creating getters and setters for boolean fields
            studentByEmail.setManager(student.isManager());
            studentByEmail.setAdmin(student.isAdmin());
            studentByEmail.setAdvisor(student.isAdvisor());
        }
    }

    public void deleteStudent(Long id) {
        Student studentById = studentRepository.findById(id).orElse(null);

        if(studentById == null) {
            throw new IllegalStateException("student with id " + id + " does not exist");
        }

        else {
            studentRepository.deleteById(id);
        }
    }

    public Student getStudent(Long id) {
        Student studentById = studentRepository.findById(id).orElse(null);

        if(studentById == null) {
            throw new IllegalStateException("student with id " + id + " does not exist");
        }

        else {
            return studentById;
        }
    }

    public List<Club> getFavoriteClubs(Long id) {
        Student student = studentRepository.findById(id).orElse(null);

        if(student == null) throw new IllegalStateException("student with id " + id + " does not exist");

        List<Club> favClubList = new ArrayList<Club>();
        for(int i = 0; i < student.getClubList().size(); i++) {
            if (student.getIsFavoriteList().get(i)) {
                favClubList.add(student.getClubList().get(i));
            }
        }

        return favClubList;
    }

    @Transactional
    public void addClubToStudent(Long studentId, Long clubId) {
        Student studentById = studentRepository.findById(studentId).orElse(null);
        if(studentById == null)
            throw new IllegalStateException("student does not exist");

        Club clubById = clubService.getClub(clubId);
        studentById.getClubList().add(clubById);
        studentById.getIsFavoriteList().add(false);
    }

    @Transactional
    public void changeFavoriteStatus(Long studentId, Long clubId) {
        Student studentById = studentRepository.findById(studentId).orElse(null);
        if(studentById == null)
            throw new IllegalStateException("student does not exist");

        int clubIndex;
        boolean favoriteStatus = false;
        for(clubIndex = 0; clubIndex < studentById.getClubList().size(); clubIndex++) {
            if(studentById.getClubList().get(clubIndex).getId() == clubId) {
                favoriteStatus = studentById.getIsFavoriteList().get(clubIndex);
                studentById.getIsFavoriteList().set(clubIndex, !favoriteStatus);
                break;
            }
        }
    }

    public List<Activity> listAllActivities(Long id) {
        Student studentById = studentRepository.findById(id).orElse(null);

        if(studentById == null)
            throw new IllegalStateException("student does not exist");

        return studentById.getActivityList();
    }

    @Transactional
    public void addActivityToStudent(Long studentId, Long activityId) {
        Student student = studentRepository.findById(studentId).orElse(null);

        if(student == null)
            throw new IllegalStateException("student does not exist");

        student.getActivityList().add(activityService.getActivity(activityId));
    }

    public Long getStudentIdByEmail(String email) {
        Student student = studentRepository.findStudentByEmail(email);
        if(student == null)
            throw new IllegalStateException("student does not exist");
        return student.getId();
    }

    @Transactional
    public void addNotificationToStudent(Notification notification, Student student) {
        student.getNotificationList().add(notification);
    }

    @Transactional
    public void deleteActivityFromStudent(Activity activity, Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);

        if(student == null)
            throw new IllegalStateException("student does not exist");

        student.getActivityList().remove(activity);
    }

    public boolean loginPasswordCheck(String email, String password) {
        Student student = studentRepository.findStudentByEmail(email);
        return student != null && Objects.equals(student.getPassword(), password);
    }

    @Transactional
    public void removeClubFromStudent(Long studentId, Club club) {
        Student student = studentRepository.findById(studentId).orElse(null);

        if(student == null)
            throw new IllegalStateException("student does not exist");

        if(student.getClubList().contains(club))
            student.getClubList().remove(club);
        else
            throw new IllegalStateException("student is not a member of club");
    }
}
