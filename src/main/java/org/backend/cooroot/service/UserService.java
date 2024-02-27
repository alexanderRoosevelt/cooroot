package org.backend.cooroot.service;

import java.util.List;
import org.backend.cooroot.model.dto.request.CreateUserRequest;
import org.backend.cooroot.model.dto.response.UserDTO;

public interface UserService {
  List<UserDTO> getAllUsers();
  UserDTO getUserById(Long id);
  UserDTO createUser(CreateUserRequest request);
  UserDTO updateUser(Long id, CreateUserRequest request);
  void deleteUser(Long id);
}

