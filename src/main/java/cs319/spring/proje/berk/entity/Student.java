package cs319.spring.proje.berk.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Student extends User {

    @ManyToMany
    private List<Club> clubList;

    @ElementCollection
    private List<Boolean> isFavoriteList;

    // @ManyToMany(cascade = CascadeType.ALL)
    @ManyToMany
    private List<Activity> activityList;

    @OneToMany(mappedBy = "student")
    private List<Notification> notificationList;        // done?

    // @OneToOne
    // private Schedule schedule;

    // @OneToOne
    // private Comment comment;
}
