package cs319.spring.proje.berk.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class EvaluationBar {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evaluation_bar_sequence")
    @SequenceGenerator(sequenceName = "evaluation_bar_sequence", allocationSize = 1, name = "evaluation_bar_sequence")
    private Long id;

    private Integer rate;

    @OneToOne
    private Student student;

    @ManyToOne
    private Activity activity;
}
