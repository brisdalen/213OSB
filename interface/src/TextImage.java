import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.awt.Color.*;

public class TextImage {

    //Method that create bufferedImage
    public static BufferedImage make(Color bgColor, Color tColor, int tSize, ArrayList<String> textrows)
    {
        //BufferedImage helper.
        BufferedImage helperImg = new BufferedImage(20, 20, BufferedImage.TYPE_INT_RGB);
        //Create the image with G2D
        Graphics2D g2d = helperImg.createGraphics();
        //TextType, FONT //PLAIN, BOLD, ITALIC
        Font font = new Font("Serif", Font.ITALIC, tSize);
        g2d.setFont(font);
        FontMetrics fm = g2d.getFontMetrics();
        String longestText = "";
        for(String row: textrows)
        {
            if(row.length()>longestText.length())
            {
                longestText = row+100;
            }
        }

        g2d.dispose();

        //Image size
        int width = 500;
        int height = 500;

        //Final image, the image we are going to see.
        BufferedImage finalImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        g2d = finalImg.createGraphics();
        //Background color.
        g2d.setColor(bgColor);
        //Rectangle fill.
        g2d.fillRect(0, 0, width, height);

        //Rendering and image quality.
        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g2d.setFont(font);
        fm = g2d.getFontMetrics();

        //Text Color.
        g2d.setColor(tColor);
        int y = fm.getAscent();
        for(String row: textrows)
        {
            g2d.drawString(row, 25, y);  //Width in front of the text
            y += fm.getHeight();
        }
        g2d.dispose();
        return finalImg;

    }

    //Create file, if a file has same name the number++
    //Method Create file need: bgcolor, text color, and text size
    public static void createFile(File file) throws IOException {
        try {
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();
            line = line.substring(1, line.length()-1);
            int backgroundColCode = Integer.parseInt(line);
            Color backgroundColor = new Color(backgroundColCode);

            line = scanner.nextLine();
            line = line.substring(1, line.length()-1);
            int foregroundColCode = Integer.parseInt(line);
            Color foregroundColor = new Color(foregroundColCode);

            line = scanner.nextLine();
            line = line.substring(1, line.length()-1);
            int textSize = Integer.parseInt(line);

            //Read file from path and split it by \n and after certain amount of characters
            String[] data = readFile(file.getAbsolutePath());

            ArrayList <String> temp = new ArrayList<>();

            for(String s : data){
                String[] data2 = splitByNumber(s);
                for(String s2 : data2){
                    temp.add(s2);
                }
            }

        //Text for the file
        BufferedImage bi = make(backgroundColor, foregroundColor, textSize, temp);
        File newFile;
        int index = 1;
        //File path for image output
        String parent = "../spill_1/ImageOutput";
       //File name ( image name)
        String name = "File";
        //File type (image type)
        String extension = ".png";
            //Loop that add file + number if the file has same name
            while ((newFile = new File(parent, name + index + extension)).exists()) {
            index++;
            }
            ImageIO.write(bi, "png", newFile);



        } catch (Exception e){
            e.printStackTrace();
        }
        
    }

    //ReadFrom textFile and use the data as a String[] for creating picture
    public static String[] readFile(String filepath)throws Exception {
        String data = new String(Files.readAllBytes(Paths.get(filepath)));
        // Remove the 3 first lines containing background color, foreground color and font size
        for(int i = 0; i < 3; i++) {
            data = data.substring(data.indexOf("]")+1);
        }
        data = data.trim();
        //Spilt string and add lineshift
        String[] dataSplit = data.split("\n");
        System.out.println(Arrays.toString(dataSplit));
        return dataSplit;
    }

    //Split string after certain numbers.
    public static String[] splitByNumber(String test) throws IOException {
        int size = 45;
        String[] numSplit = (size < 1 || test == null) ? null : test.split("(?<=\\G.{" + size + "})");
        System.out.println(Arrays.toString(numSplit));

        return numSplit;

    }

    //Resize and scaling method.
    public static BufferedImage resize(String inputImagePath, String outputImagePath, int scaledWidth, int scaledHeight, File newFile) throws IOException{
        //read input image
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(newFile);

        //create output image
        BufferedImage outputImage = new BufferedImage(scaledWidth, scaledHeight, inputImage.getType());

        // scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();

        //extract extension of output file
        String formatName = outputImagePath.substring(outputImagePath.lastIndexOf(".")+1);

        // writes to output file
        ImageIO.write(outputImage, formatName, new File(outputImagePath));
        
        return outputImage;
    }
}
