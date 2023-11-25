package abstract_entities;

import enums.AttackTypeEnum;
import enums.UnitClassEnum;

public abstract class Unit extends GameObject
{
	protected UnitClassEnum unitClass;
	protected AttackTypeEnum attackType;
	
	protected int health;
	protected int attack;
	protected int defence;
	
	protected int rangeIndex;
	protected int moveIndex;
	
	protected boolean canFly;
	
	protected String sign;
	protected String longSign;
	
	public Unit(UnitClassEnum unitClass, AttackTypeEnum attackType, String sign, String longSign, int row, int col, int health, int attack, int defence, int rangeIndex, int moveIndex, boolean canFly)
	{
		super(row, col);
		
		this.unitClass =unitClass;
		this.attackType=attackType;
		this.sign	   =sign;
		this.longSign  =longSign;
		this.health	   =health;
		this.attack	   =attack;
		this.defence   =defence;
		this.rangeIndex=rangeIndex;
		this.moveIndex =moveIndex;
		this.canFly    =canFly;
	}
	
	public String render() 		   {return this.sign;}
	public String dialogueRender() {return "["+this.sign+"] - "+this.longSign;}
	
	public void move(int row, int col)
	{
		this.setRow(row);
		this.setCol(col);
	}
	public void move(GameObject destination) {this.move(destination.getRow(), destination.getCol());}
}
