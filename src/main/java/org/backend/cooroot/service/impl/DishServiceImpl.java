package org.backend.cooroot.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.backend.cooroot.model.dto.request.CreateDishRequest;
import org.backend.cooroot.model.dto.response.DishDTO;
import org.backend.cooroot.model.entity.Dish;
import org.backend.cooroot.repository.DishRepository;
import org.backend.cooroot.service.DishService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {
  private final DishRepository dishRepository;

  @Override
  public List<DishDTO> getAllDishes() {
    return dishRepository.findAll().stream()
        .map(DishDTO::new)
        .collect(Collectors.toList());
  }

  @Override
  public DishDTO getDishById(Long id) {
    return dishRepository.findById(id)
        .map(DishDTO::new)
        .orElse(null);
  }

  @Override
  public DishDTO createDish(CreateDishRequest request) {
    Dish dish = new Dish();
    dish.setName(request.getName());
    dish.setImageUrl(request.getImageUrl());
    dish.setDescription(request.getDescription());
    dish = dishRepository.save(dish);
    return new DishDTO(dish);
  }

  @Override
  public DishDTO updateDish(Long id, CreateDishRequest request) {
    return dishRepository.findById(id).map(dish -> {
      dish.setName(request.getName());
      dish.setImageUrl(request.getImageUrl());
      dish.setDescription(request.getDescription());
      return new DishDTO(dishRepository.save(dish));
    }).orElse(null);
  }

  @Override
  public void deleteDish(Long id) {
    dishRepository.deleteById(id);
  }
}