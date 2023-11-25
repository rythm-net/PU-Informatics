package entitites;

import abstract_entities.Unit;
import enums.AttackTypeEnum;
import enums.UnitClassEnum;

public class UnitPriest extends Unit
{
	public UnitPriest(int row, int col)	{super(UnitClassEnum.PRIEST, AttackTypeEnum.NONE, "P", "Priest", row, col, 5, 5, 0, 7, 3, true);}
}
