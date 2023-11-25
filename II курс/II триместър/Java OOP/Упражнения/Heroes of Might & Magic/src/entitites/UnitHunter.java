package entitites;

import abstract_entities.Unit;
import enums.AttackTypeEnum;
import enums.UnitClassEnum;

public class UnitHunter extends Unit
{
	public UnitHunter(int row, int col) {super(UnitClassEnum.HUNTER, AttackTypeEnum.RANGE, "H", "Hunter", row, col, 10, 10, 10, 5, 2, false);}
}
