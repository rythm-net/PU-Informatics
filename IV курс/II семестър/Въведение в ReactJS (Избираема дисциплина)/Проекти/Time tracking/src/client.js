/* eslint-disable no-console */
/* eslint-disable no-undef */
function getTimers(success) {
  return fetch("http://localhost:3001/api/timers", {
    headers: {
      Accept: "application/json",
    },
  })
    .then(checkStatus)
    .then(parseJSON)
    .then(success)
    .catch(console.error);
}

function createTimer(data) {
  return fetch("http://localhost:3001/api/timers", {
    method: "post",
    body: JSON.stringify(data),
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  }).then(checkStatus);
}

function updateTimer(data) {
  return fetch("http://localhost:3001/api/timers", {
    method: "put",
    body: JSON.stringify(data),
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  }).then(checkStatus);
}

function deleteTimer(data) {
  return fetch("http://localhost:3001/api/timers", {
    method: "delete",
    body: JSON.stringify(data),
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  }).then(checkStatus);
}

function startTimer(data) {
  return fetch("http://localhost:3001/api/timers/start", {
    method: "post",
    body: JSON.stringify(data),
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  }).then(checkStatus);
}

function stopTimer(data) {
  return fetch("http://localhost:3001/api/timers/stop", {
    method: "post",
    body: JSON.stringify(data),
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
  }).then(checkStatus);
}

function checkStatus(response) {
  if (response.status >= 200 && response.status < 300) {
    return response;
  } else {
    const error = new Error(`HTTP Error ${response.statusText}`);
    error.status = response.statusText;
    error.response = response;
    console.log(error);
    throw error;
  }
}

function parseJSON(response) {
  return response.json();
}

const client = {
  getTimers,
  createTimer,
  updateTimer,
  startTimer,
  stopTimer,
  deleteTimer,
};

export default client;
