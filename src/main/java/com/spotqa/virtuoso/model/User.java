package com.spotqa.virtuoso.model;

public class User {

  private Long userId;
  private String username;
  private String email;
  private String name;
  private String avatar;
  private Boolean active;

  public User() {}

  public User(
      Long userId,
      String username,
      String email,
      String name,
      String avatar,
      Boolean active) {
    this.userId = userId;
    this.username = username;
    this.email = email;
    this.name = name;
    this.avatar = avatar;
    this.active = active;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public Boolean getActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

}
