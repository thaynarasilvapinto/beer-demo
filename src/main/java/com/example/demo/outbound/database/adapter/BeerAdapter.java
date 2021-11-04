package com.example.demo.outbound.database.adapter;

import com.example.demo.commons.enums.TypeMeasures;
import com.example.demo.commons.utils.BeerUtil;
import com.example.demo.core.domain.Beer;
import com.example.demo.core.port.database.BeerPort;
import com.example.demo.outbound.database.entity.BeerEntity;
import com.example.demo.outbound.database.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BeerAdapter implements BeerPort {

    private final BeerRepository beerRepository;

    @Autowired
    public BeerAdapter(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public Beer saveAndFlush(Beer beer) {
        BeerEntity beerEntity = BeerUtil.beerToBeerEntity(beer);
        beerEntity = beerRepository.saveAndFlush(beerEntity);
        return BeerUtil.beerEntityToBeer(beerEntity);
    }

    @Override
    public Optional<Beer> findById(Long id) {
        Optional<BeerEntity> beerEntity = beerRepository.findById(id);
        return beerEntity.map(BeerUtil::beerEntityToBeer);
    }

    @Override
    public List<Beer> findAll() {
        List<BeerEntity> beerEntityList = beerRepository.findAll();
        return beerEntityList.stream().map(BeerUtil::beerEntityToBeer).collect(Collectors.toList());
    }

    @Override
    public Optional<Beer> findByNameAndCapacityAndTypeMeasures(String name, Double capacity, TypeMeasures typeMeasures) {
        Optional<BeerEntity> beerEntity = beerRepository.findByNameAndCapacityAndTypeMeasures(name, capacity, typeMeasures);
        return beerEntity.map(BeerUtil::beerEntityToBeer);
    }

}
