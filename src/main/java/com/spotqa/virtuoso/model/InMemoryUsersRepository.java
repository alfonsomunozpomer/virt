package com.spotqa.virtuoso.model;

import jakarta.inject.Singleton;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Singleton
public class InMemoryUsersRepository {
  private final AtomicLong ids = new AtomicLong(0);
  private final List<User> store = new CopyOnWriteArrayList<>();

  public List<User> findAll() {
    return Collections.unmodifiableList(store);
  }

  public User save(User user) {
    user.setUserId(ids.incrementAndGet());
    store.add(user);
    return user;
  }
}
