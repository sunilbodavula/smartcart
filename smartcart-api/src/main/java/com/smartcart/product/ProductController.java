package com.smartcart.product;


import com.smartcart.product.dto.ProductCreateRequest;
import com.smartcart.product.dto.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public Page<ProductResponse> getAllProducts(
        @RequestParam(defaultValue = "") String search,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size
    ){
        return productService.getProducts(
            search,
            PageRequest.of(page, size)
        );
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@Valid @RequestBody ProductCreateRequest request){
        return productService.createProduct(request);
    }

}
