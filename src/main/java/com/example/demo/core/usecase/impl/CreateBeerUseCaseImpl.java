package com.example.demo.core.usecase.impl;

import com.example.demo.core.port.database.BeerPort;
import com.example.demo.core.usecase.CreateBeerUseCase;
import com.example.demo.inbound.api.dto.BeerDto;
import com.example.demo.commons.exceptions.BusinessException;
import com.example.demo.commons.utils.BeerUtil;
import com.example.demo.core.domain.Beer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class CreateBeerUseCaseImpl implements CreateBeerUseCase {

    private final BeerPort beerPort;

    @Autowired
    public CreateBeerUseCaseImpl(BeerPort beerPort) {
        this.beerPort = beerPort;
    }

    @Override
    public BeerDto execute(BeerDto beerDto) {

        Optional<Beer> valid = beerPort.findByNameAndCapacityAndTypeMeasures(beerDto.getName(), beerDto.getCapacity(), beerDto.getTypeMeasures());

        if(valid.isPresent()){
            throw new BusinessException("Beer already exists!", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        Beer beer = BeerUtil.beerDtoToBeer(beerDto);
        beer.setCreatedAt(LocalDateTime.now());

        beer = beerPort.saveAndFlush(beer);

        return BeerUtil.beerToBeerDto(beer);
    }

}