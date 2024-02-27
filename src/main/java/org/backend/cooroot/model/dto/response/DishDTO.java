package org.backend.cooroot.model.dto.response;

import java.math.BigDecimal;
import java.sql.Timestamp;
import lombok.Data;
import org.backend.cooroot.model.entity.Dish;

@Data
public class DishDTO {
  private Long id;
  private String name;
  private String imageUrl;
  private String description;
  private String categoryName;
  private BigDecimal price;
  private int servingSize;
  private Timestamp preparationTime;
  private String cookName;
  private BigDecimal rating;

  public DishDTO(Dish dish) {
    this.id = dish.getId();
    this.name = dish.getName();
    this.imageUrl = dish.getImageUrl();
    this.description = dish.getDescription();
    this.categoryName = dish.getCategory().getName();
    this.price = dish.getPrice();
    this.servingSize = dish.getServingSize();
    this.preparationTime = dish.getPreparationTime();
    this.cookName = dish.getCook().getUsername();
    this.rating = dish.getRating();
  }
}
