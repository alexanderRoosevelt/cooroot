package org.backend.cooroot.model.dto.response;

import lombok.Data;
import org.backend.cooroot.model.entity.FoodCategory;

@Data
public class FoodCategoryDTO {
  private Long id;
  private String name;
  private String description;

  public FoodCategoryDTO(FoodCategory category) {
    this.id = category.getId();
    this.name = category.getName();
    this.description = category.getDescription();
  }
}
