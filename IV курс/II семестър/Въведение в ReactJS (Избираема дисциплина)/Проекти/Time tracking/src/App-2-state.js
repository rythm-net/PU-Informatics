import { useState } from "react";
import "./App.css";
import helpers from "./helpers.js";

/*
  eslint-disable react/prefer-stateless-function, react/jsx-boolean-value,
  no-undef, jsx-a11y/label-has-for, react/jsx-first-prop-new-line
*/

export default function TimersDashboard() {
  const [timers, setTimers] = useState([
    {
      title: "Practice squat",
      project: "Gym Chores",
      id: 1,
      elapsed: 5456099,
      runningSince: Date.now(),
    },
    {
      title: "Bake squash",
      project: "Kitchen Chores",
      id: 2,
      elapsed: 1273998,
      runningSince: null,
    },
  ]);

  return (
    <div className="ui three column centered grid">
      <div className="column">
        <EditableTimerList timers={timers} />
        <ToggleableTimerForm />
      </div>
    </div>
  );
}

function ToggleableTimerForm() {
  const [isOpen, setIsOpen] = useState(false);

  let handleFormOpen = () => {
    setIsOpen(true);
  };

  if (isOpen) {
    return <TimerForm />;
  } else {
    return (
      <div className="ui basic content center aligned segment">
        <button className="ui basic button icon" onClick={handleFormOpen}>
          <i className="plus icon" />
        </button>
      </div>
    );
  }
}

function EditableTimerList({ timers }) {
  const timersJSX = timers.map((timer) => (
    <EditableTimer
      key={timer.id}
      id={timer.id}
      title={timer.title}
      project={timer.project}
      elapsed={timer.elapsed}
      runningSince={timer.runningSince}
    />
  ));
  return <div id="timers">{timersJSX}</div>;
}

function EditableTimer({ id, title, project, elapsed, runningSince }) {
  const [editFormOpen, setEditFormOpen] = useState(false);

  if (editFormOpen) {
    return <TimerForm id={id} title={title} project={project} />;
  } else {
    return (
      <Timer
        id={id}
        title={title}
        project={project}
        elapsed={elapsed}
        runningSince={runningSince}
      />
    );
  }
}

function Timer({ title, project, elapsed }) {
  const elapsedString = helpers.renderElapsedString(elapsed);
  return (
    <div className="ui centered card">
      <div className="content">
        <div className="header">{title}</div>
        <div className="meta">{project}</div>
        <div className="center aligned description">
          <h2>{elapsedString}</h2>
        </div>
        <div className="extra content">
          <span className="right floated edit icon">
            <i className="edit icon" />
          </span>
          <span className="right floated trash icon">
            <i className="trash icon" />
          </span>
        </div>
      </div>
      <div className="ui bottom attached blue basic button">Start</div>
    </div>
  );
}

function TimerForm({ title, project }) {
  const [titleState, setTitleState] = useState(title || "");
  const [projectState, setProjectState] = useState(project || "");

  let handleTitleChange = (e) => {
    setTitleState(e.target.value);
  };

  let handleProjectChange = (e) => {
    setProjectState(e.target.value);
  };

  const submitText = title ? "Update" : "Create";
  return (
    <div className="ui centered card">
      <div className="content">
        <div className="ui form">
          <div className="field">
            <label>Title</label>
            <input
              type="text"
              value={titleState}
              onChange={handleTitleChange}
            />
          </div>
          <div className="field">
            <label>Project</label>
            <input
              type="text"
              value={projectState}
              onChange={handleProjectChange}
            />
          </div>
          <div className="ui two bottom attached buttons">
            <button className="ui basic blue button">{submitText}</button>
            <button className="ui basic red button">Cancel</button>
          </div>
        </div>
      </div>
    </div>
  );
}
