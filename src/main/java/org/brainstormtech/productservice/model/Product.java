package org.brainstormtech.productservice.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "products")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product extends Auditable {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
  @SequenceGenerator(name = "product_seq", sequenceName = "product_seq", allocationSize = 5)
  private Long id;

  @Column(name = "product_name", nullable = false)
  private String productName;

  @Column(name = "product_price", nullable = false)
  private Long productPrice;

  @Column(name = "product_quantity", nullable = false)
  private Long quantity;
}
