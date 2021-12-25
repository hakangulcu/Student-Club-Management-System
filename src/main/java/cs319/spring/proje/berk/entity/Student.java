package cs319.spring.proje.berk.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table
public class Student extends User {

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "club_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "club_id"))
    private List<Club> clubList;

    @ElementCollection
    private List<Boolean> isFavoriteList;

    // @ManyToMany(cascade = CascadeType.ALL)

    @ManyToMany
    @JoinTable(
            name = "activity_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id"))
    private List<Activity> activityList;

    @OneToMany(mappedBy = "student")
    private List<Notification> notificationList;        // done?

    private String department;

    // @OneToOne
    // private Schedule schedule;

    // @OneToOne
    // private Comment comment;
}
