package com.vinicius.MutipleDbLeaderFollowerPoc.entity.user;

import com.vinicius.MutipleDbLeaderFollowerPoc.entity.comment.CommentEntity;
import com.vinicius.MutipleDbLeaderFollowerPoc.entity.user.dto.CreateUserDto;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CommentEntity> comment;
    @CreationTimestamp
    private LocalDateTime createdDate;
    @UpdateTimestamp
    private LocalDateTime updatedDate;

    public UserEntity() {
    }

    public UserEntity(Long id, String username, List<CommentEntity> comment, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.id = id;
        this.username = username;
        this.comment = comment;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public static UserEntity fromCreateUserDto(CreateUserDto createUserDto) {
        return new UserEntity(null,createUserDto.username(),null,null,null);
    }


    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public List<CommentEntity> getComment() {
        return comment;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }
}
