package org.backend.cooroot.model.dto.request;

import lombok.Data;

@Data
public class CreateUserRequest {
  private String email;
  private String phoneNumber;
  private String firstName;
  private String lastName;
  private String username;
  private String password;
  // По желанию можно добавить другие поля, если они нужны при создании пользователя
}
