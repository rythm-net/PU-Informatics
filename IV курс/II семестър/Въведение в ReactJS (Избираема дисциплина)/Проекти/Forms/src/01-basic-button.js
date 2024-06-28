import React from "react";

const content = document.createElement("div");
document.body.appendChild(content);

function Component() {
  let onGreatClick = (evt) => {
    console.log("The user clicked button-1: great", evt);
  };

  let onAmazingClick = (evt) => {
    console.log("The user clicked button-2: amazing", evt);
  };

  return (
    <div>
      <h1>What do you think of React?</h1>

      <button name="button-1" value="great" onClick={onGreatClick}>
        Great
      </button>

      <button name="button-2" value="amazing" onClick={onAmazingClick}>
        Amazing
      </button>
    </div>
  );
}

Component.displayName = "01-basic-button";

export default Component;
