package ru.dzheb.clinic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import ru.dzheb.clinic.model.Role;
import ru.dzheb.clinic.model.User;
import ru.dzheb.clinic.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
@EnableConfigurationProperties(DoctorProperties.class)
public class ClinicApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(ClinicApplication.class, args);
        DoctorProperties doctorProperties = context.getBean(DoctorProperties.class);
        log.info("max-allowed-appointments: {}", doctorProperties.getMaxAllowedAppointments());
        log.info("min-appointment-interval: {}", doctorProperties.getMinAppointmentInterval());
        log.info("tags: {}", doctorProperties.getTags());
//        UserRepository userRepository = context.getBean(UserRepository.class);
//        userRepository.save(createAdmin());
    }

//    private static User createAdmin() {
//        User admin = new User();
//        admin.setLogin("admin");
//        admin.setPassword("admin");
//        Role role1 = new Role();
//        role1.setRole("admin");
//        Role role2 = new Role();
//        role2.setRole("user");
//        List<Role> roles = new ArrayList<>();
//        roles.add(role1);
//        roles.add(role2);
//        admin.setRoles(roles);
//        return admin;
//
//    }

}
