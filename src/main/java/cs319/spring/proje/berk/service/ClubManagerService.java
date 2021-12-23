package cs319.spring.proje.berk.service;

import cs319.spring.proje.berk.entity.Club;
import cs319.spring.proje.berk.entity.ClubManager;
import cs319.spring.proje.berk.repository.ClubManagerRepository;
import cs319.spring.proje.berk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClubManagerService {
    private final ClubManagerRepository clubManagerRepository;

    @Autowired
    public ClubManagerService(ClubManagerRepository clubManagerRepository) {
        this.clubManagerRepository = clubManagerRepository;
    }


    public Club getClub(Long clubManagerId) {
        ClubManager clubManager = clubManagerRepository.findById(clubManagerId).orElse(null);

        if(clubManager == null)
            throw new IllegalStateException("club manager does not exist");

        return clubManager.getManagedClub();
    }

    public Long getClubManagerIdByEmail(String email) {
        ClubManager clubManager = clubManagerRepository.findClubManagerByEmail(email);
        return clubManager.getId();
    }

    @Transactional
    public void addClubManager(ClubManager clubManager) {
        ClubManager clubManagerByEmail = clubManagerRepository.findClubManagerByEmail(clubManager.getEmail());

        if(clubManagerByEmail == null) {
            clubManagerRepository.save(clubManager);
        }

        else {
            clubManagerByEmail.setManagedClub(clubManager.getManagedClub());
            clubManagerByEmail.setName(clubManager.getName());
            clubManagerByEmail.setPassword(clubManager.getPassword());
            clubManagerByEmail.setNotificationList(clubManager.getNotificationList());
            clubManagerByEmail.setUserId(clubManager.getUserId());
        }
    }
}
