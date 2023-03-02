package com.example.microsergrouptransport.Repository;

import com.example.microsergrouptransport.model.Group;
import com.example.microsergrouptransport.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User save(User user);
}
