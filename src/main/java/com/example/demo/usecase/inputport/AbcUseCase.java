package com.example.demo.usecase.inputport;

import com.example.demo.domain.Abc166;

import java.util.List;
import java.util.UUID;

public interface AbcUseCase {

    List<Abc166> fetch();

    Abc166 find(UUID id);

    UUID createA(String input);

    UUID createB(String input);
}
