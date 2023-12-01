package fmi.patterns.command;

import java.util.ArrayList;

/**
 * Клас за управление на команди (под формата на {@link TaskEntry}).
 */
public class TaskMinder extends Thread {
	/**
	 * Колко често TaskMinder трябва да проверява за изпълнение на задачи
	 */
	private final long sleepInterval;
	
	/**
	 * Списък със задачи
	 */
	private final ArrayList<TaskEntry> taskList;

	public TaskMinder(long sleepInterval) {
		this.sleepInterval = sleepInterval;
		taskList = new ArrayList<>();
		start();
	}

	public void addTask(Task task, long repeatInterval) {
		long ri = (repeatInterval > 0) ? repeatInterval : 0;
		TaskEntry te = new TaskEntry(task, ri);
		taskList.add(te);
		System.out.println(te);
	}

	@SuppressWarnings({"InfiniteLoopStatement", "BusyWait"})
	@Override
	public void run() {
		while (true) {
			try {
				sleep(sleepInterval);
				long now = System.currentTimeMillis();

				for (TaskEntry te: taskList) {
					if (te.getRepeatInterval() + te.getTimeLastDone() < now) {
						te.getTask().performTask();
						te.setTimeLastDone(now);
					}
				}
			} catch (InterruptedException e) {
				System.out.println("Interrupted sleep: " + e);
			}
		}
	}
}



