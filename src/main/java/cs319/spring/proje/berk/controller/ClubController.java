package cs319.spring.proje.berk.controller;

import cs319.spring.proje.berk.entity.*;
import cs319.spring.proje.berk.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "clubs")
public class ClubController {
    private final ClubService clubService;
    private final ActivityService activityService;
    private final DescriptionService descriptionService;
    private final FAQService faqService;
    private final ClubCardService clubCardService;
    private final ClubManagerService clubManagerService;

    @Autowired
    public ClubController(ClubService clubService, ActivityService activityService, DescriptionService descriptionService, FAQService faqService, ClubCardService clubCardService, ClubManagerService clubManagerService) {
        this.clubService = clubService;
        this.activityService = activityService;
        this.descriptionService = descriptionService;
        this.faqService = faqService;
        this.clubCardService = clubCardService;
        this.clubManagerService = clubManagerService;
    }

    @GetMapping
    public List<Club> listClubs() {
        return clubService.listClubs();
    }

    @GetMapping(path = "getClub/{clubId}")
    public Club getClub(@PathVariable("clubId") Long id) {
        return clubService.getClub(id);
    }

    @PutMapping(path = "addNewClub")
    public void addNewClub(@RequestBody Club club) {
        clubService.addNewClub(club);
    }

    @DeleteMapping(path = "deleteClub/{clubId}")
    public void deleteClub(@PathVariable("clubId") Long id) {
        clubService.deleteClub(id);
    }

    @PutMapping(path = "addActivityToClub/{activityId}/{clubId}")
    public void addActivityToClub(@PathVariable("activityId") Long activityId,
                                  @PathVariable("clubId") Long clubId) {
        Activity activity = activityService.getActivity(activityId);
        clubService.addActivityToClub(activity, clubId);
    }

    @GetMapping(path = "getClubIdByClubName/{clubName}")
    public Long getClubIdByClubName(@PathVariable("clubName") String clubName) {
        return clubService.getClubIdByClubName(clubName);
    }

    /*
    @PutMapping(path = "addDescriptionToClub/{clubId}")
    public void addDescriptionToClub(@PathVariable("clubId") Long clubId,
                                     @RequestBody Description description) {
        descriptionService.addNewDescription(description);
        Club club = clubService.getClub(clubId);
        clubService.addDescriptionToClub(description, club);
        descriptionService.addClubToDescription(description, club);
    }

     */

    @PutMapping(path = "addFaqToClub/{clubId}")
    public void addFaqToClub(@PathVariable("clubId") Long clubId,
                             @RequestBody FAQ faq) {
        faqService.addFAQ(faq);
        Club club = clubService.getClub(clubId);
        clubService.addFaqToClub(club, faq);
        faqService.addClubToFaq(club, faq);
    }

    @PutMapping(path = "addClubCardtoClub/{clubId}")
    public void addClubCardToClub(@PathVariable("clubId") Long clubId,
                                  @RequestBody ClubCard clubCard) {
        clubCardService.addClubCard(clubCard);
        Club club = clubService.getClub(clubId);
        clubService.addClubCardToClub(clubCard, club);
        clubCardService.addClubToClubCard(clubCard, club);
    }

    /*
    @PutMapping(path = "addClubManagerToClub/{clubManagerId}/{clubId}")
    public void addClubManagerToClub(@PathVariable("clubId") Long clubId,
                                     @PathVariable("clubManagerId") Long clubManagerId) {
        ClubManager clubManager = clubManagerService.getClubManager(clubManagerId);
        clubService.addClubManagerToClub(clubManager, clubId);
    }

     */

    @GetMapping(path = "listActivities/{clubId}")
    public List<Activity> listActivities(@PathVariable("clubId") Long clubId) {
        return clubService.listActivities(clubId);
    }

    @GetMapping(path = "listStudentsInClub/{clubId}")
    public List<Student> listStudentsInClub(@PathVariable("clubId") Long clubId) {
        return clubService.listStudentsInClub(clubId);
    }
}
