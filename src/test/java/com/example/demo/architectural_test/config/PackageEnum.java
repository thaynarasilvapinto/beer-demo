package com.example.demo.architectural_test.config;

public enum PackageEnum {
    USE_CASE("com.example.demo.core.usecase"),
    PORT_DATABASE("com.example.demo.core.port.database"),
    DOMAIN("com.example.demo.core.domain"),
    INBOUND_API_CONTROLLER("com.example.demo.inbound.api.controller"),
    INBOUND_API_DTO("com.example.demo.inbound.api.dto"),
    OUTBOUND_DATABASE_ADAPTER("com.example.demo.outbound.database.adapter"),
    OUTBOUND_DATABASE_ENTITY("com.example.demo.outbound.database.entity"),
    OUTBOUND_DATABASE_REPOSITORY("com.example.demo.outbound.database.repository"),
    USE_CASE_IMPL("com.example.demo.core.usecase.impl");

    private final String description;

    PackageEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
