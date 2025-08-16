package com.vinicius.MutipleDbLeaderFollowerPoc.controller;

import com.vinicius.MutipleDbLeaderFollowerPoc.entity.user.UserEntity;
import com.vinicius.MutipleDbLeaderFollowerPoc.entity.user.dto.CreateUserDto;
import com.vinicius.MutipleDbLeaderFollowerPoc.entity.user.dto.UserReturnDto;
import com.vinicius.MutipleDbLeaderFollowerPoc.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<UserReturnDto> createUser(@RequestBody CreateUserDto user) {
        UserReturnDto createdUser = userService.createUser(UserEntity.fromCreateUserDto(user));
        return ResponseEntity.ok(createdUser);
    }

}
