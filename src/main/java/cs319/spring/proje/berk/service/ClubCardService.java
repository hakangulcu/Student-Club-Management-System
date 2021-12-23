package cs319.spring.proje.berk.service;

import cs319.spring.proje.berk.entity.Club;
import cs319.spring.proje.berk.entity.ClubCard;
import cs319.spring.proje.berk.repository.ClubCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class ClubCardService {
    private final ClubCardRepository clubCardRepository;

    @Autowired
    public ClubCardService(ClubCardRepository clubCardRepository) {
        this.clubCardRepository = clubCardRepository;
    }

    public List<ClubCard> listClubCards() {
        return clubCardRepository.findAll();
    }

    public ClubCard getClubCard(Long id) {
        ClubCard clubCardById = clubCardRepository.findById(id).orElse(null);

        if(clubCardById == null) {
            throw new IllegalStateException("clubCard with id " + id + " does not exist");
        }

        else {
            return clubCardById;
        }
    }

    @Transactional
    public void addClubCard(ClubCard clubCard) {
        ClubCard clubCardById = clubCardRepository.findById(clubCard.getId()).orElse(null);

        if(clubCardById == null) {
            clubCardRepository.save(clubCard);
        }

        else {
            clubCardById.setLogoPath(clubCard.getLogoPath());
            clubCardById.setBriefDescription(clubCard.getBriefDescription());
        }
    }

    public void deleteClubCard(Long id) {
        ClubCard clubCardById = clubCardRepository.findById(id).orElse(null);

        if(clubCardById == null) {
            throw new IllegalStateException("clubCard with id " + id + " does not exist");
        }

        else {
            clubCardRepository.deleteById(id);
        }
    }

    @Transactional
    public void addClubToClubCard(ClubCard clubCard, Club club) {
        if(Objects.equals(club.getClubCard().getId(), clubCard.getId())) {
            clubCard.setClub(club);
            return;
        }

        throw new IllegalStateException("club does not have specified clubCard");
    }
}
