package cs319.spring.proje.berk.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "schedule_sequence")
    @SequenceGenerator(sequenceName = "schedule_sequence", allocationSize = 1, name = "schedule_sequence")
    private Long id;

    @OneToMany(mappedBy = "schedule")
    private List<Activity> activityList;        // DONE?

    @OneToOne
    private Club club;

}
