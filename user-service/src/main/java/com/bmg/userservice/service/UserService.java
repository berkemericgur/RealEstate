package com.bmg.userservice.service;

import com.bmg.userservice.dto.UserDto;
import com.bmg.userservice.entity.User;
import com.bmg.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public List<UserDto> getAll(){
        List<User> users = this.userRepository.findAll();

        List<UserDto> userDtoList = users.stream()
                .map(user -> this.modelMapper
                        .map(user, UserDto.class))
                .collect(Collectors.toList());

        return userDtoList;
    }

    public UserDto getById(String id){

        Optional<User> user = this.userRepository.findById(id);
        UserDto response = this.modelMapper
                .map(user, UserDto.class);

        return response;
    }

    public UserDto getByUsername(String username){

        User user = this.userRepository.findUserByUsername(username);
        UserDto response = this.modelMapper
                .map(user, UserDto.class);

        return response;
    }

    @Transactional
    public void saveUser(UserDto userDto){

        User user = User.builder()
                .username(userDto.getUsername())
                .firstname(userDto.getFirstname())
                .lastname(userDto.getLastname())
                .email(userDto.getEmail())
                .phoneNumber(userDto.getPhoneNumber())
                .build();

        this.userRepository.save(user);
    }

    @Transactional
    public User updateUser(String id, UserDto userDto) {

        User user = this.userRepository.findUserById(id);
        user.setUsername(userDto.getUsername());
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(userDto.getPhoneNumber());
        User userResponse = this.userRepository.save(user);

        return userResponse;
    }

    @Transactional
    public void deleteUser(String id){

        User user = this.userRepository.findUserById(id);
        this.userRepository.delete(user);
    }
}
