package com.vinicius.MutipleDbLeaderFollowerPoc.service.user;

import com.vinicius.MutipleDbLeaderFollowerPoc.entity.user.UserEntity;
import com.vinicius.MutipleDbLeaderFollowerPoc.entity.user.UserRepository;
import com.vinicius.MutipleDbLeaderFollowerPoc.entity.user.dto.UserReturnDto;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserReturnDto createUser(UserEntity user) {
        UserEntity savedUser = this.userRepository.save(user);
        return UserReturnDto.fromEntity(savedUser);
    }
}
