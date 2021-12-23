package cs319.spring.proje.berk.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class FAQ {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "faq_sequence")
    @SequenceGenerator(sequenceName = "faq_sequence", allocationSize = 1, name = "faq_sequence")
    private Long id;

    private String question;
    private String answer;

    @ManyToOne
    private Club club;              // DONE?
}
