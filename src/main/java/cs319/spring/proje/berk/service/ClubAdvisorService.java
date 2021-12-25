package cs319.spring.proje.berk.service;

import cs319.spring.proje.berk.entity.ClubAdvisor;
import cs319.spring.proje.berk.entity.Student;
import cs319.spring.proje.berk.repository.ClubAdvisorRepository;
import cs319.spring.proje.berk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ClubAdvisorService {
    private final ClubAdvisorRepository clubAdvisorRepository;

    @Autowired
    public ClubAdvisorService(ClubAdvisorRepository clubAdvisorRepository) {
        this.clubAdvisorRepository = clubAdvisorRepository;
    }

    public boolean loginPasswordCheck(String email, String password) {
        ClubAdvisor clubAdvisor = clubAdvisorRepository.findClubAdvisorByEmail(email);
        return clubAdvisor != null && Objects.equals(clubAdvisor.getPassword(), password);
    }
     
}
