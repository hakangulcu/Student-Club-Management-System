package cs319.spring.proje.berk.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "activity_club",
            joinColumns = @JoinColumn(name = "club_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id"))
    private List<Activity> activityList;        // done


    @ManyToMany(mappedBy = "clubList")
    private List<Student> studentList;          // done

    @OneToOne
    private Schedule clubSchedule;              // TODO: club'ın schedule id'sinden endpointe yol var


    // @OneToOne
    // private Description clubDescription;        // done?

    private String clubTextDescription;
    private String guests;


    @OneToMany(mappedBy = "club")
    private List<FAQ> faqList;                  // done?

    @OneToOne
    private ClubCard clubCard;                  // done?

    @OneToMany(mappedBy = "managedClub")
    private List<ClubManager> clubManagerList;  // TODO

    @ManyToOne
    private ClubAdvisor clubAdvisor;
}
