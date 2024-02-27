package org.backend.cooroot.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

  @ManyToOne
  @JoinColumn(name = "user_id")
  private Users user;

  @ManyToOne
  @JoinColumn(name = "dish_id")
  private Dish dish;

  @Column(name = "quantity")
  private int quantity;

  @Column(name = "order_date")
  private Timestamp orderDate;

  @Column(name = "status")
  private String status;

  @Column(name = "total_price")
  private BigDecimal totalPrice;
}
