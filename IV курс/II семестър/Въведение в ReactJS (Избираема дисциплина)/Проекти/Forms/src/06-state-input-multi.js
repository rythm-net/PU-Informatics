import React from "react";
import { useState } from "react";

const content = document.createElement("div");
document.body.appendChild(content);

function Component() {
  const [fields, setFields] = useState({
    name: "",
    email: "",
  });
  const [people, setPeople] = useState([]);

  let onFormSubmit = (evt) => {
    setPeople([...people, fields]);
    setFields({
      name: "",
      email: "",
    });
    evt.preventDefault();
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

        <input
          placeholder="Email"
          name="email"
          value={fields.email}
          onChange={onInputChange}
        />

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

Component.displayName = "06-state-input-multi";

export default Component;
