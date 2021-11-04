package com.example.demo.core.usecase.impl;

import com.example.demo.commons.utils.BeerUtil;
import com.example.demo.core.domain.Beer;
import com.example.demo.core.port.database.BeerPort;
import com.example.demo.core.usecase.FindBeerUseCase;
import com.example.demo.inbound.api.dto.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindBeerUseCaseImpl implements FindBeerUseCase {

    private final BeerPort beerPort;

    @Autowired
    public FindBeerUseCaseImpl(BeerPort beerPort) {
        this.beerPort = beerPort;
    }

    @Override
    public List<BeerDto> execute() {
        List<Beer> beers = beerPort.findAll();
        return beers.stream().map(BeerUtil::beerToBeerDto).collect(Collectors.toList());
    }
}
