import React from "react";

const content = document.createElement("div");
document.body.appendChild(content);

function Component() {
  let onButtonClick = (evt) => {
    const btn = evt.target;
    console.log(`The user clicked ${btn.name}: ${btn.value}`);
  };

  return (
    <div>
      <h1>What do you think of React?</h1>

      <button name="button-1" value="great" onClick={onButtonClick}>
        Great
      </button>

      <button name="button-2" value="amazing" onClick={onButtonClick}>
        Amazing
      </button>
    </div>
  );
}

Component.displayName = "02-basic-button";

export default Component;
