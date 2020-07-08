package com.etiya.exercise.service.impl;

import com.etiya.exercise.entity.User;
import com.etiya.exercise.repository.UserRepository;
import com.etiya.exercise.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public User save(User user) {
        if(user.getEmail()==null)
        {
            throw new IllegalArgumentException("User email code cant be null");
        }
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(User user) {
        userRepository.delete(user);
        return Boolean.TRUE;
    }

    @Override
    public User getByUsername(String username) {
        return null;
    }
}
