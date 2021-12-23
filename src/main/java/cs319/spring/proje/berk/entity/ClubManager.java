package cs319.spring.proje.berk.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class ClubManager extends User {

    // @OneToMany
    // private List<Club> managerClubList;

    // @OneToMany
    // private List<Notification> notificationList;

    // @OneToOne
    // private Schedule schedule;

    @ManyToOne
    private Club managedClub;
}
