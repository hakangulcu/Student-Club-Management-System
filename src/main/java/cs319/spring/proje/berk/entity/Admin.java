package cs319.spring.proje.berk.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Admin extends User {

    // @OneToMany
    // private List<User> userList;

    // @OneToMany
    // private List<Student> studentList;

    /*
    @OneToMany
    private List<ClubManager> managerList;

    @OneToMany
    private List<Club> clubList;
    */
}
