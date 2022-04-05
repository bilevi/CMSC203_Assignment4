package Assignment4;

/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: A class to create a plot of 'land' for the program
 * Due: 4/04/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: B. Leigh Vining
 */

public class Plot {

	private int x, y;
	private int width, depth;

	public Plot() { //default constructor with basic values
		x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}

	public Plot(int x1, int y1, int w, int d) { //constructor with user given values
		x = x1;
		y = y1;
		width = w;
		depth = d;
	}

	public Plot(Plot p) { //copy constructor
		x = p.x;
		y = p.y;
		width = p.width;
		depth = p.depth;
	}


	public int getX() {
		return x;
	}
	public void setX(int x1) {
		x = x1;
	}

	public int getY() {
		return y;
	}
	public void setY(int y1) {
		y = y1;
	}

	public int getDepth() {
		return depth;
	}
	public void setDepth(int d) {
		depth = d;
	}

	public int getWidth() {
		return width;
	}
	public void setWidth(int w) {
		width = w;
	}
	
	
	public boolean overlaps(Plot p) {
		return ((this.x < (p.x + p.width)) && // if this x-coord start is lower than the line of plot's x/width line
				((this.x + this.width) > p.x) && // and this x/width line is greater than the plot's x-coord start
				(this.y < (p.y + p.depth)) && //also this y-coord start is less than the plot's y/depth line
				((this.y + this.depth) > p.y)); //and this y/depth line is greater than plot's y-coord start
												// then this object overlaps the plot's object
	}
	
	public boolean encompasses(Plot p) {
		return ((p.x >= this.x) && //if plot's x is greater/equal to this x
				(p.y >= this.y) && //and plot's y is greater/equal to this y
				((p.x + p.width) <= (this.x + this.width)) && //but the plot's x/width line is less/equal to this x/width line
				((p.y + p.depth) <= (this.y + this.depth))); //and plot's y/depth line is less/equal to this y/depth line
																//then this object encompasses plot's object
	}

	
	public String toString() {
		return ("Upper left: (" + x + "," + y + "); "
				+ "Width: " + width + 
				" Depth: " + depth);
	}
}
