package org.brainstormtech.productservice.service;

import lombok.RequiredArgsConstructor;
import org.brainstormtech.productservice.dto.request.ProductRequest;
import org.brainstormtech.productservice.dto.response.ProductResponse;
import org.brainstormtech.productservice.exception.ProductNotFoundException;
import org.brainstormtech.productservice.mapper.ProductRequestMapper;
import org.brainstormtech.productservice.mapper.ProductResponseMapper;
import org.brainstormtech.productservice.model.Product;
import org.brainstormtech.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductRequestMapper requestMapper;
    private final ProductResponseMapper responseMapper;

    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll().stream()
                .map(responseMapper)
                .collect(Collectors.toList());
    }

    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        return responseMapper.apply(product);
    }

    public ProductResponse createProduct(ProductRequest request) {
        Product product = requestMapper.apply(request);
        Product savedProduct = productRepository.save(product);
        return responseMapper.apply(savedProduct);
    }

    public ProductResponse updateProduct(Long id, ProductRequest request) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        existingProduct.setProductName(request.getProductName());
        existingProduct.setProductPrice(request.getProductPrice());
        existingProduct.setQuantity(request.getQuantity());
        Product updatedProduct = productRepository.save(existingProduct);
        return responseMapper.apply(updatedProduct);
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }
}