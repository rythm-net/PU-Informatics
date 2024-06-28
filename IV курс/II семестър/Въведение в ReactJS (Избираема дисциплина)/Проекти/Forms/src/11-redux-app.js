import React from "react";
import { thunk } from "redux-thunk";
import { connect, Provider } from "react-redux";
import { createStore, applyMiddleware } from "redux";
import { reducer } from "./11-redux-reducer.js";
import { fetchPeople, savePeople } from "./11-redux-actions.js";
import { useEffect } from "react";
import Form from "./11-redux-form.js";

const store = createStore(reducer, applyMiddleware(thunk));

const ReduxForm = connect(mapStateToProps, mapDispatchToProps)(Form);

function Component() {
  useEffect(() => {
    // component is created
    store.dispatch(fetchPeople());
  }, []);

  return (
    <Provider store={store}>
      <ReduxForm />
    </Provider>
  );
}

Component.displayName = "11-redux-app";

export default Component;

function mapStateToProps(state) {
  return {
    isLoading: state.isLoading,
    fields: state.person,
    people: state.people,
    saveStatus: state.saveStatus,
  };
}

function mapDispatchToProps(dispatch) {
  return {
    onSubmit: (people) => {
      dispatch(savePeople(people));
    },
  };
}
