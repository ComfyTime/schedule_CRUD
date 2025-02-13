package org.example.schedule_crud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private LocalDateTime createdAte;
    private LocalDateTime modifiedAte;

    public User(String name) {
        this.name = name;
        this.email = email;
        this.createdAte = createdAte;
        this.modifiedAte = modifiedAte;
    }
}
