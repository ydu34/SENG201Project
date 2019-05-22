package main;
/**
 * Represents a HealthNut type crew member.
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class HealthNut extends CrewMember{
	
	public HealthNut(String name) {
		super(name, "Health Nut", "", 100, 100, 100, 2);
	}
	/**
	 * Creates a HealthNut type crew member.
	 * @param name   A string name of the crew member.
	 * @param image  A string image of the crew member.
	 */
	public HealthNut(String name, String image) {
		super(name, "Health Nut", image, 100, 100, 100, 2);
	}
	
	/**
	 * Applies medical items.
	 * @param item   A MedicalItem object.
	 * @param crew   A Crew object.
	 */
	public String useMedicalItem(MedicalItem item, Crew crew) {
		String returnString = "";
		returnString += super.useMedicalItem(item, crew);
		super.increaseHealth(10);
		returnString += "\n" + super.getName() +" recovers extra health from their trait Health Nut.";
		returnString += "\n" + super.getName() +" now has " + super.getHealth() + "/" + super.getMaxHealth() + " health.";
		return returnString;
	}

}
