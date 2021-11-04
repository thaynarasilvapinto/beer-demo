package com.example.demo.core.usecase;

import com.example.demo.inbound.api.dto.BeerDto;

import java.util.List;

public interface FindBeerUseCase {

    List<BeerDto> execute();

}
