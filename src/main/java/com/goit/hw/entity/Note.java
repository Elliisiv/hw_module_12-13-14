package com.goit.hw.entity;


import jakarta.persistence.*;
import lombok.Data;

@Table(name = "note")
@Entity
@Data
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;


}
