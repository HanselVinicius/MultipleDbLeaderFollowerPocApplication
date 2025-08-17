package com.vinicius.MutipleDbLeaderFollowerPoc.service.user;

import com.vinicius.MutipleDbLeaderFollowerPoc.entity.user.UserEntity;
import com.vinicius.MutipleDbLeaderFollowerPoc.entity.user.dto.UserReturnDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    UserReturnDto createUser(UserEntity user);

    Page<UserEntity> getUser(Pageable pageable);

}
