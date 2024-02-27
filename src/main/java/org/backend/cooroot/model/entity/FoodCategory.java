package org.backend.cooroot.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "food_categories")
public class FoodCategory extends BaseEntity {

  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;
}
