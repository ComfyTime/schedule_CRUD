package org.example.schedule_crud.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {

    private final Long id;
    private final LocalDateTime createdAte;
    private final LocalDateTime modifiedAte;
    private final String name;
    private String title;
    private String content;

    public ScheduleResponseDto(Long id, LocalDateTime createdAte, LocalDateTime modifiedAte, String name, String title, String content) {
        this.id = id;
        this.createdAte = createdAte;
        this.modifiedAte = modifiedAte;
        this.name = name;
        this.title = title;
        this.content = content;

    }
}
