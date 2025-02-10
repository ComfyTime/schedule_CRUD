package org.example.schedule_crud.dto;

import lombok.Getter;

@Getter
public class ScheduleResponseDto {

    private final Long id;
    private final String date;

    public ScheduleResponseDto(Long id, String date) {
        this.id = id;
        this.date = date;

    }
}
