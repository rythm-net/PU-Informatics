package com.github.hrabur.bullsandcows.logic;

import com.github.hrabur.bullsandcows.repo.Game;
import com.github.hrabur.bullsandcows.repo.GameRepo;
import com.github.hrabur.bullsandcows.repo.Guess;
import java.util.HashSet;
import java.util.Random;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class BullsAndCowsServiceImpl implements BullsAndCowsService {

  private GameRepo gameRepo;

  public BullsAndCowsServiceImpl(GameRepo gameRepo) {
    this.gameRepo = gameRepo;
  }

  @Override
  public Game startNewGame() {
    var chosenNumber = generateNumber();
    return startNewGame(chosenNumber);
  }

  @Override
  public Game startNewGame(String chosenNumber) {
    var game = new Game(chosenNumber);
    gameRepo.save(game);
    return game;
  }

  @Override
  public Game getGameById(Long gameId) {
    var _game = gameRepo.findById(gameId);
    if (_game.isEmpty()) {
      throw new GameNotFoundException(gameId);
    }

    return _game.get();
  }

  @Override
  public Game makeGuess(Long gameId, String guessedNumber) {
    var game = getGameById(gameId);
    var guess = checkGuess(game.getChosenNumber(), guessedNumber);
    game.getGuesses().add(guess);
    return game;
  }

  String generateNumber() {
    var used = new HashSet<>();
    var buff = new StringBuilder();
    for (int i = 0; i < 4; i++) {
      int digit;
      while (true) {
        digit = nextRandomDigit();
        if (i == 0 && digit == 0) continue;
        if (used.contains(digit)) continue;
        used.add(digit);
        break;
      }

      buff.append(digit);
    }

    return buff.toString();
  }

  int nextRandomDigit() {
    var random = new Random();
    return random.nextInt(10);
  }

  Guess checkGuess(String chosen, String guessed) {
    int bulls = 0, cows = 0;
    for (int gi = 0; gi < guessed.length(); gi++) {
      for (int ci = 0; ci < chosen.length(); ci++) {
        if (guessed.charAt(gi) == chosen.charAt(ci)) {
          if (gi == ci) {
            bulls++;
          } else {
            cows++;
          }
        }
      }
    }

    return new Guess(guessed, bulls, cows);
  }
}
