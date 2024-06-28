import React from "react";
import isEmail from "validator/lib/isEmail";
import { useState } from "react";
import Field from "./08-field-component-field";

const content = document.createElement("div");
document.body.appendChild(content);

function Component() {
  const [fields, setFields] = useState({
    name: "",
    email: "",
  });
  const [people, setPeople] = useState([]);
  const [fieldErrors, setFieldErrors] = useState({});

  let onFormSubmit = (evt) => {
    const person = fields;

    evt.preventDefault();

    if (validate()) return;

    setPeople([...people, person]);
    setFields({
      name: "",
      email: "",
    });
  };

  let onInputChange = ({ name, value, error }) => {
    const currentFields = Object.assign({}, fields);
    const currentFieldErrors = Object.assign({}, fieldErrors);

    currentFields[name] = value;
    currentFieldErrors[name] = error;

    setFields(currentFields);
    setFieldErrors(currentFieldErrors);
  };

  let validate = () => {
    const person = fields;
    const errMessages = Object.keys(fieldErrors).filter((k) => fieldErrors[k]);

    if (!person.name) return true;
    if (!person.email) return true;
    if (errMessages.length) return true;

    return false;
  };

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
          validate={(val) => (isEmail(val) ? false : "Invalid Email")}
        />

        <br />

        <input type="submit" disabled={validate()} />
      </form>

      <div>
        <h3>People</h3>
        <ul>
          {people.map(({ name, email }, i) => (
            <li key={i}>
              {name} ({email})
            </li>
          ))}
        </ul>
      </div>
    </div>
  );
}

Component.displayName = "08-field-component-form";

export default Component;
