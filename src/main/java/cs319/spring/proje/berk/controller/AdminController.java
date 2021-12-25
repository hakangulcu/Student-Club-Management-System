package cs319.spring.proje.berk.controller;

import cs319.spring.proje.berk.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "admins")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping(path = "loginPasswordCheck/{email}/{password}")
    public boolean loginPasswordCheck(@PathVariable("email") String email,
                                      @PathVariable("password") String password) {
        return adminService.loginPasswordCheck(email, password);
    }
}
