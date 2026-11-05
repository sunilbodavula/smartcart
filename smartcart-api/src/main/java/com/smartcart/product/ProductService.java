package com.smartcart.product;

import com.smartcart.product.dto.ProductCreateRequest;
import com.smartcart.product.dto.ProductResponse;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<ProductResponse> getAllProducts(){
        return productRepository.findAll()
            .stream()
            .map(this::mapToResponse)
            .toList();
    }

    public ProductResponse getProductById(Long id){
        Product product = productRepository.findById(id)
            .orElseThrow(() ->
                new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Product not found with id: " + id
                ));

        return mapToResponse(product);
    }

    public ProductResponse createProduct(ProductCreateRequest request){
        Product product = new Product();

        product.setName(request.name());
        product.setDescription(request.description());
        product.setPrice(request.price());
        product.setStockQuantity(request.stockQuantity());

        Product savedProduct = productRepository.save(product);

        return mapToResponse(savedProduct);
    }

    private ProductResponse mapToResponse(Product product){
        return new ProductResponse(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            product.getStockQuantity(),
            product.getCreatedAt()
        );
    }
}
