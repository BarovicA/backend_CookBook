package com.cookbook.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookbook.dto.AdminUserDTO;
import com.cookbook.entities.AdminUser;
import com.cookbook.entities.Role;
import com.cookbook.entities.enums.RoleENUM;
import com.cookbook.mappers.AdminMapper;
import com.cookbook.repositories.AdminUserRepository;
import com.cookbook.repositories.RoleRepository;
import com.cookbook.util.Encryption;
import com.cookbook.util.RESTError;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	AdminUserRepository adminUserRepository;
	@Autowired
	AdminMapper adminMapper;

	@Override
	public AdminUserDTO addAdmin(AdminUserDTO admin) {
		AdminUser adminUser= new AdminUser();
		Role r= roleRepository.findByName(RoleENUM.ADMIN_USER);
		adminUser.setFirstName(admin.getFirstName());
		adminUser.setLastName(admin.getLastName());
		adminUser.setUsername(admin.getUsername());
		adminUser.setPassword(Encryption.getPassEncoded(admin.getPassword()));
		adminUser.setRole(r);
		
		return adminMapper.toDto(adminUserRepository.save(adminUser));
	}

	@Override
	public AdminUserDTO modify(Long id, AdminUser admin) throws RESTError {
		if(adminUserRepository.existsById(id)) {
			AdminUser adminUser= new AdminUser();
			adminUser.setFirstName(admin.getFirstName());
			adminUser.setLastName(admin.getLastName());
			adminUser.setUsername(admin.getUsername());
			adminUser.setPassword(Encryption.getPassEncoded(admin.getPassword()));
			
			return adminMapper.toDto(adminUserRepository.save(adminUser));
		}
		throw new RESTError (1,"admin not exist");
		
	}

	@Override
	public AdminUser delete(Long id) throws RESTError {

		Optional<AdminUser> admin = adminUserRepository.findById(id);
		if (admin.isEmpty()) {
			throw new RESTError(1,"admin not exists");
		}
		AdminUser admin1 = admin.get();
		admin1.setDeleted(true);
		return adminUserRepository.save(admin1);
	}

}
