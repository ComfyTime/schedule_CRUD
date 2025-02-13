package org.example.schedule_crud.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.schedule_crud.dto.UserRequestDto;
import org.example.schedule_crud.dto.UserResponseDto;
import org.example.schedule_crud.entity.User;
import org.example.schedule_crud.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto save(UserRequestDto dto) {
        User user = new User(dto.getName());
        User savedUser = userRepository.save(User);
        return new UserResponseDto(savedUser.getId(), savedUser.getName(), savedUser.getEmail(), savedUser.getCreatedAte(), savedUser.getModifiedAte());
    }
    @Transactional(readOnly = true)
    public List<UserResponseDto> findAll() {
       List<User> users = userRepository.findAll();
       List<UserResponseDto> dtos = new ArrayList<>();
        for (User user : users) {
            dtos.add(new UserResponseDto(user.getId(), user.getName(), user.getEmail(), user.getCreatedAte(), user.getModifiedAte(), user.getPassword()));
        }
        return dtos;
    }
    @Transactional
    public UserRequestDto findById(Long id) {
        User user = UserRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("none")
        );
        return new UserResponseDto(user.getId(), user.getName(), user.getEmail(), user.getCreatedAte(), user.getModifiedAte(), user.getPassword());
    }
    @Transactional
    public UserResponseDto update(Long id, UserResponseDto dto) {
        User user =UserRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("none")
        );
        user.update(dto.getModifiedAte());
        return new UserResponseDto(user.getId(), user.getName(), user.getEmail(), user.getCreatedAte(), user.getModifiedAte(), user.getPassword());
    }
    @Transactional
    public void deleteById(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("none");
        }
        userRepository.deleteById(id);
    }
}
