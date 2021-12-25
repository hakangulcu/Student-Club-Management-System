package cs319.spring.proje.berk.controller;

import cs319.spring.proje.berk.entity.Club;
import cs319.spring.proje.berk.entity.Notification;
import cs319.spring.proje.berk.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "notifications")
public class NotificationController {
    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public List<Notification> listNotifications() {
        return notificationService.listNotifications();
    }

    @GetMapping(path = "{notificationId}")
    public Notification getNotification(@PathVariable("notificationId") Long id) {
        return notificationService.getNotification(id);
    }

    @PutMapping
    public void addNewNotification(@RequestBody Notification notification) {
        notificationService.addNewNotification(notification);
    }

    @DeleteMapping(path = "{notificationId}")
    public void deleteNotification(@PathVariable("notificationId") Long id) {
        notificationService.deleteNotification(id);
    }
}
