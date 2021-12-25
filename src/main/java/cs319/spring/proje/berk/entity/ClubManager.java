package cs319.spring.proje.berk.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class ClubManager extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "club_manager_sequence")
    @SequenceGenerator(sequenceName = "club_manager_sequence", allocationSize = 1, name = "club_manager_sequence")
    private Long id;


    // @OneToMany
    // private List<Club> managerClubList;

    // @OneToMany
    // private List<Notification> notificationList;

    // @OneToOne
    // private Schedule schedule;

    @ManyToOne
    // @JoinColumn(name = "managed_club_id")
    private Club managedClub;
}
