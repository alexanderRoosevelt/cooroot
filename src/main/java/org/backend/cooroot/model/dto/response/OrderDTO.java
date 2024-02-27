package org.backend.cooroot.model.dto.response;

import java.math.BigDecimal;
import java.sql.Timestamp;
import lombok.Data;
import org.backend.cooroot.model.entity.Order;

@Data
public class OrderDTO {
  private Long id;
  private Long userId;
  private String userName;
  private Long dishId;
  private String dishName;
  private int quantity;
  private Timestamp orderDate;
  private String status;
  private BigDecimal totalPrice;

  public OrderDTO(Order order) {
    this.id = order.getId();
    this.userId = order.getUser().getId();
    this.userName = order.getUser().getUsername();
    this.dishId = order.getDish().getId();
    this.dishName = order.getDish().getName();
    this.quantity = order.getQuantity();
    this.orderDate = order.getOrderDate();
    this.status = order.getStatus();
    this.totalPrice = order.getTotalPrice();
  }
}
