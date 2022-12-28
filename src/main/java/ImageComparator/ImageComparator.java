package ImageComparator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import io.quarkus.logging.Log;

public class ImageComparator {

  public static  void compareImages(File img1, File img2) {
    try {
      // Load the two images
      BufferedImage image1 = ImageIO.read(img1);
      BufferedImage image2 = ImageIO.read(img2);
      // Convert the images to the same color model
      image1 = convertToARGB(image1);
      image2 = convertToARGB(image2);


      // Compare the images and highlight the differences
      highlightDifferences(image1, image2);

      // Save the modified image
    //   ImageIO.write(image1, "png", new File("image1_highlighted.png"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static BufferedImage convertToARGB(BufferedImage image) {
    BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = newImage.createGraphics();
    g.drawImage(image, 0, 0, null);
    g.dispose();
    return newImage;
  }


  private static void highlightDifferences(BufferedImage img1, BufferedImage img2) throws IOException {
    // Check that the images are the same size
   // Check that the images are the same size
   if (img1.getWidth() != img2.getWidth() || img1.getHeight() != img2.getHeight()) {
    System.out.println("The images are not the same size!");
    return;
  }

  int width = img1.getWidth();
    int height = img1.getHeight();

        // Create a new image that will store the difference
        BufferedImage diff = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Iterate over the pixels and compare the RGB values
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // Get the RGB values of the pixels at the current position
                int pixel1 = img1.getRGB(x, y);
                int pixel2 = img2.getRGB(x, y);

                // If the pixels are different, set the pixel in the diff image to red, otherwise set it to white
                if (pixel1 != pixel2) {
                    diff.setRGB(x, y, new Color(39, 46, 245, 3).getRGB());
                } else {
                    diff.setRGB(x, y, img1.getRGB(x, y));
                }
            }
        }
        // Save the diff image to a file
        ImageIO.write(diff, "png", new File("diff.png"));
  }
}
