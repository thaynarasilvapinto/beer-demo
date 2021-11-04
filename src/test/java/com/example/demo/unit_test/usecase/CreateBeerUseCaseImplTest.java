package com.example.demo.unit_test.usecase;

import com.example.demo.commons.enums.TypeMeasures;
import com.example.demo.commons.exceptions.BusinessException;
import com.example.demo.core.port.database.BeerPort;
import com.example.demo.core.usecase.impl.CreateBeerUseCaseImpl;
import com.example.demo.inbound.api.dto.BeerDto;
import com.example.demo.core.domain.Beer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@SpringBootTest
@ContextConfiguration
public class CreateBeerUseCaseImplTest {

    @Mock
    private BeerPort beerPort;

    @InjectMocks
    private CreateBeerUseCaseImpl createBeerUseCase;

    @Test
    void success_mustSaveABeer() {
        BeerDto request = beerDto();

        when(beerPort.findByNameAndCapacityAndTypeMeasures(request.getName(), request.getCapacity(), request.getTypeMeasures()))
                .thenReturn(Optional.empty());
        when(beerPort.saveAndFlush(Mockito.any()))
                .thenReturn(beer());

        BeerDto response = createBeerUseCase.execute(request);

        assertNotNull(response);
    }

    @Test
    void execute_mustSaveABeer() {
        BeerDto request = beerDto();

        when(beerPort.findByNameAndCapacityAndTypeMeasures(request.getName(), request.getCapacity(), request.getTypeMeasures()))
                .thenReturn(Optional.empty());
        when(beerPort.saveAndFlush(Mockito.any()))
                .thenReturn(beer());

        BeerDto response = createBeerUseCase.execute(request);

        //AssertJ
        assertThat(response.getName()).isEqualTo("Brahma Duplo Malte");
        assertThat(response.getBrand()).isEqualTo("AmBev");
        assertThat(response.getCapacity()).isEqualTo(1.0);
        assertThat(response.getAmount()).isEqualTo(100);
        org.assertj.core.api.Assertions.assertThat(response.getTypeMeasures()).isEqualTo(TypeMeasures.L);

        assertThat(response.getBrand().equals("AmBev")).isTrue();

        assertThat(response.getName())
                .isNotNull()
                .startsWith("Brahma")
                .contains("Duplo")
                .endsWith("Malte");

        assertThat(response).matches(beer ->
                Objects.equals(beer.getName(), "Brahma Duplo Malte") &&
                Objects.equals(beer.getBrand(), "AmBev") &&
                beer.getAmount().equals(100));


        assertThat(response)
                .isNotNull()
                .extracting("name", "brand", "amount", "capacity", "typeMeasures").
                contains("Brahma Duplo Malte", "AmBev", 100, 1.0, TypeMeasures.L);


        //Assert Junit
        assertEquals("Brahma Duplo Malte", response.getName());
        assertEquals("AmBev", response.getBrand());
        assertEquals(1.0, response.getCapacity());
        assertEquals(100, response.getAmount());
        Assertions.assertEquals(TypeMeasures.L, response.getTypeMeasures());
    }


    @Test
    void error_beerAlreadyExists() {
        BeerDto request = beerDto();

        when(beerPort.findByNameAndCapacityAndTypeMeasures(request.getName(), request.getCapacity(), request.getTypeMeasures()))
                .thenReturn(Optional.of(beer()));

        Exception exception = Assertions.assertThrows(BusinessException.class, () -> createBeerUseCase.execute(request));

        Assertions.assertEquals("Beer already exists!", exception.getMessage());
    }

    private BeerDto beerDto() {

        BeerDto beerDto = new BeerDto();

        beerDto.setName("Brahma Duplo Malte");
        beerDto.setBrand("AmBev");
        beerDto.setCapacity(1.0);
        beerDto.setAmount(100);
        beerDto.setTypeMeasures(TypeMeasures.L);

        return beerDto;
    }

    private Beer beer() {

        Beer beer = new Beer();

        beer.setId(1L);
        beer.setName("Brahma Duplo Malte");
        beer.setBrand("AmBev");
        beer.setCapacity(1.0);
        beer.setAmount(100);
        beer.setTypeMeasures(TypeMeasures.L);

        return beer;
    }
}
