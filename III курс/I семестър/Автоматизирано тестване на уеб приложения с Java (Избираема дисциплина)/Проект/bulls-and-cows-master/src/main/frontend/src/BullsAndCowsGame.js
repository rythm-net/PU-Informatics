import queryString from "query-string";
import { useEffect, useState } from "react";
import { Button, Stack, Table } from "react-bootstrap";
import MaskedInput from "react-text-mask";
import "./BullsAndCowsGame.css";

function GuessInfo({ guessedNumber, bulls, cows, index }) {
  return (
    <tr>
      <td>{index}</td>
      <td className="BullsAndCowsGame-Number">{guessedNumber}</td>
      <td>{bulls}</td>
      <td>{cows}</td>
    </tr>
  );
}

export default function BullsAndCowsGame() {
  const [game, setGame] = useState({ chosenNumber: "1234" });
  const [showChosenNumber, setShowChosenNumber] = useState(false);
  const [guessedNumber, setGuessedNumber] = useState();
  // eslint-disable-next-line no-restricted-globals
  const { chosenNumber } = queryString.parse(location.search);

  const startNewGame = async () => {
    const response = await fetch("/api/v1/games", {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/x-www-form-urlencoded",
      },
      body: `chosenNumber=${chosenNumber}`,
    });
    const body = await response.json();
    if (response.ok) setGame(body);
  };

  useEffect(() => {
    startNewGame();
  }, []);

  const makeGuess = async (gameId, guessedNumber) => {
    const response = await fetch(`/api/v1/games/${gameId}/guesses`, {
      method: "POST",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/x-www-form-urlencoded",
      },
      body: `guessedNumber=${guessedNumber}`,
    });
    const body = await response.json();
    if (response.ok) setGame(body);
    if (body.guesses[body.guesses.length - 1].bulls === 4)
      setShowChosenNumber(true);
  };

  const handleMakeGuess = () => {
    makeGuess(game.id, guessedNumber);
    setGuessedNumber("");
  };

  const handleInputChange = (e) => {
    setGuessedNumber(e.target.value);
  };

  return (
    <Stack gap={2} className="col-xs-6 md-auto">
      <Table striped bordered className="BullsAndCowsGame-Table">
        <thead>
          <tr>
            <th>#</th>
            <th className="BullsAndCowsGame-Number">
              {showChosenNumber ? game.chosenNumber : "XXXX"}
            </th>
            <th>Bulls</th>
            <th>Cows</th>
          </tr>
        </thead>
        <tbody>
          {game?.guesses?.map((guess, idx) => (
            <GuessInfo {...guess} index={idx} />
          ))}
          {!showChosenNumber && (
            <tr>
              <td></td>
              <td className="BullsAndCowsGame-Number">
                <MaskedInput
                  mask={[/[1-9]/, /\d/, /\d/, /\d/]}
                  guide={false}
                  style={{ width: "4rem", textAlign: "center" }}
                  onChange={handleInputChange}
                  value={guessedNumber}
                />
              </td>
              <td colSpan={2}>
                <Button
                  variant="primary"
                  type="submit"
                  size="sm"
                  onClick={handleMakeGuess}
                  disabled={guessedNumber?.length !== 4}
                >
                  Check
                </Button>
              </td>
            </tr>
          )}
        </tbody>
      </Table>
      <div>
        {showChosenNumber ? (
          <Button
            onClick={() => {
              setShowChosenNumber(false);
              startNewGame();
            }}
          >
            Start new game
          </Button>
        ) : (
          <Button onClick={() => setShowChosenNumber(true)}>
            Show the number
          </Button>
        )}
      </div>
    </Stack>
  );
}
