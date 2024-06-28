import React from "react";
import { useState } from "react";
import { useRef } from "react";

const content = document.createElement("div");
document.body.appendChild(content);

// uncontrolled component
function Component() {
  const [names, setNames] = useState([]); // <-- initial state
  const inputRef = useRef(null);

  let onFormSubmit = (evt) => {
    const name = inputRef.current.value;
    setNames([...names, name]);
    inputRef.current.value = "";
    evt.preventDefault();
  };

  return (
    <div>
      <h1>Sign Up Sheet</h1>

      <form onSubmit={onFormSubmit}>
        <input placeholder="Name" ref={inputRef} />

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

Component.displayName = "04-basic-input";

export default Component;
