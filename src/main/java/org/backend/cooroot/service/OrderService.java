package org.backend.cooroot.service;

import java.util.List;
import org.backend.cooroot.model.dto.request.CreateOrderRequest;
import org.backend.cooroot.model.dto.response.OrderDTO;

public interface OrderService {
  List<OrderDTO> getAllOrders();
  OrderDTO getOrderById(Long id);
  OrderDTO createOrder(CreateOrderRequest request);
  OrderDTO updateOrder(Long id, CreateOrderRequest request);
  void deleteOrder(Long id);
}
