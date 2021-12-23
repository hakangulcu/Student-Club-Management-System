package cs319.spring.proje.berk.controller;


import cs319.spring.proje.berk.entity.Activity;
import cs319.spring.proje.berk.entity.Club;
import cs319.spring.proje.berk.entity.Notification;
import cs319.spring.proje.berk.entity.Student;
import cs319.spring.proje.berk.service.ActivityService;
import cs319.spring.proje.berk.service.ClubService;
import cs319.spring.proje.berk.service.NotificationService;
import cs319.spring.proje.berk.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController(value = "demo")
@RequestMapping(path = "students")
public class StudentController {

    private final StudentService studentService;
    private final ActivityService activityService;
    private final ClubService clubService;
    private final NotificationService notificationService;


    @Autowired
    public StudentController(StudentService studentService, ActivityService activityService, ClubService clubService, NotificationService notificationService) {
        this.studentService = studentService;
        this.activityService = activityService;
        this.clubService = clubService;
        this.notificationService = notificationService;
    }

    @GetMapping(path = "getStudentIdByEmail/{studentEmail}")
    public Long getStudentIdByEmail(@PathVariable("studentEmail") String email) {
        return studentService.getStudentIdByEmail(email);
    }

    @GetMapping(path = "listStudents")
    public List<Student> listStudents() {
        return studentService.listStudents();
    }

    @GetMapping(path = "getStudent/{studentId}")
    public Student getStudent(@PathVariable("studentId") Long id) {
        return studentService.getStudent(id);
    }

    @PutMapping(path = "addNewStudent")
    public void addNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "deleteStudent/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id) {
        studentService.deleteStudent(id);
    }

    @GetMapping(path = "getClubs/{studentId}")
    public List<Club> getClubs(@PathVariable("studentId") Long id) {
        return studentService.getStudent(id).getClubList();
    }

    @GetMapping(path = "getFavoriteClubs/{studentId}")
    public List<Club> getFavoriteClubs(@PathVariable("studentId") Long id) {
        return studentService.getFavoriteClubs(id);
    }

    @PutMapping(path = "addClub/{studentId}/{clubId}")
    public void addClub(@PathVariable("studentId") Long studentId,
                        @PathVariable("clubId") Long clubId) {
        studentService.addClubToStudent(studentId, clubId);
    }

    @PutMapping(path = "changeFavoriteStatus/{studentId}/{clubId}")
    public void changeFavoriteStatus(@PathVariable("studentId") Long studentId,
                                     @PathVariable("clubId") Long clubId) {
        studentService.changeFavoriteStatus(studentId, clubId);
    }

    @GetMapping(path = "listAllActivities/{studentId}")
    public List<Activity> listAllActivities(@PathVariable("studentId") Long id) {
        return studentService.listAllActivities(id);
    }


    @PutMapping(path = "addActivityToStudent/{studentId}/{activityId}")
    public void addActivityToStudent(@PathVariable("studentId") Long studentId,
                                     @PathVariable("activityId") Long activityId) {
        studentService.addActivityToStudent(studentId, activityId);

        Student student = studentService.getStudent(studentId);
        activityService.addStudentToActivity(student, activityId);
    }

    @PutMapping(path = "addClubToStudent/{studentId}/{clubId}")
    public void addClubToStudent(@PathVariable("studentId") Long studentId,
                                 @PathVariable("clubId") Long clubId) {
        studentService.addClubToStudent(studentId, clubId);
        Student student = studentService.getStudent(studentId);
        clubService.addStudentToClub(student, clubId);
    }

    @PutMapping(path = "addNotificationToStudent/{studentId}")
    public void addNotificationToStudent(@PathVariable("studentId") Long studentId,
                                         @RequestBody Notification notification) {
        notificationService.addNewNotification(notification);
        Student student = studentService.getStudent(studentId);
        studentService.addNotificationToStudent(notification, student);
        notificationService.addStudentToNotification(notification, student);
    }

}
