package cs319.spring.proje.berk.service;

import cs319.spring.proje.berk.entity.ClubAdvisor;
import cs319.spring.proje.berk.entity.User;
import cs319.spring.proje.berk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class ClubAdvisorService {
    private final UserRepository userRepository;

    @Autowired
    public ClubAdvisorService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
    public List<ClubAdvisor> listAllAdvisors() {
        return userRepository.findAllByAdvisorTrue();
    }

    public ClubAdvisor getClubAdvisor(Long clubAdvisorId) {
        List<ClubAdvisor> advisorList = userRepository.findAllByAdvisorTrue();
        for (ClubAdvisor advisor : advisorList) {
            if (Objects.equals(advisor.getId(), clubAdvisorId)) {
                return advisor;
            }
        }

        throw new IllegalStateException("club advisor does not exist");
    }

     */

    /*
    @Transactional
    public void addClubAdvisor(ClubAdvisor clubAdvisor) {
        ClubAdvisor clubAdvisorById = null;

        if(clubAdvisor.getId() != null) {
            clubAdvisorById = getClubAdvisor(clubAdvisor.getId());
        }

        // if json without id came with the request, save it
        if(clubAdvisorById == null) {
            userRepository.save((User)clubAdvisor);
        }

        else {
            clubAdvisorById.setAdvisor(clubAdvisor.isAdvisor());
            clubAdvisorById.setAdmin(clubAdvisor.isAdmin());
            clubAdvisorById.setAdvisor(clubAdvisor.isManager());
            clubAdvisorById.setAdvisor(clubAdvisor.getEmail());
            clubAdvisorById.setAdvisor(clubAdvisor.getName());
            clubAdvisorById.setAdvisor(clubAdvisor.getPassword());
            clubAdvisorById.setAdvisor(clubAdvisor.getSurname());
            clubAdvisorById.setAdvisor(clubAdvisor.getUserId());
            clubAdvisorById.setAdvisor(clubAdvisor.getNotificationList());
            clubAdvisorById.setAdvisor(clubAdvisor.getSchedule());
        }
    }
    */
     
}
