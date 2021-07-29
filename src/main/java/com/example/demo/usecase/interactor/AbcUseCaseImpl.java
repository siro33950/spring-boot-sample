package com.example.demo.usecase.interactor;

import com.example.demo.domain.Abc166;
import com.example.demo.domain.Abc166Repository;
import com.example.demo.usecase.inputport.AbcUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class AbcUseCaseImpl implements AbcUseCase {

    @Autowired
    private Abc166Repository abc166Repository;

    @Override
    public List<Abc166> fetch() {
        return abc166Repository.fetch();
    }

    @Override
    public Abc166 find(UUID id) {
        return abc166Repository.find(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public UUID createA(String input) {
        Abc166 abc166 = Abc166.createA(input);
        abc166Repository.register(abc166);
        return abc166.getId();
    }

    @Override
    public UUID createB(String input) {
        Abc166 abc166 = Abc166.createB(input);
        abc166Repository.register(abc166);
        return abc166.getId();
    }
}
