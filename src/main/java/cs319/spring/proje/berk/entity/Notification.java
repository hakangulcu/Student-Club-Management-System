package cs319.spring.proje.berk.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_sequence")
    @SequenceGenerator(sequenceName = "notification_sequence", allocationSize = 1, name = "notification_sequence")
    private Long id;

    private String message;
    private LocalDate date;
    private String sender;
    private String receiver;

    @ManyToOne
    private Student student;        // DONE?
}
