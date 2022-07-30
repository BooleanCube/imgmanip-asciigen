package imagetoascii;

import java.io.*;

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

        System.out.print("What is the desired size of the resulting imagetoascii.ascii text (character width of imagetoascii.ascii text): ");
        int size = Integer.parseInt(bf.readLine());

        File grayImage = grayscale.convertToGrayscale(file);
        String asciiText = ascii.convertToAscii(grayImage, size);

        printAsciiText(asciiText);
    }

    static void printAsciiText(String asciiText) throws IOException {
        File output = new File("asciitext/output.txt");
        FileWriter fw = new FileWriter(output);
        fw.write(asciiText);
        fw.close();
        System.out.println("Successfully printed the imagetoascii.ascii text into '~/asciitext/output.txt'");
    }

}
