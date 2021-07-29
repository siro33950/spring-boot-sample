package com.example.demo.domain;

import com.example.demo.domain.Abc166;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Abc166Repository {

    List<Abc166> fetch();

    Optional<Abc166> find(UUID id);

    void register(Abc166 abc166);
}
