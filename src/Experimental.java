import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Arrays;

public class Experimental {
	public Experimental() {
	}
	
	public static void main(String[] args) {
		String fileName = args[0];
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(fileName));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		int minX = img.getMinX();
		int minY = img.getMinY();
		System.out.println(minX);
		System.out.println(minY);
		int height = img.getHeight();
		int width = img.getWidth();
		System.out.println(height);
		System.out.println(width);
		Pixel[][] pixelArr = new Pixel[height][width];
		for(int i = minX; i<width; i++) {
			for(int j = minY; j<height; j++) {
				int rgb = img.getRGB(i,j); // always returns TYPE_INT_ARGB
				int alpha = (rgb >> 24) & 0xFF;
				int red =   (rgb >> 16) & 0xFF;
				int green = (rgb >>  8) & 0xFF;
				int blue =  (rgb      ) & 0xFF;
//				System.out.println(alpha + " " + red + " " + green + " " + blue);
				pixelArr[i][j] = new Pixel(red, green, blue);
			}
		}
//		System.out.println(Arrays.deepToString(pixelArr));
//		img.getRGB(startX, startY, w, h, rgbArray, offset, scansize)
		Image img2 = new Image("# CREATOR: GIMP PNM Filter Version 1.1", 255, pixelArr);
		img2.flip(true);
		try {
			// File cat = new File("/Users/jimprescott/Documents/flippedCatTube.jpg");
//			BufferedImage buffIm = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			/*for(int x = minX; x<width; x++) {
				for(int y = minY; y<height; y++) {
					buffIm.setRGB(x, y, img2.);
				}
			}*/
			ImageFileUtilities.writePnm(img2, "/Users/jimprescott/Documents/flippedCatTube.pnm");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
