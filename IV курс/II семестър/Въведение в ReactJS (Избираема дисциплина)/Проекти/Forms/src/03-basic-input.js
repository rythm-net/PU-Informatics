import React, { useRef } from "react";

const content = document.createElement("div");
document.body.appendChild(content);

function Component() {
  const inputRef = useRef(null);

  let onFormSubmit = (evt) => {
    evt.preventDefault();
    console.log(inputRef.current.value);
  };

  return (
    <div>
      <h1>Sign Up Sheet</h1>

      <form onSubmit={onFormSubmit}>
        <input placeholder="Name" ref={inputRef} />

        <input type="submit" />
      </form>
    </div>
  );
}

Component.displayName = "03-basic-input";

export default Component;
