package com.tweteroo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.model.Users;
import com.tweteroo.api.repository.TweetRepository;

@Service
public class TweetService {
  @Autowired
  private TweetRepository repository;

  @Autowired
  private UsersService usersService;

  public List<Tweet> findAll() {
    return repository.findAll();
  }

  public List<Tweet> findAllByUsername(String username) {
    return repository.findAllByUsernameOrderByIdDesc(username);
  }

  public Tweet save(TweetDTO dto) {
    Tweet tweet = new Tweet(dto);

    Users user = usersService.findByUsername(dto.username());
    tweet.setAvatar(user.getAvatar());

    return repository.save(tweet);
  }
}
