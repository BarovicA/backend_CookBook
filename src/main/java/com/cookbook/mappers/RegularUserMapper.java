package com.cookbook.mappers;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cookbook.dto.AdminUserDTO;
import com.cookbook.dto.RegularUserDTO;
import com.cookbook.entities.AdminUser;
import com.cookbook.entities.RegularUser;

@Component
@Service
public class RegularUserMapper implements GenericMapper<RegularUser, RegularUserDTO> {
	
	@Override
    public RegularUser toEntity(RegularUserDTO dto) {
        return new RegularUser(dto);
    }

    @Override
    public RegularUserDTO toDto(RegularUser entity) {
        return new RegularUserDTO(entity);
    }
	
    
   
	
	
}
