package cs319.spring.proje.berk.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class ClubAdvisor extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "club_advisor_sequence")
    @SequenceGenerator(sequenceName = "club_advisor_sequence", allocationSize = 1, name = "club_advisor_sequence")
    private Long id;

    @OneToOne
    private Schedule schedule;

    @OneToMany(mappedBy = "clubAdvisor")
    private List<Club> clubList;
}
