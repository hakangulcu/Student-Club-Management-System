package cs319.spring.proje.berk.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@Entity
// // table name should be something different than user because it is reserved in postgres lol
@Table(name = "users")
// @AllArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(sequenceName = "user_sequence", allocationSize = 1, name = "user_sequence")
    private Long id;

    private String name;
    private String surname;
    private Integer userId;
    private String email;
    private String password;
    /*
    private boolean isManager;
    private boolean isAdmin;
    private boolean isAdvisor;


     */

    @OneToMany
    private List<Notification> notificationList;

}
