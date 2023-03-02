package com.example.microsergrouptransport.Repository;

import com.example.microsergrouptransport.model.Group;
import com.example.microsergrouptransport.model.Walk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalkRepository extends JpaRepository<Walk, Long> {

    Walk save(Walk walk);

    void removeById(Long walkId);
}
