package org.brainstormtech.productservice.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductResponse {
  private Long id;
  private String productName;
  private Long productPrice;
  private Long quantity;
}
