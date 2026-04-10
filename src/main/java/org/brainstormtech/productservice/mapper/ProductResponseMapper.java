package org.brainstormtech.productservice.mapper;

import org.brainstormtech.productservice.dto.response.ProductResponse;
import org.brainstormtech.productservice.model.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProductResponseMapper implements Function<Product, ProductResponse> {
  @Override
  public ProductResponse apply(Product product) {
    var response = new ProductResponse();
    BeanUtils.copyProperties(product, response);
    return response;
  }
}
