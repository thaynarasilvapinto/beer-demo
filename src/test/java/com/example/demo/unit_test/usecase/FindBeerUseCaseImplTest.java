package com.example.demo.unit_test.usecase;

import com.example.demo.core.port.database.BeerPort;
import com.example.demo.commons.enums.TypeMeasures;
import com.example.demo.core.domain.Beer;
import com.example.demo.core.usecase.impl.FindBeerUseCaseImpl;
import com.example.demo.inbound.api.dto.BeerDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.tuple;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ContextConfiguration
public class FindBeerUseCaseImplTest {

    @Mock
    private BeerPort beerPort;

    @InjectMocks
    private FindBeerUseCaseImpl findBeerUseCase;


    @Test
    void success_mustBringABeerList() {

        when(beerPort.findAll())
                .thenReturn(beers());

        List<BeerDto> response = findBeerUseCase.execute();


        // AssertJ
        assertThat(response)
                .isNotEmpty()
                .hasSize(1)
                .extracting("name", "brand", "amount", "capacity", "typeMeasures")
                .contains(tuple("Brahma", "AmBev", 100, 1.0, TypeMeasures.L));

        // Assert Junit
        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals("Brahma", response.get(0).getName());
        assertEquals("AmBev", response.get(0).getBrand());
        assertEquals(1.0, response.get(0).getCapacity());
        assertEquals(100, response.get(0).getAmount());
        assertEquals(TypeMeasures.L, response.get(0).getTypeMeasures());
    }

    @Test
    void success_mustBringAnEmptyList() {

        when(beerPort.findAll())
                .thenReturn(Collections.emptyList());

        List<BeerDto> response = findBeerUseCase.execute();

        Assertions.assertThat(response).isEmpty();
    }

    private List<Beer> beers() {
        return List.of(beer());
    }

    private Beer beer() {

        Beer beer = new Beer();

        beer.setId(1L);
        beer.setName("Brahma");
        beer.setBrand("AmBev");
        beer.setCapacity(1.0);
        beer.setAmount(100);
        beer.setTypeMeasures(TypeMeasures.L);

        return beer;
    }
}
