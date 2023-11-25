package abstract_entities;

public abstract class GameObject
{
	protected int row;
	protected int col;
	protected boolean isPassable;
	
	public GameObject(int row, int col)
	{
		this.row=row;
		this.col=col;
		this.makeObjectSolid();
	}
	
	public abstract String render();
	
	public void makeObjectPassable() {this.isPassable=true;}
	public void makeObjectSolid	  () {this.isPassable=false;}
	public boolean isPassable	  () {return this.isPassable;}
	
	public int  getRow() {return this.row;}
	public void setRow(int row) {this.row=row;}
	
	public int  getCol() {return this.col;}
	public void setCol(int col) {this.col=col;}
}
