package org.backend.cooroot.service;

import java.util.List;
import org.backend.cooroot.model.dto.request.CreateFoodCategoryRequest;
import org.backend.cooroot.model.dto.response.FoodCategoryDTO;

public interface FoodCategoryService {
  List<FoodCategoryDTO> getAllFoodCategories();
  FoodCategoryDTO getFoodCategoryById(Long id);
  FoodCategoryDTO createFoodCategory(CreateFoodCategoryRequest request);
  FoodCategoryDTO updateFoodCategory(Long id, CreateFoodCategoryRequest request);
  void deleteFoodCategory(Long id);
}
