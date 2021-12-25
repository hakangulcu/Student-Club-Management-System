package cs319.spring.proje.berk.controller;

import cs319.spring.proje.berk.entity.Club;
import cs319.spring.proje.berk.entity.ClubManager;
import cs319.spring.proje.berk.service.ClubManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "clubManagers")
public class ClubManagerController {
    private final ClubManagerService clubManagerService;

    @Autowired
    public ClubManagerController(ClubManagerService clubManagerService) {
        this.clubManagerService = clubManagerService;
    }

    @GetMapping(path = "getClub/{clubManagerId}")
    public Club getClub(@PathVariable("clubManagerId") Long clubManagerId) {
        return clubManagerService.getClub(clubManagerId);
    }

    @GetMapping(path = "getClubManagerIdByEmail/{clubManagerEmail}")
    public Long getClubManagerIdByEmail(@PathVariable("clubManagerEmail") String email) {
        return clubManagerService.getClubManagerIdByEmail(email);
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
}
