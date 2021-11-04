package com.example.demo.core.usecase;

import com.example.demo.inbound.api.dto.BeerDto;

public interface UpdateStockUseCase {
    BeerDto execute(BeerDto beer);
}
