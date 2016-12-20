// This a class for objects of type Image
public class Image {
	private String metaData;
	private int maxRange;
	private Pixel[][] data;
	
	// Constructor takes the String metaData (the info at the top of an image file), int maxRange (the max intensity value of the image), and a Pixel array (represents the pixels of the image)
	public Image(String metaData, int maxRange, Pixel[][] pixelArr) {
		if(maxRange<0) {
			throw new IllegalArgumentException("maxRange is negative.");
		}
		this.metaData = metaData;
		this.maxRange = maxRange;
		this.data = new Pixel[pixelArr.length][pixelArr[0].length];
		for(int i = 0; i<this.data.length; i++) {
			for(int j = 0; j<this.data[i].length; j++) {
				this.data[i][j] = pixelArr[i][j];
			}
		}
	}
	
	// Returns the metaData (String) attribute of the Image it is called upon
	public String getMetaData() {
		return this.metaData;
	}
	
	// Returns the maxRange (int) attribute of the Image it is called upon
	public int getmaxRange() {
		return this.maxRange;
	}
	
	// Returns the width (int) of the Pixel array attribute of the Image it is called upon
	public int getWidth() {
		return this.data[0].length;
	}
	
	// Returns the height (int) of the Pixel array attribute of the Image it is called upon
	public int getHeight() {
		return this.data.length;
	}
	
	// Returns the Pixel at the (i,j) coordinate of the Image it is called upon
	public Pixel getPixel(int i, int j) {
		return this.data[i][j];
	}
	
	// Takes boolean horizontal as input and will flip the image across the y-axis if true, and across the x-axis if false
	public void flip(boolean horizontal) {
		
		if(horizontal) {
			Pixel[][] dataCopy = new Pixel[getHeight()][getWidth()];
			// Fills the copy array with the flipped values
			for(int i = 0; i<getHeight(); i++) {
				for(int j = 0; j<getWidth(); j++) {
					dataCopy[i][j] = this.data[i][getWidth()-1-j];
				}
			}
			this.data = dataCopy;
		}
		
		else {
			Pixel[][] dataCopy = new Pixel[getHeight()][getWidth()];
			// Fills the copy array with the flipped values
			for(int i = 0; i<getHeight(); i++) {
				for(int j = 0; j<getWidth(); j++) {
					dataCopy[i][j] = this.data[getHeight()-1-i][j];
				}
			}
			// Sets the attribute equal to the flipped copy array
			this.data = dataCopy;
		}
				
					
	}
	
	// Turns the Image it is called upon into a greyscale image by calling the grey() method from the Pixel class
	public void toGrey() {
		Pixel[][] dataCopy = new Pixel[this.data.length][this.data[0].length];
		// Fills the copy array with Pixels with the same intensities for each color attribute
		for(int i = 0; i<getHeight(); i++) {
			for(int j = 0; j<getWidth(); j++) {
				dataCopy[i][j] = new Pixel(this.data[i][j].grey());
			}
		}
		// Sets the Pixel attribute to the grey copy array
		this.data = dataCopy;
	}
	
	// Takes 4 int values as input and will crop the Image according to the input
	public void crop(int startX, int startY, int endX, int endY) {
		// Throws exception if the starting and ending points are not valid
		if(endX >= this.data[0].length || endY >=  this.data.length || startX>endX || startY>endY) {
			throw new IllegalArgumentException("The end values are outside of the image");
		}
		Pixel[][] dataCopy = new Pixel[endY - startY][endX - startX];
		// Fills the copy array with the Pixels from the desired part of the original Image
		for(int i = 0; i<dataCopy.length; i++) {
			for(int j = 0; j<dataCopy[i].length; j++) {
				dataCopy[i][j] = this.data[startY + i][startX + j];
			}
		}
		// Sets the Pixel attribute to the cropped version of the image
		this.data = dataCopy;
	}
}










