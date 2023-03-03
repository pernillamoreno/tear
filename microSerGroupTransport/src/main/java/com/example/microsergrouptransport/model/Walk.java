package com.example.microsergrouptransport.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "walk")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Walk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="walkId")
    private Long walkId;

    @Column(name="walkName")
    private String walkName;
}
