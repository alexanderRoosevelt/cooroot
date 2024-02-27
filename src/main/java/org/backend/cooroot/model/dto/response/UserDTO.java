package org.backend.cooroot.model.dto.response;

import lombok.Data;
import org.backend.cooroot.model.entity.Users;

@Data
public class UserDTO {

  private Long id;
  private String email;
  private String phoneNumber;
  private String firstName;
  private String lastName;
  private String username;

  public UserDTO(Users user) {
    this.id = user.getId();
    this.email = user.getEmail();
    this.phoneNumber = user.getPhoneNumber();
    this.firstName = user.getFirstName();
    this.lastName = user.getLastName();
    this.username = user.getUsername();
  }
}

