package main;
/**
 * Represents a Nibbler type crew member.
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class Nibbler extends CrewMember{
	
	public Nibbler(String name) {
		super(name, "Nibbler", "", 100, 100, 100, 2,
				10,10,10,10,20,20);
	}
	/**
	 * Creates a Nibbler type crew member.
	 * @param name   A string name of the crew member.
	 */
	public Nibbler(String name, String image) {
		super(name, "Nibbler", image, 100, 100, 100, 2,
				10,10,10,10,20,20);
	}
	
	/**
	 * Consumes a food item.
	 * @param item   A FoodItem object.
	 * @param crew   A Crew object.
	 * @return A string message of the crew member's updated hunger level.
	 */
	public String eat(FoodItem item, Crew crew) {
		String returnString = "";
		returnString += super.eat(item, crew);
		super.setHunger(super.getHunger()-10);
		returnString += "\n" + super.getName() +" is less hungry from their trait Nibbler.";
		returnString += "\n" + super.getName() +" now has " + super.getHunger() + "/" + super.getMaxHunger() + " hunger.";
		return returnString;
	}
	
}
