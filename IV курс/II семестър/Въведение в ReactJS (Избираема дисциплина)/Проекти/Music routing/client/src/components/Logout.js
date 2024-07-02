import React, { Component } from "react";

import { Navigate as Redirect } from "react-router-dom";

import { client } from "../Client";

function Logout() {
  client.logout();

  return <Redirect to="/login" />;
}

export default Logout;
