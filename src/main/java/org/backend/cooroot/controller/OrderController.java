package org.backend.cooroot.controller;

import lombok.RequiredArgsConstructor;
import org.backend.cooroot.model.dto.request.CreateOrderRequest;
import org.backend.cooroot.model.dto.response.OrderDTO;
import org.backend.cooroot.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

  private final OrderService orderService;

  @GetMapping
  public ResponseEntity<List<OrderDTO>> getAllOrders() {
    List<OrderDTO> orders = orderService.getAllOrders();
    return ResponseEntity.ok(orders);
  }

  @GetMapping("/{id}")
  public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id) {
    OrderDTO order = orderService.getOrderById(id);
    return ResponseEntity.ok(order);
  }

  @PostMapping
  public ResponseEntity<OrderDTO> createOrder(@RequestBody CreateOrderRequest request) {
    OrderDTO order = orderService.createOrder(request);
    return new ResponseEntity<>(order, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long id,
      @RequestBody CreateOrderRequest request) {
    OrderDTO order = orderService.updateOrder(id, request);
    return ResponseEntity.ok(order);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
    orderService.deleteOrder(id);
    return ResponseEntity.noContent().build();
  }
}
