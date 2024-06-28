import PropTypes from "prop-types";
import React, { useState } from "react";
import isEmail from "validator/lib/isEmail";
import Field from "./08-field-component-field";
import CourseSelect from "./09-course-select.js";
import { useEffect } from "react";

function FormComponent(props) {
  const [fields, setFields] = useState(
    props.fields || {
      name: "",
      email: "",
      course: null,
      department: null,
    }
  );
  const [fieldErrors, setFieldErrors] = useState({});

  useEffect(() => {
    // reset from parent
    if (props.fields !== fields) {
      setFields(props.fields);
    }
  }, [props.fields]);

  let onFormSubmit = (evt) => {
    const person = fields;

    evt.preventDefault();

    if (validate()) return;

    props.onSubmit([...props.people, person]);
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
    if (!person.course) return true;
    if (!person.department) return true;
    if (errMessages.length) return true;

    return false;
  };

  const dirty = Object.keys(fields).length;
  let status = props.saveStatus;
  if (status === "SUCCESS" && dirty) status = "READY";

  if (props.isLoading) {
    return <img alt="loading" src="/img/loading.gif" />;
  }
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

        <CourseSelect
          department={fields.department}
          course={fields.course}
          onChange={onInputChange}
        />

        <br />

        {
          {
            SAVING: <input value="Saving..." type="submit" disabled />,
            SUCCESS: <input value="Saved!" type="submit" disabled />,
            ERROR: (
              <input
                value="Save Failed - Retry?"
                type="submit"
                disabled={validate()}
              />
            ),
            READY: <input value="Submit" type="submit" disabled={validate()} />,
          }[status]
        }
      </form>

      <div>
        <h3>People</h3>
        <ul>
          {props.people.map(({ name, email, department, course }, i) => (
            <li key={i}>{[name, email, department, course].join(" - ")}</li>
          ))}
        </ul>
      </div>
    </div>
  );
}

FormComponent.propTypes = {
  people: PropTypes.array.isRequired,
  isLoading: PropTypes.bool.isRequired,
  saveStatus: PropTypes.string.isRequired,
  fields: PropTypes.object,
  onSubmit: PropTypes.func.isRequired,
};

FormComponent.displayName = "11-redux-form";

export default FormComponent;
