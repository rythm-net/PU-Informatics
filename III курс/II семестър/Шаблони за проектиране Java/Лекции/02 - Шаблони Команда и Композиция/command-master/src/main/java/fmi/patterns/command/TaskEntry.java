package fmi.patterns.command;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;

/**
 * Класът {@link TaskEntry} допълва команда (под формата на {@link Task}) с метаданни, описващи през колко време трябва
 * да се изпълнява командата ({@code repeatInterval}) и кога за последно е била изпълнена ({@code timeLastDone}).
 */
@Getter
@Setter
public class TaskEntry {
	/**
	 * Задачата, която трябва да бъде изпълнена. Това е обект Команда!
	 */
	private final Task task;

	/**
	 * Колко често трябва да бъде изпълнявана задачата
	 */
	private long repeatInterval;

	/**
	 * Кога за последно е била изпълнена задачата
	 */
	private long timeLastDone;

	public TaskEntry(Task task, long repeatInterval) {
		this.task = task;
		this.repeatInterval = repeatInterval;
		this.timeLastDone = System.currentTimeMillis();
	}

	@Override
	public String toString() {
		return (task + " трябва да бъде изпълнявана на всеки " + repeatInterval
				+ " ms; за последно е изпълнена на " + Instant.ofEpochMilli(timeLastDone));
	}
}



