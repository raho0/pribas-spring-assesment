package com.pribas.pribas.service;

import com.pribas.pribas.entity.UserEntity;
import com.pribas.pribas.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserEntityRepository userEntityRepository;

    public void add(UserEntity user) {
        userEntityRepository.save(user);
    }

    public void delete(long id) {
        userEntityRepository.deleteById(id);
    }

    public List<UserEntity> get(){
        return userEntityRepository.findAll();
    }
}
