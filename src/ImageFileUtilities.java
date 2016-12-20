import java.io.*;
import java.util.Scanner;
// This class reads and writes image files
public class ImageFileUtilities {
	
	// Takes String fileName as input and will read the image file with that name, throws IoException if present
	public static Image read(String fileName) throws IOException {
		Scanner in = new Scanner(new File(fileName));
		String header = in.nextLine();
		String metaData = "";
		if(in.hasNext("#")) {
			metaData = metaData + in.nextLine();
		}
		int width = in.nextInt();
		int height = in.nextInt();
		int maxRange = in.nextInt();
		Pixel[][] data = new Pixel[height][width];
		
		// P2 signifies a greyscale image
		if(header.equals("P2")) {
			int[][] values = new int[height][width];
			for(int i = 0; i<values.length; i++) {
				for(int j = 0; j<values[i].length; j++) {
					values[i][j] = in.nextInt();
					data[i][j] = new Pixel(values[i][j]);
				}
			}
		}
		
		// P3 signifies a color image
		if(header.equals("P3")) {
			int red = 0;
			int green = 0;
			int blue = 0;
			for(int i = 0; i<data.length; i++) {
				for(int j = 0; j<data[i].length; j++) {
					red = in.nextInt();
					green = in.nextInt();
					blue = in.nextInt();
					data[i][j] = new Pixel(red, green, blue);
				}
			}
		}
		// Closes the Scanner
		in.close();
		// Creates a new Image with the same metaData, maxRange, and data attributes of the image file
		Image newImage = new Image(metaData, maxRange, data);
		return newImage;
	}
	
	// Writes and image of format .pnm (color), throws and IOException if present
	public static void writePnm(Image pnmImage, String fileName) throws IOException {
		FileWriter fw = new FileWriter(fileName);
		BufferedWriter bw = new BufferedWriter(fw);
		
		String metaData = pnmImage.getMetaData();
		int height = pnmImage.getHeight();
		int width = pnmImage.getWidth();
		int maxRange = pnmImage.getmaxRange();
		// Writes the Image piece by piece
		bw.write("P3 \n");
		bw.write(metaData + "\n");
		bw.write(width + " " + height + "\n");
		bw.write(maxRange + "\n");
		
		// Writes Pixels with the desired rgb values 
		for(int i = 0; i<height; i++) {
			for(int j = 0; j<width; j++) {
				bw.write(pnmImage.getPixel(i, j).getRed() + " ");
				bw.write(pnmImage.getPixel(i, j).getGreen() + " ");
				bw.write(pnmImage.getPixel(i, j).getBlue() + " ");
			}
			bw.write("/n");
		}
		// Closes the buffered writer and the file writer
		bw.close();
		fw.close();		
	}
	
	// Writes and image of format .pgm (greyscale), throws IOException if present
	public static void writePgm(Image pgmImage, String fileName) throws IOException {
		FileWriter fw = new FileWriter(fileName);
		BufferedWriter bw = new BufferedWriter(fw);
		
		String metaData = pgmImage.getMetaData();
		int height = pgmImage.getHeight();
		int width = pgmImage.getWidth();
		int maxRange = pgmImage.getmaxRange();
		// Writes the image file piece by piece
		bw.write("P2\n");
		bw.write(metaData + "\n");
		bw.write(width + " " + height + "\n");
		bw.write(maxRange + "\n");
		
		// Writes the Pixel with the desired grey values
		for(int i = 0; i<height; i++) {
			for(int j = 0; j<width; j++) {
				bw.write(pgmImage.getPixel(i, j).grey() + " ");
			}
		}
		// Closes the buffered writer and the file writer
		bw.close();
		fw.close();
	}

}
	
	
	
	
	
	
	
