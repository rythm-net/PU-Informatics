package fmi.patterns.command;

/**
 * Команда, извеждаща хипотетично предсказание
 */
public class FortuneTask implements Task {

	private int nextFortune = 0;
	private final String[] fortunes = {
			"Който учи той ще сполучи",
			"Опознай шаблоните и научи истината",
			"Сговорна дружина планина повдига"
	};

	@Override
	public void performTask() {
		System.out.println("Твоето бъдеще е: " + fortunes[nextFortune]);

		nextFortune = (nextFortune + 1) % fortunes.length;
	}

	@Override
	public String toString() {
		return ("Task: Предсказател");
	}
}

