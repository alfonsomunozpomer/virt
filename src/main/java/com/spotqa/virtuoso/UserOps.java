package com.spotqa.virtuoso;

import com.spotqa.virtuoso.model.InMemoryUsersRepository;
import com.spotqa.virtuoso.model.User;
import dev.langchain4j.agent.tool.Tool;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class UserOps {
  private final InMemoryUsersRepository inMemoryUsersRepository = new InMemoryUsersRepository();

  @Tool("Create a user")
  @Transactional
  public void createJourney(String userName, String name, String email) {
    var user = new User(
        null,
        userName,
        email,
        name,
        null,
        true
    );
    inMemoryUsersRepository.save(user);
  }

  @Tool("Get all users")
  @Transactional
  public List<User> getAllUsers() {
    return inMemoryUsersRepository.findAll();
  }
}
