package org.backend.cooroot.model.dto.request;

import java.math.BigDecimal;
import java.security.Timestamp;
import lombok.Data;

@Data
public class CreateDishRequest {
  private String name;
  private String imageUrl;
  private String description;
  private Long categoryId;
  private BigDecimal price;
  private int servingSize;
  private Timestamp preparationTime;
  private Long cookId;
  // По желанию можно добавить другие поля, если они нужны при создании блюда
}
