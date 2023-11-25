package main;

import java.util.ArrayList;
import java.util.Scanner;

import abstract_entities.GameObject;
import abstract_entities.Terrain;
import abstract_entities.Unit;
import entitites.UnitMage;
import entitites.UnitWarrior;
import players.Player;
import util.Terminal;

public class GameManager
{
	private GameObject[][] arena;
	private final int ARENA_SIZE=3;
	
	private Scanner inputScanner;
	private final String COMMAND_SELECT_UNIT="U";
	private final String COMMAND_END_TURN	="E";
	private final String COMMAND_ATTACK		="A";
	private final String COMMAND_MOVE  		="M";
	
	private Player activePlayer;
	private Unit   activeUnit;
	
	public GameManager()
	{
		this.arena=new GameObject[ARENA_SIZE][ARENA_SIZE];
		
		UnitWarrior player1Warrior=new UnitWarrior(1, 0);
		UnitMage 	player1Mage   =new UnitMage	  (2, 0);
		
		this.positionGameObjectOverTheArena(new Terrain(0, 0));
		this.positionGameObjectOverTheArena(new Terrain(0, 1));
		this.positionGameObjectOverTheArena(new Terrain(0, 2));
//		this.arena[0][0]=new Terrain();
//		this.arena[0][1]=new Terrain();
//		this.arena[0][2]=new Terrain();
		
		this.positionGameObjectOverTheArena(player1Warrior);
		this.positionGameObjectOverTheArena(new Terrain(1, 1));
		this.positionGameObjectOverTheArena(new Terrain(1, 2));
//		this.arena[1][0]=player1Warrior;
//		this.arena[1][1]=new Terrain();
//		this.arena[1][2]=new Terrain();
		
		this.positionGameObjectOverTheArena(player1Mage);
		this.positionGameObjectOverTheArena(new Terrain(2, 1));
		this.positionGameObjectOverTheArena(new Terrain(2, 2));
//		this.arena[2][0]=player1Mage;
//		this.arena[2][1]=new Terrain();
//		this.arena[2][2]=new Terrain();
		
		Player player1=new Player();
		player1.add(player1Warrior);
		player1.add(player1Mage);
		
		this.setActivePlayer(player1);
	}
	
	public void start()
	{
		while(this.isGameOn())
		{
			// Актуализация на бойното поле
			this.renderArena();
			// Възможни действия с единиците
			this.initDialogue();
		}
	}
	
	private boolean isGameOn() {return true;}
	
	private void setActivePlayer(Player player)	{this.activePlayer=player;}
	private Player getActivePlayer() {return 	 this.activePlayer;}
	
	private void setActiveUnit(Unit unit) {this.activeUnit=unit;}
	private Unit getActiveUnit() {return   this.activeUnit;}
	
	private GameObject getGameObjectFromArena(int row, int col) {return this.arena[row][col];}
	
	private void renderArena()
	{
		for(int i=0; i<this.ARENA_SIZE; i++)
		{
			for(int j=0; j<this.ARENA_SIZE; j++)
			{
				GameObject currentObject=this.arena[i][j];
				System.out.print(currentObject.render()+" ");
			}
			System.out.println();
		}
	}
	
	private void initDialogue()
	{
		System.out.println("[U] - Изберете единица");
		System.out.println("[E] - Край на хода");
		String command=Terminal.inputString();
		
		if(command.equals(COMMAND_SELECT_UNIT))
			this.playerUnitDialogue();
		
		if(command.equals(COMMAND_END_TURN))
		{
			
		}
	}
	
	private void renderPlayerUnit(ArrayList<Unit> unitCollection)
	{
		for(int i=0; i<unitCollection.size(); i++)
		{
			Unit gameUnit=unitCollection.get(i);
			System.out.println(i+" - "+gameUnit.dialogueRender());
		}
	}
	
	private void selectUnit()
	{
		Player player=this.getActivePlayer();
		ArrayList <Unit> unitCollection=player.getUnitCollection();
		
		// Избор на бойна единица
		while(true)
		{
			this.renderPlayerUnit(unitCollection);
			int selectedUnitID=Terminal.inputNumber();
			if(selectedUnitID>=0 && selectedUnitID<=unitCollection.size())
			{
				this.setActiveUnit(unitCollection.get(selectedUnitID));
				return;
			}
		}
	}
	
	private void selectUnitAction()
	{
		// Избор на бойно действие
		System.out.println("Изберете действие:");
		System.out.println("[A] - Атака");
		System.out.println("[M] - Движение");
		String command=Terminal.inputString();
		
		if(command.equals(COMMAND_ATTACK))
			this.executeAttack();
		
		if(command.equals(COMMAND_MOVE))
			this.executeMove();
	}
	
	private void executeAttack()
	{
		
	}
	
	private void executeMove()
	{
		int boardRowIndex=Terminal.inputNumber("Въведете ред");
		int boardColIndex=Terminal.inputNumber("Въведете колона");
		
		GameObject destinationObject=this.getGameObjectFromArena(boardRowIndex, boardColIndex);
		if(destinationObject.isPassable())
		{
			this.moveGameObjectOverTheArena(this.getActiveUnit(), destinationObject);
			return;
		}

		System.out.println("Движението не може да бъде извършено.");
	}
	
	private void playerUnitDialogue()
	{
		this.selectUnit();
		this.selectUnitAction();
	}
	
	private void positionGameObjectOverTheArena(GameObject unit)
	{
		int row=unit.getRow();
		int col=unit.getCol();
		this.arena[row][col]=unit;
	}
	
	private void moveGameObjectOverTheArena(Unit unit, GameObject destinationObject)
	{
		int currentRow=unit.getRow();
		int currentCol=unit.getCol();
		
		// Премахване на настоящата фигура от текущото пространство; заменяваме празното пространство с проходим терен
		this.positionGameObjectOverTheArena(new Terrain(currentRow, currentCol));
		
		// Позициониране на единицата върху дъската
		unit.move(destinationObject);
		this.positionGameObjectOverTheArena(unit);
	}
}
