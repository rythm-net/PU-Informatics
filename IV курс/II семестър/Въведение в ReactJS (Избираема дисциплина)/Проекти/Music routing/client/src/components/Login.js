import React, { Component, useState } from "react";

import { Navigate as Redirect } from "react-router-dom";

import { client } from "../Client";
import { useLocation } from "react-router-dom";

function Login() {
  const [loginInProgress, setLoginInProgress] = useState(false);
  const [shouldRedirect, setShouldRedirect] = useState(false);

  let location = useLocation();

  let performLogin = () => {
    setLoginInProgress(true);
    client.login().then(() => setShouldRedirect(true));
  };

  let redirectPath = () => {
    const locationState = location.state;
    const pathname =
      locationState && locationState.from && locationState.from.pathname;
    return pathname || "/albums";
  };

  if (shouldRedirect) {
    return <Redirect to={redirectPath()} />;
  } else {
    return (
      <div className="ui one column centered grid">
        <div className="ten wide column">
          <div
            className="ui raised very padded text container segment"
            style={{ textAlign: "center" }}
          >
            <h2 className="ui green header">Fullstack Music</h2>
            {loginInProgress ? (
              <div className="ui active centered inline loader" />
            ) : (
              <div
                className="ui fluid large green submit button"
                onClick={performLogin}
              >
                Login
              </div>
            )}
          </div>
        </div>
      </div>
    );
  }
}

export default Login;
