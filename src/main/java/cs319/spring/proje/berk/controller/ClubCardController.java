package cs319.spring.proje.berk.controller;

import cs319.spring.proje.berk.entity.Activity;
import cs319.spring.proje.berk.entity.ClubCard;
import cs319.spring.proje.berk.service.ClubCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "clubCards")
public class ClubCardController {
    private final ClubCardService clubCardService;

    @Autowired
    public ClubCardController(ClubCardService clubCardService) {
        this.clubCardService = clubCardService;
    }

    @GetMapping(path = "listClubCards")
    public List<ClubCard> listClubCards() {
        return clubCardService.listClubCards();
    }

    @GetMapping(path = "getClubCard/{clubCardId}")
    public ClubCard getClubCard(@PathVariable("clubCardId") Long id) {
        return clubCardService.getClubCard(id);
    }

    @PutMapping(path = "addNewClubCard")
    public void addNewClubCard(@RequestBody ClubCard clubCard) {
        clubCardService.addClubCard(clubCard);
    }

    @DeleteMapping(path = "deleteClubCard/{clubCardId}")
    public void deleteClubCard(@PathVariable("clubCardId") Long id) {
        clubCardService.deleteClubCard(id);
    }
}
