package com.vinicius.MutipleDbLeaderFollowerPoc.service.user;

import com.vinicius.MutipleDbLeaderFollowerPoc.entity.user.UserEntity;
import com.vinicius.MutipleDbLeaderFollowerPoc.entity.user.dto.UserReturnDto;

public interface UserService {
    UserReturnDto createUser(UserEntity user);
}
