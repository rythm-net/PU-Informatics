package abstract_entities;

public class Terrain extends GameObject
{
	public Terrain(int row, int col)
	{
		super(row, col);
		this.makeObjectPassable();
	}
	
	@Override
	public String render() {return ".";}
}
