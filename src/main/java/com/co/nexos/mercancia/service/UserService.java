package com.co.nexos.mercancia.service;

import com.co.nexos.mercancia.domain.User;
import com.co.nexos.mercancia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> listaUsuarios() {
        return userRepository.findAll();
    }

}
