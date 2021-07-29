package com.example.demo.adoptor.controller.api;

import com.example.demo.adoptor.controller.form.Abc166Form;
import com.example.demo.adoptor.presenter.response.Abc166Response;
import com.example.demo.usecase.inputport.AbcUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(
        value = "/abc166",
        produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class Abc166Controller {

    @Autowired
    AbcUseCase abcUseCase;

    @GetMapping
    public List<Abc166Response> fetch() {
        return abcUseCase.fetch().stream().map(Abc166Response::convert).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Abc166Response find(@Validated @PathVariable String id) {
        return Abc166Response.convert(abcUseCase.find(UUID.fromString(id)));
    }

    @PostMapping("/a")
    @ResponseStatus(HttpStatus.CREATED)
    public String createA(@Validated @RequestBody Abc166Form form) {
        return abcUseCase.createA(form.getInput()).toString();
    }

    @PostMapping("/b")
    @ResponseStatus(HttpStatus.CREATED)
    public String createB(@Validated @RequestBody Abc166Form form) {
        return abcUseCase.createB(form.getInput()).toString();
    }
}
