package lab;

import static io.restassured.RestAssured.when;
import static org.assertj.core.api.Assertions.assertThat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.hrabur.bullsandcows.repo.Guess;
import io.restassured.http.ContentType;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class FirstRestAssuaredTest {

  @JsonIgnoreProperties(ignoreUnknown = true)
  public static class Game {
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

  @Test
  void testStartNewGame() {
    var newGame =
        when()
            .post("http://localhost:8080/api/v1/games")
            .then()
            .statusCode(201)
            .contentType(ContentType.JSON)
            .extract()
            .as(Game.class);
    assertThat(newGame).isNotNull();
    assertThat(newGame.getGuesses().isEmpty());

    var game =
        when()
            .get("http://localhost:8080/api/v1/games/{gameId}", newGame.getId())
            .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .extract()
            .as(Game.class);
    assertThat(game).isNotNull();
    assertThat(game.getChosenNumber()).isEqualTo(newGame.getChosenNumber());
  }

  void testMakeGuess() {
    // TODO 1: Make new game
    // TODO 2: Call make guess on just created game
    // TODO 3: Check that: the new guess is there and contains correct guessdNumber, bulls & cows
    // are OK
  }
}
