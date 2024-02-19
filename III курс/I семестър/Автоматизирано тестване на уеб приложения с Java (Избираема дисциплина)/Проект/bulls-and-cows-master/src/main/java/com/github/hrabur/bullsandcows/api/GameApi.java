package com.github.hrabur.bullsandcows.api;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import com.github.hrabur.bullsandcows.logic.BullsAndCowsService;
import com.github.hrabur.bullsandcows.logic.GameNotFoundException;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/games")
public class GameApi {

  private BullsAndCowsService bullsAndCowsService;
  private GameModelAssembler gameModelAssembler;

  public GameApi(BullsAndCowsService bullsAndCowsService, GameModelAssembler gameModelAssembler) {
    this.bullsAndCowsService = bullsAndCowsService;
    this.gameModelAssembler = gameModelAssembler;
  }

  @ResponseStatus(NOT_FOUND)
  @ExceptionHandler(GameNotFoundException.class)
  public Error handleGameNotFoundException(GameNotFoundException gameNotFoundException) {
    return new Error(gameNotFoundException.getMessage());
  }

  @GetMapping(produces = APPLICATION_JSON_VALUE)
  public CollectionModel<GameModel> listGames() {
    return null;
  }

  @ResponseStatus(CREATED)
  @PostMapping(produces = APPLICATION_JSON_VALUE)
  public GameModel startNewGame(@RequestParam(required = false) String chosenNumber) {
    var game =
        (chosenNumber != null && chosenNumber.length() == 4)
            ? bullsAndCowsService.startNewGame(chosenNumber)
            : bullsAndCowsService.startNewGame();
    return gameModelAssembler.toModel(game);
  }

  @GetMapping(path = "/{gameId}", produces = APPLICATION_JSON_VALUE)
  public GameModel getGame(@PathVariable Long gameId) {
    var game = bullsAndCowsService.getGameById(gameId);
    return gameModelAssembler.toModel(game);
  }

  @PostMapping(path = "/{gameId}/guesses", produces = APPLICATION_JSON_VALUE)
  public GameModel makeGuess(@PathVariable Long gameId, @RequestParam String guessedNumber) {
    var game = bullsAndCowsService.makeGuess(gameId, guessedNumber);
    return gameModelAssembler.toModel(game);
  }
}
