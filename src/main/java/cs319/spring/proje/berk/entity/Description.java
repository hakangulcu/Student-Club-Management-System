package cs319.spring.proje.berk.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Table
@Entity
@Getter
@Setter
public class Description {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "description_sequence")
    @SequenceGenerator(sequenceName = "description_sequence", allocationSize = 1, name = "description_sequence")
    private Long id;

    private String textDescription;
    private String guests;

    @OneToOne
    private Activity activity;                          // DONE?

    @OneToOne
    private Club club;                                  // DONE?

    @OneToMany(mappedBy = "description")
    private List<VisualElement> visualElementsList;     // DONE

}
