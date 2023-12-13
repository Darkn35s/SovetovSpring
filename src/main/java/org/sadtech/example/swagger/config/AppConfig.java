package org.sadtech.example.swagger.config;

import org.sadtech.example.swagger.Entities.Gender;
import org.sadtech.example.swagger.Entities.StudentEnt;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Configuration
public class AppConfig {

    @Bean
    public Map<String, StudentEnt> userRepository() {
        return Stream.of(
                StudentEnt.of("key1", "value1", Gender.MALE),
                StudentEnt.of("key2", "value2", Gender.FEMALE)
        ).collect(Collectors.toMap(StudentEnt::getKey, userDto -> userDto));
    }

}
