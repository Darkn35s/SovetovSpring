package org.sadtech.example.swagger.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.sadtech.example.swagger.Entities.StudentEnt;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author upagge 30.12.2020
 */
@RestController
@RequestMapping("api/secret")
@Hidden
@Tag(name = "Секретный контролер")
public class HideExample {

    private final Map<String, StudentEnt> repository;

    public HideExample(Map<String, StudentEnt> repository) {
        this.repository = repository;
    }

    @GetMapping(value = "destroy")
    public HttpStatus destroy() {
        repository.clear();
        return HttpStatus.OK;
    }

}
