package entitites;

import abstract_entities.Unit;
import enums.AttackTypeEnum;
import enums.UnitClassEnum;

public class UnitMage extends Unit
{
	public UnitMage(int row, int col) {super(UnitClassEnum.MAGE, AttackTypeEnum.MAGIC, "M", "Mage", row, col, 5, 5, 15, 7, 3, true);}
}
