package com.github.hrabur.bullsandcows.api;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import com.github.hrabur.bullsandcows.repo.Game;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class GameModelAssembler extends RepresentationModelAssemblerSupport<Game, GameModel> {

  private TypeMap<Game, GameModel> gameToGameModel =
      new ModelMapper().createTypeMap(Game.class, GameModel.class);

  public GameModelAssembler() {
    super(GameApi.class, GameModel.class);
  }

  @Override
  public GameModel toModel(Game game) {
    var gameModel = gameToGameModel.map(game);
    return gameModel.add(
        linkTo(methodOn(GameApi.class).getGame(gameModel.getId())).withSelfRel(),
        linkTo(methodOn(GameApi.class).makeGuess(gameModel.getId(), null)).withRel("makeGuess"),
        linkTo(methodOn(GameApi.class).startNewGame(null)).withRel("newGame"));
  }
}
