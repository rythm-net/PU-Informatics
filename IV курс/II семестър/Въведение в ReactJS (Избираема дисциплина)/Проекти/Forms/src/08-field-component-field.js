import PropTypes from "prop-types";
import React from "react";
import { useState } from "react";

function FieldComponent(props) {
  const [value, setValue] = useState(props.value);
  const [error, setError] = useState(false);

  // reset from parent
  if (props.value !== value) {
    setValue(props.value);
  }

  let onChange = (evt) => {
    const name = props.name;
    const value = evt.target.value;
    const error = props.validate ? props.validate(value) : false;

    setValue(value);
    setError(error);

    props.onChange({ name, value, error });
  };

  return (
    <div>
      <input
        placeholder={props.placeholder}
        value={value}
        onChange={onChange}
      />
      <span style={{ color: "red" }}>{error}</span>
    </div>
  );
}

FieldComponent.propTypes = {
  placeholder: PropTypes.string,
  name: PropTypes.string.isRequired,
  value: PropTypes.string,
  validate: PropTypes.func,
  onChange: PropTypes.func.isRequired,
};

export default FieldComponent;
