package org.backend.cooroot.controller;

import lombok.RequiredArgsConstructor;
import org.backend.cooroot.model.dto.request.CreateFoodCategoryRequest;
import org.backend.cooroot.model.dto.response.FoodCategoryDTO;
import org.backend.cooroot.service.FoodCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food-categories")
@RequiredArgsConstructor
public class FoodCategoryController {

  private final FoodCategoryService foodCategoryService;

  @GetMapping
  public ResponseEntity<List<FoodCategoryDTO>> getAllFoodCategories() {
    List<FoodCategoryDTO> categories = foodCategoryService.getAllFoodCategories();
    return ResponseEntity.ok(categories);
  }

  @GetMapping("/{id}")
  public ResponseEntity<FoodCategoryDTO> getFoodCategoryById(@PathVariable Long id) {
    FoodCategoryDTO category = foodCategoryService.getFoodCategoryById(id);
    return ResponseEntity.ok(category);
  }

  @PostMapping
  public ResponseEntity<FoodCategoryDTO> createFoodCategory(
      @RequestBody CreateFoodCategoryRequest request) {
    FoodCategoryDTO category = foodCategoryService.createFoodCategory(request);
    return new ResponseEntity<>(category, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<FoodCategoryDTO> updateFoodCategory(@PathVariable Long id,
      @RequestBody CreateFoodCategoryRequest request) {
    FoodCategoryDTO category = foodCategoryService.updateFoodCategory(id, request);
    return ResponseEntity.ok(category);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteFoodCategory(@PathVariable Long id) {
    foodCategoryService.deleteFoodCategory(id);
    return ResponseEntity.noContent().build();
  }
}
