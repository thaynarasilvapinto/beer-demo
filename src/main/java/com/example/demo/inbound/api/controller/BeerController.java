package com.example.demo.inbound.api.controller;

import com.example.demo.core.usecase.CreateBeerUseCase;
import com.example.demo.core.usecase.UpdateStockUseCase;
import com.example.demo.inbound.api.dto.BeerDto;
import com.example.demo.core.usecase.FindBeerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beer")
public class BeerController {

    private final CreateBeerUseCase createBeerUseCase;
    private final FindBeerUseCase findBeerUseCase;
    private final UpdateStockUseCase updateStockUseCase;

    @Autowired
    public BeerController(CreateBeerUseCase createBeerUseCase, FindBeerUseCase findBeerUseCase, UpdateStockUseCase updateStockUseCase) {
        this.createBeerUseCase = createBeerUseCase;
        this.findBeerUseCase = findBeerUseCase;
        this.updateStockUseCase = updateStockUseCase;
    }

    @PostMapping
    public ResponseEntity<BeerDto> create(BeerDto beerDto) {
        return new ResponseEntity<>(createBeerUseCase.execute(beerDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BeerDto>> findAll() {
        return new ResponseEntity<>(findBeerUseCase.execute(), HttpStatus.OK);
    }

    @PutMapping("/stock")
    public ResponseEntity<BeerDto> update(BeerDto beerDto) {
        return new ResponseEntity<>(updateStockUseCase.execute(beerDto), HttpStatus.ACCEPTED);
    }
}
