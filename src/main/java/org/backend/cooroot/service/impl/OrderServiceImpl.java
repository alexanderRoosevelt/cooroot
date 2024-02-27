package org.backend.cooroot.service.impl;


import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.backend.cooroot.model.dto.request.CreateOrderRequest;
import org.backend.cooroot.model.dto.response.OrderDTO;
import org.backend.cooroot.model.entity.Order;
import org.backend.cooroot.repository.OrderRepository;
import org.backend.cooroot.service.OrderService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

  private final OrderRepository orderRepository;

  @Override
  public List<OrderDTO> getAllOrders() {
    return orderRepository.findAll().stream()
        .map(OrderDTO::new)
        .collect(Collectors.toList());
  }

  @Override
  public OrderDTO getOrderById(Long id) {
    return orderRepository.findById(id)
        .map(OrderDTO::new)
        .orElse(null);
  }

  @Override
  public OrderDTO createOrder(CreateOrderRequest request) {
    Order order = new Order();
    // order.setUserId(request.getUserId());
    // order.setDishId(request.getDishId());
    order.setQuantity(request.getQuantity());
    // Заполните остальные поля
    order = orderRepository.save(order);
    return new OrderDTO(order);
  }

  @Override
  public OrderDTO updateOrder(Long id, CreateOrderRequest request) {
    return orderRepository.findById(id).map(order -> {
      // order.setUserId(request.getUserId());
      // order.setDishId(request.getDishId());
      order.setQuantity(request.getQuantity());
      // Заполните остальные поля
      return new OrderDTO(orderRepository.save(order));
    }).orElse(null);
  }

  @Override
  public void deleteOrder(Long id) {
    orderRepository.deleteById(id);
  }
}