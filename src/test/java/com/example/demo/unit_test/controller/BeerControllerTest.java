package com.example.demo.unit_test.controller;

import com.example.demo.commons.enums.TypeMeasures;
import com.example.demo.core.usecase.CreateBeerUseCase;
import com.example.demo.inbound.api.dto.BeerDto;
import com.example.demo.core.usecase.FindBeerUseCase;
import com.example.demo.core.usecase.UpdateStockUseCase;
import com.example.demo.inbound.api.controller.BeerController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(BeerController.class)
@AutoConfigureMockMvc(addFilters = false)
public class BeerControllerTest {

    @MockBean
    private CreateBeerUseCase createBeerUseCase;

    @MockBean
    private FindBeerUseCase findBeerUseCase;

    @MockBean
    private UpdateStockUseCase updateStockUseCase;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void success_mustSaveABeer() throws Exception {

        mockMvc.perform(post("/beer")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(beerDto())))
                .andExpect(status().isCreated());
    }

    //Todo: criar um teste de get
    @Test
    public void success_mustBringABeerList() throws Exception {

    }


    private BeerDto beerDto() {

        BeerDto beerDto = new BeerDto();

        beerDto.setName("Brahma");
        beerDto.setBrand("AmBev");
        beerDto.setCapacity(1.0);
        beerDto.setAmount(100);
        beerDto.setTypeMeasures(TypeMeasures.L);

        return beerDto;
    }
}
