package com.dragonb0rn.springbootapp.chronicles;

import com.dragonb0rn.springbootapp.chronicles.entities.Product;
import com.dragonb0rn.springbootapp.chronicles.services.impl.ProductServiceImpl;
import com.dragonb0rn.springbootapp.chronicles.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product product1;
    private Product product2;

    @BeforeEach
    void setUp() {
        product1 = new Product();
        product1.setId(1L);
        product1.setName("Smartphone");
        product1.setPrice(699);
        product1.setDescription("Latest model smartphone");
        product1.setPiclink("https://example.com/products/smartphone.jpg");

        product2 = new Product();
        product2.setId(2L);
        product2.setName("Laptop");
        product2.setPrice(1200);
        product2.setDescription("Lightweight and powerful laptop");
        product2.setPiclink("https://example.com/products/laptop.jpg");
    }

    @Test
    void findAll_ShouldReturnAllProducts() {
        // Arrange
        when(productRepository.findAll()).thenReturn(Arrays.asList(product1, product2));

        // Act
        List<Product> products = productService.findAll();

        // Assert
        assertThat(products).hasSize(2);
        assertThat(products.get(0)).isEqualTo(product1);
        assertThat(products.get(1)).isEqualTo(product2);

        // Verify the interaction with the mock
        verify(productRepository, times(1)).findAll();
    }
}
