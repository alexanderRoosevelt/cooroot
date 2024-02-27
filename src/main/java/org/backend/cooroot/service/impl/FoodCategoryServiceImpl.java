package org.backend.cooroot.service.impl;
import lombok.RequiredArgsConstructor;
import org.backend.cooroot.model.dto.request.CreateFoodCategoryRequest;
import org.backend.cooroot.model.dto.response.FoodCategoryDTO;
import org.backend.cooroot.model.entity.FoodCategory;
import org.backend.cooroot.repository.FoodCategoryRepository;
import org.backend.cooroot.service.FoodCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FoodCategoryServiceImpl implements FoodCategoryService {
  private final FoodCategoryRepository foodCategoryRepository;

  @Override
  public List<FoodCategoryDTO> getAllFoodCategories() {
    return foodCategoryRepository.findAll().stream()
        .map(FoodCategoryDTO::new)
        .collect(Collectors.toList());
  }

  @Override
  public FoodCategoryDTO getFoodCategoryById(Long id) {
    return foodCategoryRepository.findById(id)
        .map(FoodCategoryDTO::new)
        .orElse(null);
  }

  @Override
  public FoodCategoryDTO createFoodCategory(CreateFoodCategoryRequest request) {
    FoodCategory category = new FoodCategory();
    category.setName(request.getName());
    category.setDescription(request.getDescription());
    category = foodCategoryRepository.save(category);
    return new FoodCategoryDTO(category);
  }

  @Override
  public FoodCategoryDTO updateFoodCategory(Long id, CreateFoodCategoryRequest request) {
    return foodCategoryRepository.findById(id).map(category -> {
      category.setName(request.getName());
      category.setDescription(request.getDescription());
      return new FoodCategoryDTO(foodCategoryRepository.save(category));
    }).orElse(null);
  }

  @Override
  public void deleteFoodCategory(Long id) {
    foodCategoryRepository.deleteById(id);
  }
}
