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
      </ul>

      <hr />

      <Route path="/atlantic" component={Atlantic} />
      <Route path="/pacific" component={Pacific} />
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

export default App;
