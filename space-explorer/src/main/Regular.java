package main;
/**
 * Represents a Regular type crew member.
 * @author Yu Duan
 * @author Joyce Cheah
 */
public class Regular extends CrewMember{
	
	public Regular(String name) {
		super(name, "Regular", "", 100, 130, 130, 2);
	}
	/**
	 * Creates a Regular type crew member.
	 * @param name   A string name of the crew member.
	 * @param image  A string image of the crew member.
	 */
	public Regular(String name, String image) {
		super(name, "Regular", image, 100, 130, 130, 2);
	}
	
}
