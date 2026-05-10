package com.green.users.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.green.users.dto.UserDTO;

@Mapper
public interface UserMapper {

	List<UserDTO> getUserList();

	void insertUser(UserDTO userDTO);

	UserDTO getIdDupCheck(UserDTO userDTO);

	UserDTO getUser(UserDTO userDTO);

}
