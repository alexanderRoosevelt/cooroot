package org.backend.cooroot.model.dto.request;
import lombok.Data;

@Data
public class CreateOrderRequest {
  private Long userId;
  private Long dishId;
  private int quantity;
  // По желанию можно добавить другие поля, если они нужны при создании заказа
}
