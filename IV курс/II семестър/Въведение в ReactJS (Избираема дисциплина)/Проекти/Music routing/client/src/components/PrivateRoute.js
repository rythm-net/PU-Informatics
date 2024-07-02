/* eslint-disable no-shadow */
import React from "react";

import { Route, Routes, Navigate as Redirect } from "react-router-dom";

import { client } from "../Client";

const PrivateRoute = ({ Component }) => {
  // Your authentication logic goes here...

  return client.isLoggedIn() ? <Component /> : <Redirect to="/login" />;
};

// const PrivateRoute = ({ component, ...rest }) => (
//   <Routes>
//     <Route
//       {...rest}
//       render={(props) =>
//         client.isLoggedIn() ? (
//           React.createElement(component, props)
//         ) : (
//           <Redirect
//             to={{
//               pathname: "/login",
//               state: { from: props.location },
//             }}
//           />
//         )
//       }
//     />
//   </Routes>
// );

export default PrivateRoute;
