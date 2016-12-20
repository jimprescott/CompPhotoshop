// This class is for objects of type Pixel
public class Pixel {
	private int red;
	private int blue;
	private int green;
	
	// Overloaded constructor that takes separate intensity values for red, blue, and green attributes of the Pixel
	public Pixel(int red, int green, int blue) {
		if(red<0 || red>255) {
			throw new IllegalArgumentException("The red intensity is out of the 0-255 range.");
		}
		if(green<0 || green>255) {
			throw new IllegalArgumentException("The green intensity is out of the 0-255 range.");
		}
		if(blue<0 || blue>255) {
			throw new IllegalArgumentException("The blue intensity is out of the 0-255 range.");
		}
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	// Overloaded constructor that takes intensity that it assigns to each red, blue, and green attributes of a Pixel 
	public Pixel(int intensity) {
		if(intensity<0 || intensity>255) {
			throw new IllegalArgumentException("The intensity is out of the 0-255 range.");
		}
		this.red = intensity;
		this.green = intensity;
		this.blue = intensity;
	}
	
	// Returns the red attribute of the Pixel it is called upon
	public int getRed() {
		return this.red;
	}
	
	// Returns the green attribute of the Pixel it is called upon
	public int getGreen() {
		return this.green;
	}
	
	// Returns the blue attribute of the Pixel it is called upon
	public int getBlue() {
		return this.blue;
	}
	
	// Returns and integer that represents the average of the red, green, and blue attributes of the Pixel it is called upon
	public int grey() {
		int average = (this.red + this.green + this.blue)/3;
		return average;
	}
}
