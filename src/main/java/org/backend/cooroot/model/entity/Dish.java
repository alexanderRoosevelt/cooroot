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
@Table(name = "dishes")
public class Dish extends BaseEntity {

  @Column(name = "name")
  private String name;

  @Column(name = "image_url")
  private String imageUrl;

  @Column(name = "description")
  private String description;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private FoodCategory category;

  @Column(name = "price")
  private BigDecimal price;

  @Column(name = "serving_size")
  private int servingSize;

  @Column(name = "preparation_time")
  private Timestamp preparationTime;

  @ManyToOne
  @JoinColumn(name = "cook_id")
  private Users cook;

  @Column(name = "rating")
  private BigDecimal rating;
}
