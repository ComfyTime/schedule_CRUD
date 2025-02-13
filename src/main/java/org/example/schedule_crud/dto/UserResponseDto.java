package org.example.schedule_crud.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseDto {
    private final Long id;
    private final String name;
    private final String email;
    private LocalDateTime createdAte;
    private LocalDateTime modifiedAte;
    private String password;

    public UserResponseDto(Long id, String name, String email, LocalDateTime createdAte, LocalDateTime modifiedAte, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdAte = createdAte;
        this.modifiedAte = modifiedAte;
        this.password = password;
    }
}
