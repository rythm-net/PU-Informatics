import axios from "axios";

/* eslint-disable no-console */
/* eslint-disable no-undef */
function getTimers(success) {
  return axios
    .get("http://localhost:3001/api/timers", {
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
  return axios
    .post("http://localhost:3001/api/timers", JSON.stringify(data), {
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    })
    .then(checkStatus);
}

function updateTimer(data) {
  return axios
    .put("http://localhost:3001/api/timers", JSON.stringify(data), {
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    })
    .then(checkStatus);
}

function deleteTimer(data) {
  return axios
    .delete("http://localhost:3001/api/timers", {
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
      data: JSON.stringify(data),
    })
    .then(checkStatus);
}

function startTimer(data) {
  return axios
    .post("http://localhost:3001/api/timers/start", JSON.stringify(data), {
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    })
    .then(checkStatus);
}

function stopTimer(data) {
  return axios
    .post("http://localhost:3001/api/timers/stop", JSON.stringify(data), {
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
      },
    })
    .then(checkStatus);
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
  return response.data;
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
