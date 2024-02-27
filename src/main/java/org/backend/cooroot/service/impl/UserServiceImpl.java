package org.backend.cooroot.service.impl;

import lombok.RequiredArgsConstructor;
import org.backend.cooroot.model.dto.request.CreateUserRequest;
import org.backend.cooroot.model.dto.response.UserDTO;
import org.backend.cooroot.model.entity.Users;
import org.backend.cooroot.repository.UserRepository;
import org.backend.cooroot.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  @Override
  public List<UserDTO> getAllUsers() {
    return userRepository.findAll().stream()
        .map(UserDTO::new)
        .collect(Collectors.toList());
  }

  @Override
  public UserDTO getUserById(Long id) {
    return userRepository.findById(id)
        .map(UserDTO::new)
        .orElse(null);
  }

  @Override
  public UserDTO createUser(CreateUserRequest request) {
    Users user = new Users();
    user.setEmail(request.getEmail());
    user.setPhoneNumber(request.getPhoneNumber());
    user.setFirstName(request.getFirstName());
    user.setLastName(request.getLastName());
    user.setUsername(request.getUsername());
    user.setPassword(request.getPassword());
    user = userRepository.save(user);
    return new UserDTO(user);
  }

  @Override
  public UserDTO updateUser(Long id, CreateUserRequest request) {
    return userRepository.findById(id).map(user -> {
      user.setEmail(request.getEmail());
      user.setPhoneNumber(request.getPhoneNumber());
      user.setFirstName(request.getFirstName());
      user.setLastName(request.getLastName());
      user.setUsername(request.getUsername());
      user.setPassword(request.getPassword());
      return new UserDTO(userRepository.save(user));
    }).orElse(null);
  }

  @Override
  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }
}
