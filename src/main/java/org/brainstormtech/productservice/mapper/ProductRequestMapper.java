package org.brainstormtech.productservice.mapper;

import org.brainstormtech.productservice.dto.request.ProductRequest;
import org.brainstormtech.productservice.model.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProductRequestMapper implements Function<ProductRequest, Product> {
  @Override
  public Product apply(ProductRequest productRequest) {
    var product = new Product();
    BeanUtils.copyProperties(productRequest, product);
    return product;
  }
}
