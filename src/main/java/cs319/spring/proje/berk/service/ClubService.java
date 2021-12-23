package cs319.spring.proje.berk.service;

import cs319.spring.proje.berk.entity.*;
import cs319.spring.proje.berk.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class ClubService {
    private final ClubRepository clubRepository;
    private final ActivityService activityService;

    @Autowired
    public ClubService(ClubRepository clubRepository, ActivityService activityService) {
        this.clubRepository = clubRepository;
        this.activityService = activityService;
    }

    public List<Club> listClubs() {
        return clubRepository.findAll();
    }

    @Transactional
    public void addNewClub(Club club) {
        System.out.println("add club in service");

        Club clubByName = clubRepository.findByClubName(club.getClubName());
        //  if club name does not exist
        if(clubByName == null) {
            clubRepository.save(club);
        }

        // club exists in repo
        else {
           clubByName.setClubCard(club.getClubCard());
           clubByName.setClubAdvisor(club.getClubAdvisor());
           clubByName.setClubDescription(club.getClubDescription());
           clubByName.setClubSchedule(club.getClubSchedule());
           clubByName.setClubManagerList(club.getClubManagerList());
           clubByName.setActivityList(club.getActivityList());
           clubByName.setFaqList(club.getFaqList());
           clubByName.setStudentList(club.getStudentList());
        }

    }

    public void deleteClub(Long id) {
        Club clubById = clubRepository.findById(id).orElse(null);
        if(clubById == null) {
            throw new IllegalStateException("club with id " + id + " does not exist");
        }
        else {
            clubRepository.deleteById(id);
        }
    }

    public Club getClub(Long id) {
        Club clubById = clubRepository.findById(id).orElse(null);

        if(clubById == null) {
            throw new IllegalStateException("club with id " + id + " does not exist");
        }

        else {
            return clubById;
        }
    }

    @Transactional
    public void addStudentToClub(Student student, Long clubId) {
        Club clubById = clubRepository.findById(clubId).orElse(null);

        if(clubById == null) {
            throw new IllegalStateException("club does not exist");
        }

        List<Club> studentClubList = student.getClubList();
        for(int i = 0; i < studentClubList.size(); i++) {
            if(Objects.equals(studentClubList.get(i).getId(), clubId)) {
                clubById.getStudentList().add(student);
                return;
            }
        }

        throw new IllegalStateException("student does not have this club");
    }

    @Transactional
    public void addActivityToClub(Long activityId, Long clubId) {
        Activity activityById = activityService.getActivity(activityId);
        Club clubById = clubRepository.findById(clubId).orElse(null);

        if(clubById == null)
            throw new IllegalStateException("club does not exist");

        clubById.getActivityList().add(activityById);
    }

    @Transactional
    public void addDescriptionToClub(Description description, Club club) {
        club.setClubDescription(description);
    }

    @Transactional
    public void addFaqToClub(Club club, FAQ faq) {
        club.getFaqList().add(faq);
    }

    @Transactional
    public void addClubCardToClub(ClubCard clubCard, Club club) {
        club.setClubCard(clubCard);
    }
}
