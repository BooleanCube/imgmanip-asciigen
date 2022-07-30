package imagetograyscale;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class converter {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Provide the directory of an image you want to convert into imagetoascii.ascii: ");
        String dir = bf.readLine();
        File file = new File(dir);
        if(!file.exists()) {
            System.out.println("This file does not exist!");
            return;
        }
        if(!dir.endsWith("png") && !dir.endsWith("jpg") && !dir.endsWith("jpeg")) {
            System.out.print("This file format is not supported! Please try again with a PNG, JPG, or JPEG file!");
            return;
        }

        grayscale.convertToGrayscale(file);

        System.out.println("Successfully converted the image into a grayscale image. The image can be found in 'grayscale/out.png'");
    }

}
