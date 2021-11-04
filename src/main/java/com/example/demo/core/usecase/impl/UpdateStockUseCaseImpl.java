package com.example.demo.core.usecase.impl;

import com.example.demo.commons.exceptions.BusinessException;
import com.example.demo.core.port.database.BeerPort;
import com.example.demo.inbound.api.dto.BeerDto;
import com.example.demo.commons.utils.BeerUtil;
import com.example.demo.core.domain.Beer;
import com.example.demo.core.usecase.UpdateStockUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UpdateStockUseCaseImpl implements UpdateStockUseCase {

    private final BeerPort beerPort;

    @Autowired
    public UpdateStockUseCaseImpl(BeerPort beerPort) {
        this.beerPort = beerPort;
    }

    @Override
    public BeerDto execute(BeerDto beerDto) {

        Beer beer = beerPort.findById(beerDto.getId())
                .orElseThrow(() -> new BusinessException("Beer not exists!", HttpStatus.UNPROCESSABLE_ENTITY));

        beer.setAmount(beer.getAmount() + beerDto.getAmount());
        beer.setUpdatedAt(LocalDateTime.now());

        beer = beerPort.saveAndFlush(beer);

        return BeerUtil.beerToBeerDto(beer);
    }
}
