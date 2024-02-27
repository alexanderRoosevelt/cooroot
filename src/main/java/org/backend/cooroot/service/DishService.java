package org.backend.cooroot.service;

import java.util.List;
import org.backend.cooroot.model.dto.request.CreateDishRequest;
import org.backend.cooroot.model.dto.response.DishDTO;

public interface DishService {
  List<DishDTO> getAllDishes();
  DishDTO getDishById(Long id);
  DishDTO createDish(CreateDishRequest request);
  DishDTO updateDish(Long id, CreateDishRequest request);
  void deleteDish(Long id);
}
