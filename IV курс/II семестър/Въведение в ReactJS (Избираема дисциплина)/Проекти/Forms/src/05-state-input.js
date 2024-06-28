import React from "react";
import { useState } from "react";

const content = document.createElement("div");
document.body.appendChild(content);

//controlled component
function Component() {
  const [name, setName] = useState("");
  const [names, setNames] = useState([]);

  let onFormSubmit = (evt) => {
    setNames([...names, name]);
    setName("");
    evt.preventDefault();
  };

  let onNameChange = (evt) => {
    setName(evt.target.value);
  };

  return (
    <div>
      <h1>Sign Up Sheet</h1>

      <form onSubmit={onFormSubmit}>
        <input placeholder="Name" value={name} onChange={onNameChange} />

        <input type="submit" />
      </form>

      <div>
        <h3>Names</h3>
        <ul>
          {names.map((name, i) => (
            <li key={i}>{name}</li>
          ))}
        </ul>
      </div>
    </div>
  );
}

Component.displayName = "05-state-input";

export default Component;
