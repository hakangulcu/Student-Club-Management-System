package cs319.spring.proje.berk.controller;

import cs319.spring.proje.berk.entity.ClubAdvisor;
import cs319.spring.proje.berk.entity.User;
import cs319.spring.proje.berk.service.ClubAdvisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "clubAdvisors")
public class ClubAdvisorController {
    private final ClubAdvisorService clubAdvisorService;

    @Autowired
    public ClubAdvisorController(ClubAdvisorService clubAdvisorService) {
        this.clubAdvisorService = clubAdvisorService;
    }

    /*
    @GetMapping(path = "listAllAdvisors")
    public List<ClubAdvisor> listAllAdvisors() {
        return clubAdvisorService.listAllAdvisors();
    }

    @GetMapping(path = "getClubAdvisor/{clubAdvisorId}")
    public ClubAdvisor getClubAdvisor(@PathVariable("clubAdvisorId") Long clubAdvisorId) {
        return clubAdvisorService.getClubAdvisor(clubAdvisorId);
    }
    */
    /*
    @PutMapping(path = "addClubAdvisor")
    public void addClubAdvisor(@RequestBody ClubAdvisor clubAdvisor) {
        clubAdvisorService.addClubAdvisor(clubAdvisor);
    }

     */

    @GetMapping(path = "loginPasswordCheck/{email}/{password}")
    public boolean loginPasswordCheck(@PathVariable("email") String email,
                                      @PathVariable("password") String password) {
        return clubAdvisorService.loginPasswordCheck(email, password);
    }
}
