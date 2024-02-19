package com.github.hrabur.bullsandcows.logic;

import static java.lang.String.format;

public class GameNotFoundException extends RuntimeException {

  public GameNotFoundException(Long gameId) {
    super(format("Game with ID [%s] does not exist", gameId));
  }

  private static final long serialVersionUID = -153573585096328190L;
}
