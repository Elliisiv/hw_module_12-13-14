package com.goit.hw.entity;

import com.goit.hw.service.NoteService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializationConfig {

    @Bean
    public ApplicationRunner dataInitializer(NoteService noteService) {
        return args -> {
            noteService.add(new Note(1l,"FirstTitle", "Contetnt"));
            noteService.add(new Note(2l,"SecondTitle", "Contetnt"));
            noteService.add(new Note(3l,"ThirdTitle", "Contetnt"));

        };
    }
}
