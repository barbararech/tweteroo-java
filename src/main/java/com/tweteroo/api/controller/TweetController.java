package com.tweteroo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.repository.TweetRepository;

@RestController
@RequestMapping("/tweets")
public class TweetController {
  @Autowired
  private TweetRepository repository;

  @GetMapping
  public List<Tweet> listAll() {
    return repository.findAll();
  }

  @PostMapping
  public void createTweet(@RequestBody TweetDTO req) {
    repository.save(new Tweet(req));
    System.out.println("OK");
  }
}
