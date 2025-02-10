package org.example.schedule_crud.controller;

import lombok.RequiredArgsConstructor;
import org.example.schedule_crud.dto.ScheduleRequestDto;
import org.example.schedule_crud.dto.ScheduleResponseDto;
import org.example.schedule_crud.service.ScheduleService;
import org.hibernate.mapping.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schdules")
    public ScheduleResponseDto save(@RequestBody ScheduleResponseDto dto) {
        return scheduleService.save(dto);
    }
    @GetMapping("/schdules")
    public List<ScheduleResponseDto> findAll() {
        return scheduleService.findAll();
    }
    @GetMapping("/schdules/{id}")
    public ScheduleResponseDto findOne(@PathVariable Long id) {
        return scheduleService.findById(id);


    }

    @PutMapping("/schdules/{id}")
    public ScheduleResponseDto update(@PathVariable Long id, @RequestBody ScheduleResponseDto dto) {
        return scheduleService.update(id, dto);
    }
    @DeleteMapping("/schdules/{id}")
    public void delete(@PathVariable Long id) {
        scheduleService.deleteById(id);
    }
}
