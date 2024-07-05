import "./App.css";

/*
  eslint-disable react/prefer-stateless-function, react/jsx-boolean-value,
  no-undef, jsx-a11y/label-has-for
*/
export default function TimersDashboard() {
  return (
    <div className="ui three column centered grid">
      <div className="column">
        <EditableTimerList />
        <ToggleableTimerForm isOpen={false} />
      </div>
    </div>
  );
}

function ToggleableTimerForm({ isOpen }) {
  if (isOpen) {
    return <TimerForm />;
  } else {
    return (
      <div className="ui basic content center aligned segment">
        <button className="ui basic button icon">
          <i className="plus icon" />
        </button>
      </div>
    );
  }
}

function EditableTimerList() {
  return (
    <div id="timers">
      <EditableTimer
        title="Learn React"
        project="Web Domination"
        elapsed="8986300"
        runningSince={null}
        editFormOpen={false}
      />
      <EditableTimer
        title="Learn extreme ironing"
        project="World Domination"
        elapsed="3890985"
        runningSince={null}
        editFormOpen={true}
      />
    </div>
  );
}

function EditableTimer({
  editFormOpen,
  title,
  project,
  elapsed,
  runningSince,
}) {
  if (editFormOpen) {
    return <TimerForm title={title} project={project} />;
  } else {
    return (
      <Timer
        title={title}
        project={project}
        elapsed={elapsed}
        runningSince={runningSince}
      />
    );
  }
}

function Timer({ elapsed, title, project }) {
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
  const submitText = title ? "Update" : "Create";
  return (
    <div className="ui centered card">
      <div className="content">
        <div className="ui form">
          <div className="field">
            <label>Title</label>
            <input type="text" defaultValue={title} />
          </div>
          <div className="field">
            <label>Project</label>
            <input type="text" defaultValue={project} />
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
