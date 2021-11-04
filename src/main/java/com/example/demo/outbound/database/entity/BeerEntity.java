package com.example.demo.outbound.database.entity;

import com.example.demo.commons.enums.TypeMeasures;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "beer")
@Entity
public class BeerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @NotNull
    private String name;

    @Column
    private String brand;

    @Column
    private Integer amount;

    @Column
    private Double capacity;

    @Column(name = "type_measures")
    @Enumerated(EnumType.STRING)
    private TypeMeasures typeMeasures;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public BeerEntity() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
