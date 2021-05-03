package week4;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;
	
public class ImageProcessing extends GraphicsProgram {
	

	private static final String fileLocation = "milkmaid.jpg";

	public GImage flipHorizontal(GImage img) {
		int[][] array = img.getPixelArray();
		int width = array[0].length;
		int height = array.length;
		for (int row = 0; row < height; row++) {
		for (int p1 = 0; p1 < width / 2; p1++) {
		int p2 = width - p1 - 1;
		int temp = array[row][p1];
		array[row][p1] = array[row][p2];
		array[row][p2] = temp;
		}
		}
		return new GImage(array);
	}
	
	public BufferedImage readImage(String fileLocation) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("milkmaid.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
	

}
