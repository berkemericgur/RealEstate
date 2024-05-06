package com.bmg.userservice.repository;

import com.bmg.userservice.dto.UserDto;
import com.bmg.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    List<User> findAll();
    User findUserByUsername(String username);
    User findUserById(String id);
}
