import java.io.*;

public class converter {

    public static void main(String[] args) throws IOException {
        System.out.print("Provide the directory of an image you want to convert into ascii: ");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
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

        File grayImage = grayscale.convertToGrayscale(file);
        String asciiText = ascii.convertToAscii(grayImage);

        printAsciiText(asciiText);
    }

    static void printAsciiText(String asciiText) throws IOException {
        File output = new File("asciitext/output.txt");
        FileWriter fw = new FileWriter(output);
        fw.write(asciiText);
        fw.close();
        System.out.println("Successfully printed the ascii text into '~/asciitext/output.txt'");
    }

}
