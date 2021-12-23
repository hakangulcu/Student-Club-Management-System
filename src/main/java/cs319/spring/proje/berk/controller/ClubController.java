package cs319.spring.proje.berk.controller;

import cs319.spring.proje.berk.entity.Club;
import cs319.spring.proje.berk.entity.ClubCard;
import cs319.spring.proje.berk.entity.Description;
import cs319.spring.proje.berk.entity.FAQ;
import cs319.spring.proje.berk.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "clubs")
public class ClubController {
    private final ClubService clubService;
    private final ActivityService activityService;
    private final DescriptionService descriptionService;
    private final FAQService faqService;
    private final ClubCardService clubCardService;

    @Autowired
    public ClubController(ClubService clubService, ActivityService activityService, DescriptionService descriptionService, FAQService faqService, ClubCardService clubCardService) {
        this.clubService = clubService;
        this.activityService = activityService;
        this.descriptionService = descriptionService;
        this.faqService = faqService;
        this.clubCardService = clubCardService;
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
        Club clubById = clubService.getClub(clubId);
        clubService.addActivityToClub(activityId, clubId);
        activityService.addClubToActivity(clubById, activityId);
    }

    @PutMapping(path = "addDescriptionToClub/{clubId}")
    public void addDescriptionToClub(@PathVariable("clubId") Long clubId,
                                     @RequestBody Description description) {
        descriptionService.addNewDescription(description);
        Club club = clubService.getClub(clubId);
        clubService.addDescriptionToClub(description, club);
        descriptionService.addClubToDescription(description, club);
    }

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


    // TODO: implement this
    @PutMapping(path = "addClubManagerToClub/{clubId}/{clubManagerId}")
    public void addClubManagerToClub(@PathVariable("clubId") Long clubId,
                                     @PathVariable("clubManagerId") Long clubManagerId) {
        // TODO

    }
}
