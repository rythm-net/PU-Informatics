package com.github.hrabur.bullsandcows.api;

import com.github.hrabur.bullsandcows.repo.Guess;
import java.util.ArrayList;
import java.util.List;
import org.springframework.hateoas.RepresentationModel;

public class GameModel extends RepresentationModel<GameModel> {

  private Long id;
  private String chosenNumber;
  private List<Guess> guesses = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getChosenNumber() {
    return chosenNumber;
  }

  public void setChosenNumber(String chosenNumber) {
    this.chosenNumber = chosenNumber;
  }

  public List<Guess> getGuesses() {
    return guesses;
  }

  public void setGuesses(List<Guess> guesses) {
    this.guesses = guesses;
  }
}
