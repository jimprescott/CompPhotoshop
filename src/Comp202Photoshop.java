import java.io.*;
// This class reads and image and will modify it according to what the user specifies via input arguments
public class Comp202Photoshop {
	
	public static void main(String[] args) {
		// If the user enters less than 4 arguments, it will throw an exception
		if(args.length<4) {
			System.out.println("This class requires 4 or more input arguments.");
			throw new IllegalArgumentException("More input arguments are required.");
		}
		
		String inputName = args[0];
		String outputName = args[1];
		String outFormat = args[2];
		String operation = args[3];
		
		// If the user doesn't enter a valid output format it will throw an exception
		if(!outFormat.equals("pnm") && !outFormat.equals("pgm")) {
			System.out.println("The output format is not valid");
			throw new IllegalArgumentException("Invalid format.");
		}
		
		// If the user does not enter one of the valid operations, it will throw an exception
		if(!operation.equals("-fh") && !operation.equals("-fv") && !operation.equals("-gs") && !operation.equals("-cr")) {
			System.out.println("The operation that was requested is not available ");
			throw new IllegalArgumentException("Invalid operation");
		}
		
		try { 
			// -fh represents a horizontal flip
			if(operation.equals("-fh")) {
			
				Image im = ImageFileUtilities.read(inputName);
				im.flip(true);
				if(outFormat.equals("pgm")) {
					ImageFileUtilities.writePgm(im, outputName);
				}	
				else if(outFormat.equals("pnm")) {
					ImageFileUtilities.writePnm(im, outputName);
				}
			}
			// -fv represents a vertical flip
			else if(operation.equals("-fv")) {
				Image im = ImageFileUtilities.read(inputName);
				im.flip(false);
				if(outFormat.equals("pgm")) {
					ImageFileUtilities.writePgm(im, outputName);
				}
				if(outFormat.equals("pnm")) {
					ImageFileUtilities.writePnm(im, outputName);
				}
			}
			// -gs represents a greyscale conversion
			else if(operation.equals("-gs")) {
				Image im = ImageFileUtilities.read(inputName);
				im.toGrey();
				if(outFormat.equals("pgm")) {
					ImageFileUtilities.writePgm(im, outputName);
				}
				if(outFormat.equals("pnm")) {
					ImageFileUtilities.writePnm(im, outputName);
				}
			}
			// -cr represents a cropping operation
			else if(operation.equals("-cr")) {
				// 8 arguments are required for cropping, throws and exception if this requirement isn't fulfilled
				if(args.length<8) {
					System.out.println("Not enough arguments were entered for a crop operation ");
					throw new IllegalArgumentException("More arguments are required for the cropping parameters");
				}
				
				int startX, startY, endX, endY;
			
				startX = Integer.parseInt(args[4]);
				startY = Integer.parseInt(args[5]);
				endX = Integer.parseInt(args[6]);
				endY = Integer.parseInt(args[7]);
				Image im = ImageFileUtilities.read(inputName);
				try {
					im.crop(startX, startY, endX, endY);
				}
				// Catches the exception that crop throws if invalid cropping parameters are entered
				catch(IllegalArgumentException e) {
					System.out.println("The parameters for cropping are not valid");
				}
				finally {
					if(outFormat.equals("pgm")) {
						ImageFileUtilities.writePgm(im, outputName);
					}
					if(outFormat.equals("pnm")) {
						ImageFileUtilities.writePnm(im, outputName);
					}
				}
			}
		}
		// Catches any of the IOExceptions that the previous code might have thrown and prints a message and a stack trace
		catch(IOException e) {
			System.out.println("There has been an IOException.");
			System.out.println("It caused an error in the following classes: ");
			e.printStackTrace();
		}
	}
}
