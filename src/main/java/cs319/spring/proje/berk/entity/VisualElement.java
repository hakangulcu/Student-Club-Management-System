package cs319.spring.proje.berk.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class VisualElement {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "visual_element_sequence")
    @SequenceGenerator(sequenceName = "visual_element_sequence", allocationSize = 1, name = "visual_element_sequence")
    private Long id;

    private String elementPath;
    private String elementDescription;

    @ManyToOne
    private Description description;            // done?
}
