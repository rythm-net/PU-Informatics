import React, { useEffect, useState } from "react";
import { createBrowserHistory } from "history";
import { createContext } from "react";
import { useContext } from "react";

const Route = ({ path, component }) => {
  const router = useContext(RouterContext);
  const pathname = router.location.pathname;
  if (pathname.match(path)) {
    return React.createElement(component);
  } else {
    return null;
  }
};

function Link({ to, children }) {
  const router = useContext(RouterContext);
  return (
    <a
      onClick={(e) => {
        e.preventDefault();
        router.history.push(to);
      }}
      href={to}
    >
      {children}
    </a>
  );
}

function Redirect({ to }) {
  const router = useContext(RouterContext);
  useEffect(() => {
    router.history.push(to);
  }, []);

  return null;
}

const RouterContext = createContext({
  history: createBrowserHistory(),
  location: window.location,
});

function Router(props) {
  const router = useContext(RouterContext);
  const [key, setKey] = useState(0); // for update

  useEffect(() => {
    router.history.listen(() => setKey((k) => k + 1));
  }, []);

  return <div key={key}>{props.children}</div>;
}

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

      <Route path="/atlantic" component={Atlantic} />
      <Route path="/pacific" component={Pacific} />
      <Route path="/black-sea" component={BlackSea} />
    </div>
  </Router>
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
