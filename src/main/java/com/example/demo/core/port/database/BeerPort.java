package com.example.demo.core.port.database;

import com.example.demo.commons.enums.TypeMeasures;
import com.example.demo.core.domain.Beer;

import java.util.List;
import java.util.Optional;

public interface BeerPort {

    Beer saveAndFlush(Beer beer);

    Optional<Beer> findById(Long id);

    List<Beer> findAll();

    Optional<Beer> findByNameAndCapacityAndTypeMeasures(String name, Double capacity, TypeMeasures typeMeasures);
}
