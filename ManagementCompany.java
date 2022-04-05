package Assignment4;

/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: A class to create a management company for the program, that includes the properties of plots of land
 * Due: 4/04/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: B. Leigh Vining
 */

public class ManagementCompany {

	private String name, taxID;
	private double mgmtFee;
	private final int MAX_PROPERTY = 5;
	private Property[] properties = new Property[MAX_PROPERTY];
	private final int MGMT_WIDTH = 10, MGMT_DEPTH = 10;
	private Plot plot;

	public ManagementCompany() { //default constructor
		name = "";
		taxID = "";
		mgmtFee = 0.00;
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
	}

	public ManagementCompany(String n, String id, double fee) { //constructor with company input
		name = n;
		taxID = id;
		mgmtFee = fee;
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH); //creating a plot
		properties = new Property[MAX_PROPERTY]; //creating property spots for the mgmt company
	}

	public ManagementCompany(String n, String id, double fee, //constructor with company input and plot input included
			int x, int y, int width, int depth) {
		name = n;
		taxID = id;
		mgmtFee = fee;
		plot = new Plot(x, y, width, depth); //creating a plot
		properties = new Property[MAX_PROPERTY]; //creating property spots for mgmt company
	}

	public ManagementCompany(ManagementCompany company) { //copy constructor
		name = company.name;
		taxID = company.taxID;
		mgmtFee = company.mgmtFee;
		plot = company.plot;
		properties = company.properties;
	}


	public String getName() {
		return name;
	}
	public void setName(String n) {
		name = n;
	}

	public String getTaxID() {
		return taxID;
	}
	public void setTaxID(String id) {
		taxID = id;
	}

	public double getMgmtFee() {
		return mgmtFee;
	}
	public void setMgmtFee(double fee) {
		mgmtFee = fee;
	}

	public Plot getPlot() {
		return plot;
	}
	public void setPlot(int x, int y, int w, int d) { //set plot with user input
		plot = new Plot(x, y, w, d);
	}

	public int getMAX_PROPERTY() { //can't set max property as it is a given constant
		return this.MAX_PROPERTY;
	}


	public int addProperty(Property property) { //add property with given property object

		if (property == null) //if the property is empty
		{
			return -2;
		}

		if (!(plot.encompasses(property.getPlot()))) //if the plot does not encompass the property plot
		{												//if the property is out of bounds
			return -3;
		}

		for (int i = 0; i < MAX_PROPERTY; i++) //going through the properties
		{	
			if (properties[i] != null) //if the property is not empty
			{
				if ((properties[i].getPlot()).overlaps(property.getPlot())) //and the property overlaps the given property
				{
					return -4;
				}
			}

			else //otherwise, add it to the array
			{
				properties[i] = property;
				return i; //and return the spot in array
			}
		}
		return -1; //However, if the array is full
		//** can't use if length = max, because array is set to max initially **
	}

	public int addProperty(String name, String city,
			double rent, String owner) {
		Property property = new Property(name, city, rent, owner); //create a property with the given inputs (no plot input)

		//Same comments as first addProperty()
		if (property.equals(null))
		{
			return -2;
		}

		else if (!(plot.encompasses(property.getPlot())))
		{
			return -3;
		}

		for (int i = 0; i < MAX_PROPERTY; i++)
		{	
			if ((properties[i].getPlot()).overlaps(property.getPlot()))
			{
				return -4;
			}

			else if (properties[i].equals(null))
			{
				properties[i] = property;
				return i;
			}
		}
		return -1;
	}

	public int addProperty(String name, String city, double rent, String owner, 
			int x, int y, int width, int depth) {
		Property property = new Property(name, city, rent, owner, x, y, width, depth); //create a property with the given inputs (inlcuding plot input)

		//Same comments as first addProperty()
		if (property.equals(null))
		{
			return -2;
		}

		else if (!(plot.encompasses(property.getPlot())))
		{
			return -3;
		}

		for (int i = 0; i < MAX_PROPERTY; i++)
		{	
			if ((properties[i].getPlot()).overlaps(property.getPlot()))
			{
				return -4;
			}

			else if (properties[i].equals(null))
			{
				properties[i] = property;
				return i;
			}
		}
		return -1; 
	}


	public double totalRent() { //get the total rent for all properties
		double total = 0;

		for (int i = 0; i < properties.length; i++) //going through the array
		{
			if (properties[i] == null) //if the property does not exist
			{
				continue; //continue to next spot
			}
			Property house = properties[i]; //create object for spot in array
			total+= house.getRentalAmount(); //get rental amount to add to total
		}
		return total; //return the total amount
	}


	private int maxRentPropertyIndex() { //get the index in array of max rent amount
		int maxIndex = 0;
		double maxRent = 0.0;

		for (int i = 0; i < MAX_PROPERTY; i++) //going through the array
		{
			if (properties[i] != null) //if its not empty
			{
				if (properties[i].getRentalAmount() > maxRent) //and if the rental amount is greater than the maxRent already
				{
					maxRent = properties[i].getRentalAmount(); //you have a new maxRent!
					maxIndex = i; //and saving the index spot
				}
			}
		}
		return maxIndex; //to return the index spot
	}


	public double maxRentProp() { //to get the rental amount from the max rental index

		return properties[maxRentPropertyIndex()].getRentalAmount(); //call forth the max index method for the properties and get the rental amount
	}


	public String toString() {

		String prop = "";
		for (int i = 0; i < this.properties.length; i++) //going throug the array
		{
			if (properties[i] == null) //of the property is empty
			{ 
				continue; //continue to next index
			}
			
			prop += "\n" + this.properties[i].toString(); //get the property toString for the each array spot all in one string
		}

		return ("\nList of the properties for " + this.getName() + ", taxID: " + this.getTaxID() + "\n"
				+ "\n______________________________________________________"
				+ prop //to make it easier to return the this toString
				+ "\n______________________________________________________"
				+ "\nTotal Management Fee: " + (this.totalRent() * this.mgmtFee * 0.01)); //get the total rent times the mgmtFee
	}																						//times .01 to bring to a normal amount

}