package cs319.spring.proje.berk.service;

import cs319.spring.proje.berk.entity.Admin;
import cs319.spring.proje.berk.repository.AdminRepository;
import cs319.spring.proje.berk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AdminService {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public boolean loginPasswordCheck(String email, String password) {
        Admin admin = adminRepository.findAdminByEmail(email);
        return admin != null && Objects.equals(admin.getPassword(), password);
    }
}
