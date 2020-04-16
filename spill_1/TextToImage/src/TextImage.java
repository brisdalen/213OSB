import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import static java.awt.Color.*;

public class TextImage {


    //Method that create bufferedImage
    public static BufferedImage make(Color bgColor, Color tColor, int tSize, String...textrows)
    {
        //BufferedImage
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
        //Width behind the text
        int width = fm.stringWidth(longestText + 10);
        int height = fm.getHeight()*textrows.length;
        g2d.dispose();


        BufferedImage finalImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        g2d = finalImg.createGraphics();
        //Bakgrunn farge
        g2d.setColor(bgColor);
        //Yrtre kantene på venstre og toppen
        g2d.fillRect(1, 1, width, height);
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



        //Text Color
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
    public static void createFile(Color bg, Color txt, int tSize) throws IOException {
        try {
            String[] data = readFile("../TextInput/Test1.txt");
            System.out.println(Arrays.toString(data));
        //Text for the file
        BufferedImage bi = make(bg, txt, tSize,data);
        File newFile;
        int index = 1;
        //File path
        String parent = "../ImageOutput";
       //File name
        String name = "File";
        //File type
        String extension = ".png";
            //Loop that add file + number if the file has same name
            while ((newFile = new File(parent, name + index + extension)).exists()) {
            index++;
            }
            ImageIO.write(bi, "png", newFile);
            //Not used yet, need more testing
           // resize("../ImageOutput/" + newFile,"../ImageOutput/fix.png",1280,720, newFile);


        } catch (Exception e){
            e.printStackTrace();
        }
        
    }

    //ReadFrom textFile and use the data as a String[] for creating picture
    public static String[] readFile(String fileName)throws Exception {
        String data = new String(Files.readAllBytes(Paths.get(fileName)));
        //Spilt string and add lineshift
        String[] dataSplit = data.split("\n");
        return dataSplit;
    }

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



    public static void main(String[] args) throws Exception {
        createFile(blue, green, 23);
    }




}
