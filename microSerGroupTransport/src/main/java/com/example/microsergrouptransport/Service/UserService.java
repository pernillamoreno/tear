package com.example.microsergrouptransport.Service;

import com.example.microsergrouptransport.Repository.GroupRepository;
import com.example.microsergrouptransport.Repository.UserRepository;
import com.example.microsergrouptransport.model.Group;
import com.example.microsergrouptransport.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
    private UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }


}
