package com.example.demo.core.domain;

import com.example.demo.commons.enums.TypeMeasures;

import java.time.LocalDateTime;

public class Beer {

    private Long id;
    private String name;
    private String brand;
    private Integer amount;
    private Double capacity;
    private TypeMeasures typeMeasures;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public TypeMeasures getTypeMeasures() {
        return typeMeasures;
    }

    public void setTypeMeasures(TypeMeasures typeMeasures) {
        this.typeMeasures = typeMeasures;
    }
}
