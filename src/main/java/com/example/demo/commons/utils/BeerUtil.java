package com.example.demo.commons.utils;

import com.example.demo.core.domain.Beer;
import com.example.demo.inbound.api.dto.BeerDto;
import com.example.demo.outbound.database.entity.BeerEntity;

public final class BeerUtil {

    public static BeerEntity beerToBeerEntity(Beer beer){
        BeerEntity beerEntity = new BeerEntity();
        beerEntity.setId(beer.getId());
        beerEntity.setName(beer.getName());
        beerEntity.setBrand(beer.getBrand());
        beerEntity.setAmount(beer.getAmount());
        beerEntity.setCapacity(beer.getCapacity());
        beerEntity.setTypeMeasures(beer.getTypeMeasures());
        beerEntity.setCreatedAt(beer.getCreatedAt());
        beerEntity.setUpdatedAt(beer.getUpdatedAt());
        return beerEntity;
    }

    public static  Beer beerEntityToBeer(BeerEntity beerEntity){
        Beer beer = new Beer();
        beer.setId(beerEntity.getId());
        beer.setName(beerEntity.getName());
        beer.setBrand(beerEntity.getBrand());
        beer.setAmount(beerEntity.getAmount());
        beer.setCapacity(beerEntity.getCapacity());
        beer.setTypeMeasures(beerEntity.getTypeMeasures());
        beer.setCreatedAt(beerEntity.getCreatedAt());
        beer.setUpdatedAt(beerEntity.getUpdatedAt());
        return beer;
    }

    public static  Beer beerDtoToBeer(BeerDto beerDto){
        Beer beer = new Beer();
        beer.setName(beerDto.getName());
        beer.setBrand(beerDto.getBrand());
        beer.setAmount(beerDto.getAmount());
        beer.setCapacity(beerDto.getCapacity());
        beer.setTypeMeasures(beerDto.getTypeMeasures());
        return beer;
    }

    public static  BeerDto beerToBeerDto(Beer beer){
        BeerDto beerDto = new BeerDto();
        beerDto.setId(beer.getId());
        beerDto.setName(beer.getName());
        beerDto.setBrand(beer.getBrand());
        beerDto.setAmount(beer.getAmount());
        beerDto.setCapacity(beer.getCapacity());
        beerDto.setTypeMeasures(beer.getTypeMeasures());
        beerDto.setCreatedAt(beer.getCreatedAt());
        beerDto.setUpdatedAt(beer.getUpdatedAt());
        return beerDto;
    }

}
