import React from "react";
// import isEmail from "validator/lib/isEmail";
import { useState } from "react";
import validator from "validator";

const content = document.createElement("div");
document.body.appendChild(content);

function Component() {
  const [fields, setFields] = useState({
    name: "",
    email: "",
  });
  const [people, setPeople] = useState([]);
  const [fieldErrors, setFieldErrors] = useState({});

  let validate = (person) => {
    const errors = {};
    if (!person.name) errors.name = "Name Required";
    if (!person.email) errors.email = "Email Required";
    if (person.email && !validator.isEmail(person.email))
      errors.email = "Invalid Email";
    return errors;
  };

  let onFormSubmit = (evt) => {
    const person = fields;
    const currentFieldErrors = validate(person);
    setFieldErrors(currentFieldErrors);
    evt.preventDefault();

    if (Object.keys(currentFieldErrors).length) return;

    setPeople([...people, person]);
    setFields({
      name: "",
      email: "",
    });
  };

  let onInputChange = (evt) => {
    const updFields = Object.assign({}, fields);
    updFields[evt.target.name] = evt.target.value;
    setFields(updFields);
  };

  return (
    <div>
      <h1>Sign Up Sheet</h1>

      <form onSubmit={onFormSubmit}>
        <input
          placeholder="Name"
          name="name"
          value={fields.name}
          onChange={onInputChange}
        />

        <span style={{ color: "red" }}>{fieldErrors.name}</span>

        <br />

        <input
          placeholder="Email"
          name="email"
          value={fields.email}
          onChange={onInputChange}
        />

        <span style={{ color: "red" }}>{fieldErrors.email}</span>

        <br />

        <input type="submit" />
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

Component.displayName = "07-basic-validation";

export default Component;
