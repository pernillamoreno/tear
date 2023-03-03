package com.example.microsergrouptransport.Repository;

import com.example.microsergrouptransport.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {

    List<Group> findAll();

    Group save(Group group);

    Group findByName(String groupName);
}
