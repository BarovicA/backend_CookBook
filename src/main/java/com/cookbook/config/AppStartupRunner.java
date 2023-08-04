package com.cookbook.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cookbook.entities.Role;
import com.cookbook.entities.enums.RoleENUM;
import com.cookbook.repositories.RoleRepository;

@Configuration
public class AppStartupRunner {
	
	@Autowired
    RoleRepository roleRepository;

    @Bean
    public ApplicationRunner initializer() {
        return args -> {
            if (roleRepository.count() == 0) { // provera da li je tabela prazna
                // inicijalizacija Role entiteta
                for (RoleENUM roleEnum : RoleENUM.values()) {
                    Role role = new Role();
                    role.setName(roleEnum);
                    roleRepository.save(role);
                }
            }
        };
    }

}
