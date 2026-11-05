package com.smartcart.product;

import com.smartcart.product.dto.ProductCreateRequest;
import com.smartcart.product.dto.ProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ProductService productService;

    @Test
    void getAllProductsReturnsOkAndProductJson() throws Exception {

        ProductResponse product = new ProductResponse(
            1L,
            "Wireless Mouse",
            "Bluetooth wireless mouse",
            new BigDecimal("599.00"),
            20,
            OffsetDateTime.parse("2026-11-05T10:00:00Z")
        );

        given(productService.getAllProducts())
            .willReturn(List.of(product));

        mockMvc.perform(get("/api/products"))
            .andExpect(status().isOk())
            .andExpect(
                content().contentTypeCompatibleWith(
                    MediaType.APPLICATION_JSON
                )
            )
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$.length()").value(1))
            .andExpect(jsonPath("$[0].id").value(1))
            .andExpect(jsonPath("$[0].name").value("Wireless Mouse"))
            .andExpect(jsonPath("$[0].price").value(599.00))
            .andExpect(jsonPath("$[0].stockQuantity").value(20));
    }

    @Test
    void getProductByIdReturnsNotFoundWhenProductDoesNotExist()
    throws Exception{

        given(productService.getProductById(999L))
            .willThrow(
                new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Product not found with id: 999"
                )
            );

        mockMvc.perform(get("/api/products/999"))
            .andExpect(status().isNotFound());
    }

    @Test
    void createProductReturnsCreatedResponse() throws Exception {
        ProductResponse response = new ProductResponse(
            1L,
            "Wireless Mouse",
            "Bluetooth wireless mouse",
            new BigDecimal("599.00"),
            20,
            OffsetDateTime.parse("2026-11-05T10:00:00Z")
        );

        given(productService.createProduct(any(ProductCreateRequest.class)))
            .willReturn(response);

        mockMvc.perform(post("/api/products")
            .contentType(MediaType.APPLICATION_JSON)
            .content("""
                {
                    "name": "Wireless Mouse",
                    "description": "Bluetooth wireless mouse",
                    "price": 599.00,
                    "stockQuantity": 20
                }
                """))
            .andExpect(status().isCreated())
            .andExpect(content().contentTypeCompatibleWith(
                MediaType.APPLICATION_JSON
            ))
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.name").value("Wireless Mouse"))
            .andExpect(jsonPath("$.price").value(599.00))
            .andExpect(jsonPath("$.stockQuantity").value(20))
            .andExpect(jsonPath("$.createdAt").exists());
    }

    @Test
    void createProductReturnsBadRequestWhenRequiredFieldsAreMissing()
    throws Exception{

        mockMvc.perform(post("/api/products")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{}"))
            .andExpect(status().isBadRequest());

        verifyNoInteractions(productService);
    }
}
