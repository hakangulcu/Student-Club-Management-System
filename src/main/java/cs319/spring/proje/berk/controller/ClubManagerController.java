package cs319.spring.proje.berk.controller;

import cs319.spring.proje.berk.entity.Activity;
import cs319.spring.proje.berk.entity.Club;
import cs319.spring.proje.berk.entity.ClubManager;
import cs319.spring.proje.berk.service.ClubManagerService;
import cs319.spring.proje.berk.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "clubManagers")
public class ClubManagerController {
    private final ClubManagerService clubManagerService;
    private final ClubService clubService;

    @Autowired
    public ClubManagerController(ClubManagerService clubManagerService, ClubService clubService) {
        this.clubManagerService = clubManagerService;
        this.clubService = clubService;
    }

    @GetMapping(path = "getClub/{clubManagerId}")
    public Club getClub(@PathVariable("clubManagerId") Long clubManagerId) {
        return clubManagerService.getClub(clubManagerId);
    }

    @GetMapping(path = "listClubManagers")
    public List<ClubManager> listClubManagers() {
        return clubManagerService.listClubManagers();
    }

    @GetMapping(path = "getClubManagerIdByEmail/{clubManagerEmail}")
    public Long getClubManagerIdByEmail(@PathVariable("clubManagerEmail") String email) {
        return clubManagerService.getClubManagerIdByEmail(email);
    }

    @GetMapping(path = "getClubManager/{clubManagerId}")
    public ClubManager getClubManager(@PathVariable("clubManagerId") Long clubManagerId) {
        return clubManagerService.getClubManager(clubManagerId);
    }

    @PutMapping(path = "addClubManager")
    public void addClubManager(@RequestBody ClubManager clubManager) {
        clubManagerService.addClubManager(clubManager);
    }

    @GetMapping(path = "loginPasswordCheck/{email}/{password}")
    public boolean loginPasswordCheck(@PathVariable("email") String email,
                                      @PathVariable("password") String password) {
        return clubManagerService.loginPasswordCheck(email, password);
    }

    @PutMapping(path = "addClubToClubManager/{clubId}/{clubManagerId}")
    public void addClubToClubManager(@PathVariable("clubId") Long clubId,
                                     @PathVariable("clubManagerId") Long clubManagerId) {
        Club club = clubService.getClub(clubId);
        clubManagerService.addClubToClubManager(club, clubManagerId);
    }
}
