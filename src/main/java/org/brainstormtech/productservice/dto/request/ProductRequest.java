package org.brainstormtech.productservice.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductRequest {
  private Long id;
  private String productName;
  private Long productPrice;
  private Long quantity;
}
