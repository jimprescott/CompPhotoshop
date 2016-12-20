import java.io.IOException;
import java.util.Random;
public class ImageGenerator {
	
	
	  // Note: Change the number 1 below to any other number for different results. e.g. new Random(2);
	  private static Random r = new Random(1);


	  public static void main(String[] args) {
	 // Change the below 2 numbers to generate random images of different sizes
	 int height = 10;
	 int width = 10;
	 // Change the below to specify whether you want to generate a black and white or colour picture
	 boolean colourImage = true;
	 Image random = generateRandomImage(height,width, colourImage);
	 printImage(random);
	 System.out.println(" ");
	// random.flip(true);
	   
	 //printImage(random);
	 // add other methods here for testing:
	 // e.g.
	 // random.toGrey();
	 // printImage(random);
	 // This way you can ensure your code for question 2 is well tested before moving on.
	/* try {
		 Image butt = ImageFileUtilities.read("/Users/jimprescott/Documents/catskype.pnm");
		 printImage(butt);
		 ImageFileUtilities.writePnm(butt, "/Users/jimprescott/Documents/catskype.pnm");
		 System.out.println(" ");
		 System.out.println(butt);
		 System.out.println(butt.getMetaData());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
	 
	  }
	  
	  
	  
	  public static void printImage(Image image) {
	    System.out.println("Height: " +  image.getHeight());
	    System.out.println("Width: " + image.getWidth());
	    System.out.println("Red data:");
	    for (int i = 0; i < image.getHeight(); i++) {
	      for (int j = 0; j < image.getWidth(); j++) {
	       System.out.print(image.getPixel(i,j).getRed() + " " ); 
	      }
	      System.out.println();
	    }
	    
	    System.out.println("\n\nGreen data");
	    for (int i = 0; i < image.getHeight(); i++) {
	      for (int j = 0; j < image.getWidth(); j++) {
	       System.out.print(image.getPixel(i,j).getGreen() + " " ); 
	      }
	      System.out.println();
	    }
	    
	    System.out.println("\n\nBlue data");
	    for (int i = 0; i < image.getHeight(); i++) {
	      for (int j = 0; j < image.getWidth(); j++) {
	       System.out.print(image.getPixel(i,j).getBlue() + " " ); 
	      }
	      System.out.println();
	    }    
	  }
	  
	  public static Image generateRandomImage(int height, int width, boolean isColour) {
	    Pixel[][] numbers = new Pixel[height][width];
	    for (int i = 0; i < height; i++) {
	      for (int j = 0; j < width; j++) {
	        if (isColour) {
	         numbers[i][j] = randomColourPixel(); 
	        }
	        else {
	          numbers[i][j] = randomBwPixel();
	        }
	      }
	    }
	    
	   return new Image("#Sample test image", 255, numbers); 
	  }
	  
	  public static Pixel randomColourPixel() {
	    int red = r.nextInt(256);
	    int green = r.nextInt(256);
	    int blue = r.nextInt(256);
	    return new Pixel(red, green, blue);
	  }
	  
	  public static Pixel randomBwPixel() {
	   int intensity = r.nextInt(256);
	   return new Pixel(intensity, intensity, intensity);
	  }
	}

