package imagetoascii;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ascii {

    private static final char[] asciiMap = " .,:;ox%#@".toCharArray();

    private static int calculateIntesity(int r, int g, int b) {
        int len = asciiMap.length;

        double rr = (255-r)*len/256.0;
        double gg = (255-g)*len/256.0;
        double bb = (255-b)*len/256.0;

        int avg = (int)((rr+gg+bb)/3);
        return avg;
    }

    public static String convertToAscii(File file, int size) throws IOException {
        StringBuilder text = new StringBuilder();

        BufferedImage img = ImageIO.read(file);

        int width = img.getWidth();
        int height = img.getHeight();

        if(size > width) size = width;
        int xratio = size;
        int yratio = (int)((height*xratio/width) / 1.8);
        int xconstant = width/xratio;
        int yconstant = height/yratio;

        for(int y=0; y<height; y+=yconstant) {
            for(int x=0; x<width; x+=xconstant) {
                int rgb = img.getRGB(x, y);
                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = (rgb & 0xFF);

                int intensity = calculateIntesity(r, g, b);

                char asciiText = asciiMap[intensity];
                text.append(asciiText);
            }
            text.append("\n");
        }

        return text.toString();
    }

}
