import React from "react";
import { useState } from "react";
import { useEffect } from "react";
import { useLocation } from "react-router-dom";

import {
  BrowserRouter as Router,
  Routes,
  Route,
  Link,
  Navigate as Redirect,
} from "react-router-dom";

const App = () => (
  <Router>
    <div className="ui text container">
      <h2 className="ui dividing header">Which body of water?</h2>

      <ul>
        <li>
          <Link to="/atlantic">
            <code>/atlantic</code>
          </Link>
        </li>
        <li>
          <Link to="/pacific">
            <code>/pacific</code>
          </Link>
        </li>
        <li>
          <Link to="/black-sea">
            <code>/black-sea</code>
          </Link>
        </li>
      </ul>

      <hr />
      <Routes>
        <Route path="/atlantic" element={<Atlantic />} />
        <Route path="/atlantic/ocean" element={<AtlanticOcean />} />
        <Route path="/pacific" element={<Pacific />} />
        <Route path="/black-sea" element={<BlackSea />} />
        <Route path="/" element={<Home />} />
        <Route path="*" element={<NotFound />} />
      </Routes>
    </div>
  </Router>
);

const Home = () => <h3>Welcome! Select a body of saline water above.</h3>;

function NotFound() {
  let location = useLocation();

  return (
    <div className="ui inverted red segment">
      <h3>
        Error! No matches for <code>{location.pathname}</code>
      </h3>
    </div>
  );
}

const AtlanticOcean = () => (
  <div>
    <h3>Atlantic Ocean — Again!</h3>
    <p>Also known as "The Pond."</p>
  </div>
);

const Atlantic = () => (
  <div>
    <h3>Atlantic Ocean</h3>
    <p>
      The Atlantic Ocean covers approximately 1/5th of the surface of the earth.
    </p>
  </div>
);

const Pacific = () => (
  <div>
    <h3>Pacific Ocean</h3>
    <p>
      Ferdinand Magellan, a Portuguese explorer, named the ocean 'mar pacifico'
      in 1521, which means peaceful sea.
    </p>
  </div>
);

function BlackSea() {
  const [counter, setCounter] = useState(3);

  useEffect(() => {
    const interval = setInterval(() => {
      setCounter(function (prevCount) {
        return (prevCount -= 1);
      });
    }, 1000);

    return () => {
      clearInterval(interval);
    };
  }, []);

  return (
    <div>
      <h3>Black Sea</h3>
      <p>Nothing to sea [sic] here ...</p>
      <p>Redirecting in {counter}...</p>
      {counter < 1 ? <Redirect to="/" /> : null}
    </div>
  );
}

export default App;
