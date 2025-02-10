package org.example.schedule_crud.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.schedule_crud.dto.ScheduleRequestDto;
import org.example.schedule_crud.dto.ScheduleResponseDto;
import org.example.schedule_crud.entity.Schedule;
import org.example.schedule_crud.repository.ScheduleRepository;
import org.hibernate.mapping.Array;
import org.hibernate.mapping.List;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleResponseDto save(ScheduleResponseDto dto) {
        Schedule schedule = new Schedule(dto.getDate());
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(savedSchedule.getId(), savedSchedule.getDate());
    }

    public List<ScheduleResponseDto> findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();

        List<ScheduleResponseDto> dtos = new ArrayList<>();
        for (Schedule schedule : schedules) {
            dtos.add(new ScheduleResponseDto(schedule.getId(), schedule.getDate()));
        }
        return dtos;
    }

    public ScheduleResponseDto findById(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("none")

        );
        return new ScheduleResponseDto(schedule.getId(), schedule.getDate());
    }

    public ScheduleResponseDto update(Long id, ScheduleResponseDto dto) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("none")

        );
        schedule.update(dto.getDate());
        return new ScheduleResponseDto(schedule.getId(), schedule.getDate());
    }
    public void deleteById(Long id) {
        if (!scheduleRepository.existsById(id)) {
            throw new IllegalArgumentException("none");
        }
        scheduleRepository.deleteById(id);
    }
}
