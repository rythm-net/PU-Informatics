import React from "react";

import {
  BrowserRouter as Router,
  Routes,
  Route,
  Link,
  Navigate as Redirect,
} from "react-router-dom";

import TopBar from "./TopBar";
import PrivateRoute from "./PrivateRoute";
import AlbumsContainer from "./AlbumsContainer";
import Login from "./Login";
import Logout from "./Logout";

import "../styles/App.css";

const NoMatch = ({ location }) => (
  <div className="ui inverted red raised very padded text container segment">
    <strong>Error!</strong> No route found matching:
    <div className="ui inverted black segment">
      <code>{location.pathname}</code>
    </div>
  </div>
);

const App = () => (
  <div className="ui grid">
    <TopBar />
    <div className="spacer row" />
    <div className="row">
      <Routes>
        <Route
          path="/albums/*"
          element={<PrivateRoute Component={AlbumsContainer} />}
        ></Route>
        <Route path="/login" element={<Login />} />
        <Route path="/logout" element={<Logout />} />

        <Route exact path="/" render={() => <Redirect to="/albums" />} />

        <Route element={<NoMatch />} />
      </Routes>
    </div>
  </div>
);

export default App;
