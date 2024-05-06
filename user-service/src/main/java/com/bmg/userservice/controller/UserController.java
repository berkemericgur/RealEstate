package com.bmg.userservice.controller;

import com.bmg.userservice.dto.UserDto;
import com.bmg.userservice.entity.User;
import com.bmg.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<UserDto>> getAll(){

        return ResponseEntity.ok(this.userService.getAll());

    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable("id") String id){

        return ResponseEntity.ok(this.userService.getById(id));
    }

    @GetMapping(value = "/getByUsername/{username}")
    public ResponseEntity<UserDto> getByUsername(@PathVariable("username") String username){

        return ResponseEntity.ok(this.userService.getByUsername(username));
    }

    @PostMapping(value = "/addUser")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody UserDto userDto){

         this.userService.saveUser(userDto);
    }

    @PutMapping(value = "/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") String id ,@RequestBody UserDto userDto){

        return ResponseEntity.ok(this.userService.updateUser(id, userDto));
    }

    @DeleteMapping(value = "/deleteUser/{id}")
    public void deleteUser(@PathVariable("id") String id){
        this.userService.deleteUser(id);
    }
}
