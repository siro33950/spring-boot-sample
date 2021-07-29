package com.example.demo.adoptor.presenter.response;

import com.example.demo.domain.Abc166;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Abc166Response {

    String id;

    String input;

    String output;

    public static Abc166Response convert(Abc166 abc166) {
        return new Abc166Response(abc166.getId().toString(), abc166.getInput(), abc166.getOutput());
    }
}
