package com.example.demo.unit_test.usecase;

import com.example.demo.core.port.database.BeerPort;
import com.example.demo.commons.enums.TypeMeasures;
import com.example.demo.core.usecase.impl.UpdateStockUseCaseImpl;
import com.example.demo.inbound.api.dto.BeerDto;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;



@SpringBootTest
@ContextConfiguration
public class UpdateStockUseCaseImplTest {

    @Mock
    private BeerPort beerPort;

    @InjectMocks
    private UpdateStockUseCaseImpl updateStockUseCase;

    //Todo: Criar uma teste de sucesso
    @Test
    void success_mustUpdateStockABeer() {
        // Prepara o cenário
        // Fazer a chamada
        // Validar a resposta
    }

    //Todo: Criar um teste de erro
    @Test()
    void error_beerNotExists() {
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
}
