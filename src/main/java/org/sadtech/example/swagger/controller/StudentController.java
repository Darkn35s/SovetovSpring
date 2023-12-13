package org.sadtech.example.swagger.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.sadtech.example.swagger.Entities.StudentEnt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

/**
 * @author upagge 30.12.2020
 */
@RestController
@RequestMapping("/api/user")
@Tag(name = "Студенты", description = "Управление студентами")
public class StudentController {

    private final Map<String, StudentEnt> repository;

    public StudentController(Map<String, StudentEnt> repository) {
        this.repository = repository;
    }

    @PutMapping(produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "Регистрация студента", description = "Добавить студента")
    public HttpStatus registerUser(@RequestBody StudentEnt studentEnt) {
        repository.put(studentEnt.getKey(), studentEnt);
        return HttpStatus.OK;
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "Обновление студента")
    public HttpStatus updateUser(@RequestBody StudentEnt studentEnt) {
        if (!repository.containsKey(studentEnt.getKey())) return HttpStatus.NOT_FOUND;
        repository.put(studentEnt.getKey(), studentEnt);
        return HttpStatus.OK;
    }

    @GetMapping(value = "{key}", produces = APPLICATION_JSON_VALUE)
    @Operation(summary = "Получить студента")
    public ResponseEntity<StudentEnt> getSimpleDto(@PathVariable("key") String key) {
        return ResponseEntity.ok(repository.get(key));
    }

}
