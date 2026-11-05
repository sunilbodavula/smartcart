package com.smartcart.product;


import com.smartcart.product.dto.ProductCreateRequest;
import com.smartcart.product.dto.ProductResponse;
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
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
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
