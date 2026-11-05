package com.smartcart.product.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ProductCreateRequest(

    @NotBlank
    @Size(max = 200)
    String name,

    String description,

    @NotNull
    @DecimalMin("0.00")
    BigDecimal price,

    @NotNull
    @PositiveOrZero
    Integer stockQuantity

) {
}
