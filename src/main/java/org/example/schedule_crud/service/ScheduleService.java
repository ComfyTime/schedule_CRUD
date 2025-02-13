package org.example.schedule_crud.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.schedule_crud.dto.ScheduleResponseDto;
import org.example.schedule_crud.entity.Schedule;
import org.example.schedule_crud.entity.User;
import org.example.schedule_crud.repository.ScheduleRepository;
import org.example.schedule_crud.repository.UserRepository;
import org.hibernate.mapping.List;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    @Transactional
    public ScheduleResponseDto save(ScheduleResponseDto dto) {
        User user = userRepository.findById(dto.getUserId()).orElseThrow(
                () -> new IllegalStateException("없는 유저")
        );

        Schedule schedule = new Schedule(dto.getCreatedAte(), user);
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleResponseDto(savedSchedule.getId(), savedSchedule.getCreatedAte(), savedSchedule.getModifiedAte(), savedSchedule.getName(), savedSchedule.getTitle(), savedSchedule.getContent());
    }

    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();

        List<ScheduleResponseDto> dtos = new ArrayList<>();
        for (Schedule schedule : schedules) {
            dtos.add(new ScheduleResponseDto(schedule.getId(), schedule.getCreatedAte(), schedule.getModifiedAte(), schedule.getName(), schedule.getTitle(), schedule.getContent()));
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public ScheduleResponseDto findById(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("none")

        );
        return new ScheduleResponseDto(schedule.getId(), schedule.getCreatedAte(), schedule.getModifiedAte(), schedule.getName(), schedule.getTitle(), schedule.getContent());
    }

    @Transactional
    public ScheduleResponseDto update(Long id, ScheduleResponseDto dto) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("none")
        );
        schedule.update(dto.getModifiedAte());
        return new ScheduleResponseDto(schedule.getId(), schedule.getCreatedAte(), schedule.getModifiedAte(), schedule.getName(), schedule.getTitle(), schedule.getContent());
    }

    @Transactional
    public void deleteById(Long id) {
        if (!scheduleRepository.existsById(id)) {
            throw new IllegalArgumentException("none");
        }
        scheduleRepository.deleteById(id);
    }
}
