package cs319.spring.proje.berk.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "activity_sequence")
    @SequenceGenerator(sequenceName = "activity_sequence", allocationSize = 1, name = "activity_sequence")
    private Long id;

    private String activityName;
    private LocalDate date;
    private Integer capacity;
    private Integer ge250Point;
    private Integer averageRate;
    private String place;


    @ManyToMany(mappedBy = "activityList")
    private List<Club> organizerClubList;   // DONE?

    // @JsonBackReference
    @JsonIgnore
    @ManyToMany(mappedBy = "activityList")
    private List<Student> participantList;      // DONE

    @OneToOne
    private Description activityDescription;    // DONE

    @OneToMany(mappedBy = "activity")
    private List<EvaluationBar> evaluationList; // DONE?

    @OneToMany(mappedBy = "activity")
    private List<Comment> commentList;          // DONE?

    @ManyToOne
    private Schedule schedule;                  // DONE?





}
