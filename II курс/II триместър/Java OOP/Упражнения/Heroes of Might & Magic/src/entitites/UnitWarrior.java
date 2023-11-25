package entitites;

import abstract_entities.Unit;
import enums.AttackTypeEnum;
import enums.UnitClassEnum;

public class UnitWarrior extends Unit
{
	public UnitWarrior(int row, int col) {super(UnitClassEnum.HUNTER, AttackTypeEnum.SLASH, "W", "Warrior", row, col, 15, 15, 20, 1, 1, false);}
}
