package cs319.spring.proje.berk.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Table
@Entity
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "club_sequence")
    @SequenceGenerator(sequenceName = "club_sequence", allocationSize = 1, name = "club_sequence")
    private Long id;
    private String clubName;

    @ManyToMany
    private List<Activity> activityList;        // done

    @ManyToMany
    private List<Student> studentList;          // done

    @OneToOne
    private Schedule clubSchedule;              // TODO: club'ın schedule id'sinden endpointe yol var


    @OneToOne
    private Description clubDescription;        // done?


    @OneToMany(mappedBy = "club")
    private List<FAQ> faqList;                  // done?

    @OneToOne
    private ClubCard clubCard;                  // done?

    @OneToMany(mappedBy = "managedClub")
    private List<ClubManager> clubManagerList;  // TODO

    @ManyToOne
    private ClubAdvisor clubAdvisor;
}
