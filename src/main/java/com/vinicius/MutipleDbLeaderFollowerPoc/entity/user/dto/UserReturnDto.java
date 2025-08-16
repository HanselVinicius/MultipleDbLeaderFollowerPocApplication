package com.vinicius.MutipleDbLeaderFollowerPoc.entity.user.dto;

import com.vinicius.MutipleDbLeaderFollowerPoc.entity.comment.CommentEntity;
import com.vinicius.MutipleDbLeaderFollowerPoc.entity.user.UserEntity;

import java.time.LocalDateTime;
import java.util.List;

public record UserReturnDto(
        Long id,
        String username,
        List<Long> commentIds,
        LocalDateTime createdDate,
        LocalDateTime updatedDate
) {

    public static UserReturnDto fromEntity(UserEntity userEntity) {
        List<Long> idList = userEntity.getComment() != null ?  userEntity.getComment().stream().map(CommentEntity::getId).toList() : null;
        return new UserReturnDto(userEntity.getId(),userEntity.getUsername(),idList,userEntity.getCreatedDate(),userEntity.getUpdatedDate());
    }

}
