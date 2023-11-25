package players;

import java.util.ArrayList;

import abstract_entities.Unit;

public class Player
{
	private ArrayList<Unit> unitCollection;
	public  ArrayList<Unit> getUnitCollection() {return this.unitCollection;}
	
	public Player()	{this.unitCollection=new ArrayList<>();}
	
	public void add(Unit gameUnit) {this.unitCollection.add(gameUnit);}
}
