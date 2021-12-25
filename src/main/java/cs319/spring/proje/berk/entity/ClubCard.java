package cs319.spring.proje.berk.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class ClubCard {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "club_card_sequence")
    @SequenceGenerator(sequenceName = "club_card_sequence", allocationSize = 1, name = "club_card_sequence")
    private Long id;

    private String briefDescription;
    private String logoPath;
    private String mission;
    private String vision;

    @OneToOne
    private Club club;      // done?
}
