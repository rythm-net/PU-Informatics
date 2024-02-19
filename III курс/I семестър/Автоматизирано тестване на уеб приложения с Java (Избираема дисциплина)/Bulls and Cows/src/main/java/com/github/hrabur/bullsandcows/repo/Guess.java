package com.github.hrabur.bullsandcows.repo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Guess {

  @Id
  @GeneratedValue
  @Column(name = "guess_id")
  private Long id;

  private String guessedNumber;
  private int bulls;
  private int cows;

  public Guess() {}

  public Guess(String guessedNumber, int bulls, int cows) {
    this.guessedNumber = guessedNumber;
    this.bulls = bulls;
    this.cows = cows;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getGuessedNumber() {
    return guessedNumber;
  }

  public void setGuessedNumber(String guessedNumber) {
    this.guessedNumber = guessedNumber;
  }

  public int getBulls() {
    return bulls;
  }

  public void setBulls(int bulls) {
    this.bulls = bulls;
  }

  public int getCows() {
    return cows;
  }

  public void setCows(int cows) {
    this.cows = cows;
  }
}
