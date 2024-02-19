import { useState } from "react";
import { Button, Col, Form, Row, Stack } from "react-bootstrap";
import MaskedInput from "react-text-mask";
import "./BullsAndCowsGame.css";

function GuessInfo({ guessedNumber, bulls, cows }) {
  return (
    <Row>
      <Col xs="6" className="BullsAndCowsGame-NumbersCol">
        {guessedNumber}
      </Col>
      <Col xs="6">{`${bulls}б ${cows}к`}</Col>
    </Row>
  );
}

export default function BullsAndCowsGame() {
  const [game, setGame] = useState({ chosenNumber: "1234" });

  const guesses = [
    { guessedNumber: "1234", bulls: 1, cows: 1 },
    { guessedNumber: "1234", bulls: 1, cows: 1 },
    { guessedNumber: "1234", bulls: 1, cows: 1 },
  ];

  return (
    <Stack gap={2} className="col-md-5 mx-auto">
      <Row>
        <Col xs="6" className="BullsAndCowsGame-NumbersCol">
          {game.chosenNumber}
        </Col>
        <Col xs="6"></Col>
      </Row>
      {guesses.map((guess) => (
        <GuessInfo {...guess} />
      ))}
      <Form>
        <Row>
          <Col xs="6" className="BullsAndCowsGame-NumbersCol">
            <MaskedInput
              mask={[/[1-9]/, /\d/, /\d/, /\d/]}
              guide={true}
              style={{ width: "4rem" }}
            />
          </Col>
          <Col xs="6">
            <Button variant="primary" type="submit">
              Провери
            </Button>
          </Col>
        </Row>
      </Form>
    </Stack>
  );
}
