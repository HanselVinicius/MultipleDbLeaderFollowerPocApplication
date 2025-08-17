package com.vinicius.MutipleDbLeaderFollowerPoc.service.user;

import com.vinicius.MutipleDbLeaderFollowerPoc.entity.user.UserEntity;
import com.vinicius.MutipleDbLeaderFollowerPoc.entity.user.UserRepository;
import com.vinicius.MutipleDbLeaderFollowerPoc.entity.user.dto.UserReturnDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserReturnDto createUser(UserEntity user) {
        UserEntity savedUser = this.userRepository.save(user);
        return UserReturnDto.fromEntity(savedUser);
    }

    @Transactional(readOnly = true)
    public Page<UserEntity> getUser(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }


}
