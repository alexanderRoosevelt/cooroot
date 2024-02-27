package org.backend.cooroot.controller;

import lombok.RequiredArgsConstructor;
import org.backend.cooroot.model.dto.request.CreateDishRequest;
import org.backend.cooroot.model.dto.response.DishDTO;
import org.backend.cooroot.service.DishService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dishes")
@RequiredArgsConstructor
public class DishController {

  private final DishService dishService;

  @GetMapping
  public ResponseEntity<List<DishDTO>> getAllDishes() {
    List<DishDTO> dishes = dishService.getAllDishes();
    return ResponseEntity.ok(dishes);
  }

  @GetMapping("/{id}")
  public ResponseEntity<DishDTO> getDishById(@PathVariable Long id) {
    DishDTO dish = dishService.getDishById(id);
    return ResponseEntity.ok(dish);
  }

  @PostMapping
  public ResponseEntity<DishDTO> createDish(@RequestBody CreateDishRequest request) {
    DishDTO dish = dishService.createDish(request);
    return new ResponseEntity<>(dish, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<DishDTO> updateDish(@PathVariable Long id,
      @RequestBody CreateDishRequest request) {
    DishDTO dish = dishService.updateDish(id, request);
    return ResponseEntity.ok(dish);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteDish(@PathVariable Long id) {
    dishService.deleteDish(id);
    return ResponseEntity.noContent().build();
  }
}
