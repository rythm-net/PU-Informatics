/* eslint no-underscore-dangle: [2, { "allow": ["_loading", "_saveStatus"] }] */

import React from "react";
import validator from "validator";
import { useState } from "react";
import { useEffect } from "react";
import Field from "./08-field-component-field";
import CourseSelect from "./09-course-select.js";

const content = document.createElement("div");
document.body.appendChild(content);

let apiClient;
function Component() {
  const [fields, setFields] = useState({
    name: "",
    email: "",
    course: null,
    department: null,
  });
  const [people, setPeople] = useState([]);
  const [fieldErrors, setFieldErrors] = useState({});
  const [_loading, _setLoading] = useState(false);
  const [_saveStatus, _setSaveStatus] = useState("READY");

  useEffect(() => {
    // component is created
    _setLoading(true);
    apiClient.loadPeople().then((people) => {
      _setLoading(false);
      setPeople(people);
    });
  }, []);

  let onFormSubmit = (evt) => {
    const person = fields;

    evt.preventDefault();

    if (validate()) return;

    const updPeople = [...people, person];

    _setSaveStatus("SAVING");
    apiClient
      .savePeople(updPeople)
      .then(() => {
        setPeople(updPeople);
        setFields({
          name: "",
          email: "",
          course: null,
          department: null,
        });
        _setSaveStatus("SUCCESS");
      })
      .catch((err) => {
        console.error(err);
        _setSaveStatus("ERROR");
      });
  };

  let onInputChange = ({ name, value, error }) => {
    const currentFields = Object.assign({}, fields);
    const currentFieldErrors = Object.assign({}, fieldErrors);

    currentFields[name] = value;
    currentFieldErrors[name] = error;

    setFields(currentFields);
    setFieldErrors(fieldErrors);
    _setSaveStatus("READY");
  };

  let validate = () => {
    const person = fields;
    const errMessages = Object.keys(fieldErrors).filter((k) => fieldErrors[k]);

    if (!person.name) return true;
    if (!person.email) return true;
    if (!person.course) return true;
    if (!person.department) return true;
    if (errMessages.length) return true;

    return false;
  };

  if (_loading) {
    return <img alt="loading" src="/img/loading.gif" />;
  }

  return (
    <div>
      <h1>Sign Up Sheet</h1>

      <form onSubmit={onFormSubmit}>
        <Field
          placeholder="Name"
          name="name"
          value={fields.name}
          onChange={onInputChange}
          validate={(val) => (val ? false : "Name Required")}
        />

        <br />

        <Field
          placeholder="Email"
          name="email"
          value={fields.email}
          onChange={onInputChange}
          validate={(val) => (validator.isEmail(val) ? false : "Invalid Email")}
        />

        <br />

        <CourseSelect
          department={fields.department}
          course={fields.course}
          onChange={onInputChange}
        />

        <br />

        {
          {
            SAVING: <input value="Saving..." type="submit" disabled />,
            SUCCESS: <input value="Saved!" type="submit" disabled />,
            ERROR: (
              <input
                value="Save Failed - Retry?"
                type="submit"
                disabled={validate()}
              />
            ),
            READY: <input value="Submit" type="submit" disabled={validate()} />,
          }[_saveStatus]
        }
      </form>

      <div>
        <h3>People</h3>
        <ul>
          {people.map(({ name, email, department, course }, i) => (
            <li key={i}>{[name, email, department, course].join(" - ")}</li>
          ))}
        </ul>
      </div>
    </div>
  );
}

Component.displayName = "10-remote-persist";

export default Component;

apiClient = {
  loadPeople: function () {
    return {
      then: function (cb) {
        setTimeout(() => {
          cb(JSON.parse(localStorage.people || "[]"));
        }, 1000);
      },
    };
  },

  savePeople: function (people) {
    const success = !!(this.count++ % 2);

    return new Promise((resolve, reject) => {
      setTimeout(() => {
        if (!success) return reject({ success });

        localStorage.people = JSON.stringify(people);
        return resolve({ success });
      }, 1000);
    });
  },

  count: 1,
};
