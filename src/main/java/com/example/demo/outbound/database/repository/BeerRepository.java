package com.example.demo.outbound.database.repository;

import com.example.demo.commons.enums.TypeMeasures;
import com.example.demo.outbound.database.entity.BeerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BeerRepository extends JpaRepository<BeerEntity, Long> {

    Optional<BeerEntity> findByNameAndCapacityAndTypeMeasures(String name, Double capacity, TypeMeasures typeMeasures);
}
