package cs319.spring.proje.berk.service;

import cs319.spring.proje.berk.entity.Description;
import cs319.spring.proje.berk.entity.Notification;
import cs319.spring.proje.berk.entity.Student;
import cs319.spring.proje.berk.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<Notification> listNotifications() {
        return notificationRepository.findAll();
    }

    @Transactional
    public void addNewNotification(Notification notification) {
        Notification notificationById = notificationRepository.findById(notification.getId()).orElse(null);

        if(notificationById == null) {
            notificationRepository.save(notification);
        }

        else {
            notificationById.setDate(notification.getDate());
            notificationById.setMessage(notification.getMessage());
            notificationById.setReceiver(notification.getReceiver());
            notificationById.setSender(notification.getSender());
        }
    }

    public void deleteNotification(Long id) {
        Notification notificationById = notificationRepository.findById(id).orElse(null);

        if(notificationById == null) {
            throw new IllegalStateException("notification with id " + id + " does not exist");
        }

        else {
            notificationRepository.deleteById(id);
        }
    }

    public Notification getNotification(Long id) {
        Notification notificationById = notificationRepository.findById(id).orElse(null);

        if(notificationById == null) {
            throw new IllegalStateException("notification with id " + id + " does not exist");
        }

        else {
            return notificationById;
        }
    }

    @Transactional
    public void addStudentToNotification(Notification notification, Student student) {
        List<Notification> list = student.getNotificationList();

        for(int i = 0; i < list.size(); i++) {
            if(Objects.equals(list.get(i).getId(), notification.getId())) {
                notification.setStudent(student);
                return;
            }
        }

        throw new IllegalStateException("student has no such notification");
    }
}
