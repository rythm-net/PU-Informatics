import React, { useState } from "react";
import validator from "validator";

import Field from "./08-field-component-field.js";
import CourseSelect from "./09-course-select.js";

const content = document.createElement("div");
document.body.appendChild(content);

function Component() {
  const [fields, setFields] = useState({
    name: "",
    email: "",
    course: null,
    department: null,
  });
  const [people, setPeople] = useState([]);
  const [fieldErrors, setFieldErrors] = useState({});

  let onFormSubmit = (evt) => {
    const person = fields;

    evt.preventDefault();

    if (validate()) return;

    setPeople(people.concat(person));
    setFields({
      name: "",
      email: "",
      course: null,
      department: null,
    });
  };

  let onInputChange = ({ name, value, error }) => {
    const updFields = Object.assign({}, fields);
    const updFieldErrors = Object.assign({}, fieldErrors);

    updFields[name] = value;
    updFieldErrors[name] = error;

    setFields(updFields);
    setFieldErrors(updFieldErrors);
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

        <input type="submit" disabled={validate()} />
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

Component.displayName = "09-async-fetch";

export default Component;
