package za.ac.cput.practice.controller;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import za.ac.cput.practice.service.OrderService;

import java.util.List;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class OrderControllerTest {

    @Mock
    private OrderService service;

    @InjectMocks
    private OrderController controller;

    @Test

    void testGetAll(){
        when(service.getAll()).thenReturn(List.of());
        List<?> result=controller.getAll();
        assertNotNull(result);
        verify(service).getAll();

    }


}
