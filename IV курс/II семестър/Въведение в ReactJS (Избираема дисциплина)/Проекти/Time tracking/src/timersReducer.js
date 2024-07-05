export default function timersReducer(timers, action) {
  switch (action.type) {
    case "initialized": {
      return action.timers;
    }
    case "created": {
      return [...timers, action.timer];
    }
    case "updated": {
      return timers.map((timer) => {
        if (timer.id === action.timer.id) {
          return Object.assign({}, timer, {
            title: action.timer.title,
            project: action.timer.project,
          });
        } else {
          return timer;
        }
      });
    }
    case "deleted": {
      return timers.filter((t) => t.id !== action.timerId);
    }
    case "started": {
      const now = Date.now();

      return timers.map((timer) => {
        if (timer.id === action.timerId) {
          return Object.assign({}, timer, {
            runningSince: now,
          });
        } else {
          return timer;
        }
      });
    }
    case "stopped": {
      return timers.map((timer) => {
        if (timer.id === action.timerId) {
          const lastElapsed = Date.now() - timer.runningSince;
          return Object.assign({}, timer, {
            elapsed: timer.elapsed + lastElapsed,
            runningSince: null,
          });
        } else {
          return timer;
        }
      });
    }
    default: {
      throw Error("Unknown action: " + action.type);
    }
  }
}
