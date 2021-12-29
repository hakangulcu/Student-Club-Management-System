package cs319.spring.proje.berk.controller;


import cs319.spring.proje.berk.entity.*;
import cs319.spring.proje.berk.service.ActivityService;
import cs319.spring.proje.berk.service.ClubService;
import cs319.spring.proje.berk.service.NotificationService;
import cs319.spring.proje.berk.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
    public List<Club> getClubs(@PathVariable("studentId") Long studentId) {
        return studentService.getClubs(studentId);
    }

    @GetMapping(path = "getFavoriteClubs/{studentId}")
    public List<Club> getFavoriteClubs(@PathVariable("studentId") Long id) {
        return studentService.getFavoriteClubs(id);
    }
    /*
    @PutMapping(path = "addClub/{studentId}/{clubId}")
    public void addClub(@PathVariable("studentId") Long studentId,
                        @PathVariable("clubId") Long clubId) {
        studentService.addClubToStudent(studentId, clubId);
    }
     */

    @GetMapping(path = "changeFavoriteStatus/{studentId}/{clubId}")
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
        Activity activity = activityService.getActivity(activityId);
        studentService.addActivityToStudent(studentId, activity);

        //Student student = studentService.getStudent(studentId);
        //activityService.addStudentToActivity(student, activityId);
    }

    @PutMapping(path = "addClubToStudent/{studentId}/{clubId}")
    public void addClubToStudent(@PathVariable("studentId") Long studentId,
                                 @PathVariable("clubId") Long clubId) {
        Club club = clubService.getClub(clubId);
        studentService.addClubToStudent(studentId, club);
        //Student student = studentService.getStudent(studentId);
        //clubService.addStudentToClub(student, clubId);
    }

    @PutMapping(path = "addNotificationToStudent/{studentId}")
    public void addNotificationToStudent(@PathVariable("studentId") Long studentId,
                                         @RequestBody Notification notification) {
        notificationService.addNewNotification(notification);
        Student student = studentService.getStudent(studentId);
        studentService.addNotificationToStudent(notification, student);
        //notificationService.addStudentToNotification(notification, student);
    }

    @PutMapping(path = "deleteActivityFromStudent/{studentId}/{activityId}")
    public void deleteActivityFromStudent(@PathVariable("studentId") Long studentId,
                                          @PathVariable("activityId") Long activityId) {
        Activity activity = activityService.getActivity(activityId);
        studentService.deleteActivityFromStudent(activity, studentId);
    }

    @GetMapping(path = "loginPasswordCheck/{email}/{password}")
    public boolean loginPasswordCheck(@PathVariable("email") String email,
                                      @PathVariable("password") String password) {
        return studentService.loginPasswordCheck(email, password);
    }

    @DeleteMapping(path = "removeClubFromStudent/{studentId}/{clubId}")
    public void removeClubFromStudent(@PathVariable("studentId") Long studentId,
                                      @PathVariable("clubId") Long clubId) {
        Club club = clubService.getClub(clubId);
        studentService.removeClubFromStudent(studentId, club);
    }

    @GetMapping(path = "getUnattendedClubs/{studentId}")
    public List<Club> getUnattendedClubs(@PathVariable("studentId") Long studentId) {
        return studentService.getUnattendedClubs(studentId);
    }

    @GetMapping(path = "getUnattendedActivities/{studentId}")
    public List<Activity> getUnattendedActivities(@PathVariable("studentId") Long studentId) {
        return studentService.getUnattendedActivities(studentId);
    }
}
