package main;

/**
 * Represents a planet.
 */
public class Planet {
	private String name;
	private boolean shipPieceFound = false;
	private SpaceOutpost outpost = new SpaceOutpost();
	

	/**
	 * Creates a planet.
	 * @param name      A string name of the planet.
	 */
	public Planet(String name) {
		this.name = name;
	}
	
	/**
	 * Creates a string representation of the planet.
	 * @return A string representation of the planet.
	 */
	public String toString() {
		return name;
	}
	
	/**
	 * Gets the name of the planet.
	 * @return the name of the planet.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the planet.
	 * @param name  A string name of the planet.
	 */
	public void setName(String name) {
		this.name = name;
	}
	

	/**
	 * Checks if the transporter part for this planet has been found.
	 * @return true if the transporter part for this planet has been found, false otherwise.
	 */
	public boolean isShipPieceFound() {
		return shipPieceFound;
	}
	
	/**
	 * Sets if the transporter part has been found.
	 * @param transporterDiscovery   A boolean expression of whether the transporter part has been found.
	 */
	public void setShipPieceFound(boolean shipPieceFound) {
		this.shipPieceFound = shipPieceFound;
	}

	/**
	 * Gets the space outpost on this planet.
	 * @return the space outpost.
	 */
	public SpaceOutpost getOutpost() {
		return outpost;
	}
	
	/**
	 * Sets the space outpost on this planet.
	 * @param outpost   A SpaceOutpost object.
	 */
	public void setOutpost(SpaceOutpost outpost) {
		this.outpost = outpost;
	}
	
	
}
