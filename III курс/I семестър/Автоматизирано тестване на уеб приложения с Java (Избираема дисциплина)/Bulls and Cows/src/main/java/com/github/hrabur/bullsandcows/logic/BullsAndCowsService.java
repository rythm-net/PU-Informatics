package com.github.hrabur.bullsandcows.logic;

import com.github.hrabur.bullsandcows.repo.Game;

public interface BullsAndCowsService {
  Game startNewGame();

  Game startNewGame(String chosenNumber);

  Game getGameById(Long gameId);

  Game makeGuess(Long gameId, String guess);
}
