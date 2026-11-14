package com.smartcart.product;


import com.smartcart.product.dto.ProductResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void shouldReturnPaginatedProductsWithoutSearch(){

        Pageable pageable = PageRequest.of(1, 10);

        Product product = createProduct(1L, "Wireless keyboard");

        Page<Product> repositoryPage =
            new PageImpl<>(List.of(product), pageable, 21);

        when(productRepository.findAll(pageable))
            .thenReturn(repositoryPage);

        Page<ProductResponse> result =
            productService.getProducts(" ", pageable);

        assertEquals(21, result.getTotalElements());
        assertEquals(3, result.getTotalPages());
        assertEquals(1, result.getNumber());
        assertEquals(10, result.getSize());

        assertEquals(
            "Wireless keyboard",
            result.getContent().get(0).name()
        );

        verify(productRepository).findAll(pageable);

        verify(productRepository, never())
            .findByNameContainingIgnoreCase(
                anyString(),
                any(Pageable.class)
            );
    }

    @Test
    void shouldReturnMatchingProductsWhenSearchIsProvided(){

        Pageable pageable = PageRequest.of(0, 5);

        Product product = createProduct(2L, "Mechanical keyboard");

        Page<Product> repositoryPage =
            new PageImpl<>(List.of(product), pageable, 1);

        when(productRepository.findByNameContainingIgnoreCase(
            "keyboard",
            pageable
        )).thenReturn(repositoryPage);

        Page<ProductResponse> result =
            productService.getProducts("keyboard", pageable);

        assertEquals(1, result.getTotalElements());
        assertEquals(
            "Mechanical keyboard",
            result.getContent().get(0).name()
        );

        verify(productRepository)
            .findByNameContainingIgnoreCase("keyboard", pageable);

        verify(productRepository, never())
            .findAll(any(Pageable.class));
    }

    private Product createProduct(Long id, String name) {

        Product product = new Product();

        product.setId(id);
        product.setName(name);
        product.setDescription("Test product");
        product.setPrice(new BigDecimal("599.00"));
        product.setStockQuantity(20);

        return product;
    }
}
