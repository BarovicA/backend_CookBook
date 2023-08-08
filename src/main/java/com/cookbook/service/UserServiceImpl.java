package com.cookbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cookbook.dto.UserDTO;
//import com.cookbook.entities.User;
//import com.cookbook.mappers.UserMapper;
//import com.cookbook.repositories.UserRepository;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//	@Autowired
//	private UserMapper userMapper;
//
//	@Autowired
//	private UserRepository userRepository;
//
//	@Override
//	public UserDTO addUser(UserDTO userDTO) {
//		User userEntity = userMapper.toEntity(userDTO);
//		User savedUserEntity = userRepository.save(userEntity);
//		return userMapper.toDto(savedUserEntity);
//	}
//}
