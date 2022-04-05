package Assignment4;

/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: A class to create a property, with plots of land for the program
 * Due: 4/04/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: B. Leigh Vining
 */

public class Property {

	private String propertyName, city, owner;
	private double rentalAmount;
	private Plot plot;

	public Property() { //default contstructor
		propertyName = "";
		city = "";
		rentalAmount = 0.00;
		plot = new Plot();
	}

	public Property(String n, String c, double ra, String o,
			int x, int y, int w, int d) {	// user-input constructor with property input and plot input added
		propertyName = n;
		city = c;
		rentalAmount = ra;
		owner = o;
		plot = new Plot(x, y, w, d);
	}

	public Property(String n, String c, double ra, String o) { //user-input constructor with property input
		propertyName = n;
		city = c;
		rentalAmount = ra;
		owner = o;
	}


	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String n) {
		propertyName = n;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String c) {
		city = c;
	}

	public String getOwner() {
		return owner;
	}
	public void setOwner(String o) {
		owner = o;
	}

	public double getRentalAmount() {
		return rentalAmount;
	}
	public void setRentalAmount(double ra) {
		rentalAmount = ra;
	}

	public Plot getPlot() {
		return plot;
	}
	public void setPlot(int x, int y, int w, int d) { //setting plot with user input
		plot = new Plot(x, y, w, d);
	}


	public String toString() {

		return ("Property Name: " + propertyName +
				"\nLocated in " + city +
				"\nBelonging to: " + owner +
				"\nRent Amount: " + rentalAmount +
				"\n");
	}

}