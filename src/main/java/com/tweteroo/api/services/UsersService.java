package com.tweteroo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.UsersDTO;
import com.tweteroo.api.model.Users;
import com.tweteroo.api.repository.UsersRepository;

@Service
public class UsersService {

  @Autowired
  private UsersRepository repository;

  public List<Users> findAll() {
    return repository.findAll();
  }

  public Users save(UsersDTO dto) {
    return repository.save(new Users(dto));
  }

}