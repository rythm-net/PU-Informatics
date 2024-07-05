import { useState } from "react";
import { useEffect } from "react";
import "./App.css";
// import "./client.js";
import client from "./client-axios.js";
import helpers from "./helpers.js";

/*
  eslint-disable react/prefer-stateless-function, react/jsx-boolean-value,
  no-undef, jsx-a11y/label-has-for, react/jsx-first-prop-new-line
*/
function TimersDashboard() {
  const [timers, setTimers] = useState([]);

  useEffect(() => {
    // component is created/updated
    loadTimersFromServer();
    const interval = setInterval(loadTimersFromServer, 5000);

    return () => {
      clearInterval(interval);
      console.log("Timer destroyed");
    };
  }, []);

  function loadTimersFromServer() {
    client.getTimers((serverTimers) => setTimers(serverTimers));
  }

  function handleCreateFormSubmit(timer) {
    createTimer(timer);
  }

  function handleEditFormSubmit(attrs) {
    updateTimer(attrs);
  }

  function handleTrashClick(timerId) {
    deleteTimer(timerId);
  }

  function handleStartClick(timerId) {
    startTimer(timerId);
  }

  function handleStopClick(timerId) {
    stopTimer(timerId);
  }

  // Inside TimersDashboard
  // ...
  function createTimer(timer) {
    const t = helpers.newTimer(timer);
    setTimers(timers.concat(t));

    client.createTimer(t);
  }

  function updateTimer(attrs) {
    setTimers(
      timers.map((timer) => {
        if (timer.id === attrs.id) {
          return Object.assign({}, timer, {
            title: attrs.title,
            project: attrs.project,
          });
        } else {
          return timer;
        }
      })
    );

    client.updateTimer(attrs);
  }

  function deleteTimer(timerId) {
    setTimers(timers.filter((t) => t.id !== timerId));

    client.deleteTimer({ id: timerId });
  }

  function startTimer(timerId) {
    // ...
    const now = Date.now();

    setTimers(
      timers.map((timer) => {
        if (timer.id === timerId) {
          return Object.assign({}, timer, {
            runningSince: now,
          });
        } else {
          return timer;
        }
      })
    );

    client.startTimer({ id: timerId, start: now });
  }

  function stopTimer(timerId) {
    const now = Date.now();

    setTimers(
      timers.map((timer) => {
        if (timer.id === timerId) {
          const lastElapsed = now - timer.runningSince;
          return Object.assign({}, timer, {
            elapsed: timer.elapsed + lastElapsed,
            runningSince: null,
          });
        } else {
          return timer;
        }
      })
    );

    client.stopTimer({ id: timerId, stop: now });
  }

  return (
    <div className="ui three column centered grid">
      <div className="column">
        <EditableTimerList
          timers={timers}
          onFormSubmit={handleEditFormSubmit}
          onTrashClick={handleTrashClick}
          onStartClick={handleStartClick}
          onStopClick={handleStopClick}
        />
        <ToggleableTimerForm onFormSubmit={handleCreateFormSubmit} />
      </div>
    </div>
  );
}

function ToggleableTimerForm({ onFormSubmit }) {
  const [isOpen, setIsOpen] = useState(false);

  function handleFormOpen() {
    setIsOpen(true);
  }

  function handleFormClose() {
    setIsOpen(false);
  }

  function handleFormSubmit(timer) {
    onFormSubmit(timer);
    setIsOpen(false);
  }

  if (isOpen) {
    return (
      <TimerForm
        onFormSubmit={handleFormSubmit}
        onFormClose={handleFormClose}
      />
    );
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

function EditableTimerList({
  timers,
  onFormSubmit,
  onTrashClick,
  onStartClick,
  onStopClick,
}) {
  const timersJSX = timers.map((timer) => (
    <EditableTimer
      key={timer.id}
      id={timer.id}
      title={timer.title}
      project={timer.project}
      elapsed={timer.elapsed}
      runningSince={timer.runningSince}
      onFormSubmit={onFormSubmit}
      onTrashClick={onTrashClick}
      onStartClick={onStartClick}
      onStopClick={onStopClick}
    />
  ));
  return <div id="timers">{timersJSX}</div>;
}

function EditableTimer({
  id,
  title,
  project,
  elapsed,
  runningSince,
  onFormSubmit,
  onTrashClick,
  onStartClick,
  onStopClick,
}) {
  const [editFormOpen, setEditFormOpen] = useState(false);

  function handleEditClick() {
    openForm();
  }

  function handleFormClose() {
    closeForm();
  }

  function handleSubmit(timer) {
    onFormSubmit(timer);
    closeForm();
  }

  function closeForm() {
    setEditFormOpen(false);
  }

  function openForm() {
    setEditFormOpen(true);
  }

  if (editFormOpen) {
    return (
      <TimerForm
        id={id}
        title={title}
        project={project}
        onFormSubmit={handleSubmit}
        onFormClose={handleFormClose}
      />
    );
  } else {
    return (
      <Timer
        id={id}
        title={title}
        project={project}
        elapsed={elapsed}
        runningSince={runningSince}
        onEditClick={handleEditClick}
        onTrashClick={onTrashClick}
        onStartClick={onStartClick}
        onStopClick={onStopClick}
      />
    );
  }
}

function Timer({
  id,
  elapsed,
  runningSince,
  title,
  project,
  onStartClick,
  onStopClick,
  onTrashClick,
  onEditClick,
}) {
  const [elapsedString, setElapsedString] = useState(
    helpers.renderElapsedString(elapsed, runningSince)
  );

  useEffect(() => {
    // component is created/updated
    const interval = setInterval(() => {
      console.log("Timer interval");
      setElapsedString(helpers.renderElapsedString(elapsed, runningSince));
    }, 50);

    return () => {
      console.log("Timer destroyed");
      clearInterval(interval); // component is destroyed
    };
  }, [elapsed, runningSince]);

  function handleStartClick() {
    onStartClick(id);
  }

  function handleStopClick() {
    onStopClick(id);
  }

  function handleTrashClick() {
    onTrashClick(id);
  }

  return (
    <div className="ui centered card">
      <div className="content">
        <div className="header">{title}</div>
        <div className="meta">{project}</div>
        <div className="center aligned description">
          <h2>{elapsedString}</h2>
        </div>
        <div className="extra content">
          <span className="right floated edit icon" onClick={onEditClick}>
            <i className="edit icon" />
          </span>
          <span className="right floated trash icon" onClick={handleTrashClick}>
            <i className="trash icon" />
          </span>
        </div>
      </div>
      <TimerActionButton
        timerIsRunning={!!runningSince}
        onStartClick={handleStartClick}
        onStopClick={handleStopClick}
      />
    </div>
  );
}

function TimerActionButton({ timerIsRunning, onStopClick, onStartClick }) {
  if (timerIsRunning) {
    return (
      <div
        className="ui bottom attached red basic button"
        onClick={onStopClick}
      >
        Stop
      </div>
    );
  } else {
    return (
      <div
        className="ui bottom attached green basic button"
        onClick={onStartClick}
      >
        Start
      </div>
    );
  }
}

function TimerForm({ id, title, project, onFormSubmit, onFormClose }) {
  const [titleState, setTitleState] = useState(title || "");
  const [projectState, setProjectState] = useState(project || "");

  function handleTitleChange(e) {
    setTitleState(e.target.value);
  }

  function handleProjectChange(e) {
    setProjectState(e.target.value);
  }

  function handleSubmit() {
    onFormSubmit({
      id: id,
      title: titleState,
      project: projectState,
    });
  }

  const submitText = id ? "Update" : "Create";
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
            <button className="ui basic blue button" onClick={handleSubmit}>
              {submitText}
            </button>
            <button className="ui basic red button" onClick={onFormClose}>
              Cancel
            </button>
          </div>
        </div>
      </div>
    </div>
  );
}

export default TimersDashboard;
