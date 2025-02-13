package org.example.schedule_crud.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@RequiredArgsConstructor
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createdAte;
    private LocalDateTime modifiedAte;
    private String name;
    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Schedule(LocalDateTime createdAte, String name, String title, String content, User user) {
        this.createdAte = createdAte;
        this.name = name;
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public void update(LocalDateTime createdAte) {
        this.createdAte = createdAte;
        this.modifiedAte = modifiedAte;
        this.name = name;
        this.title = title;
        this.content = content;
    }
}
