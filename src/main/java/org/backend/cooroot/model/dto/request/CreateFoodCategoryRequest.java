package org.backend.cooroot.model.dto.request;
import lombok.Data;

@Data
public class CreateFoodCategoryRequest {
  private String name;
  private String description;
  // По желанию можно добавить другие поля, если они нужны при создании категории блюда
}
