import javax.annotation.processing.Filer;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.xml.transform.Source;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;

public class TextImage {

    //Method that change
    public static BufferedImage make(String...textrows)
    {
        //BufferedImage
        BufferedImage helperImg = new BufferedImage(20, 20, BufferedImage.TYPE_INT_RGB);
        //Lage bildet
        Graphics2D g2d = helperImg.createGraphics();
        //Skrift type, FONT
        Font font = new Font("Serif", Font.PLAIN, 20);
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
        int width = fm.stringWidth(longestText);
        int height = fm.getHeight()*textrows.length;
        g2d.dispose();


        BufferedImage finalImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        g2d = finalImg.createGraphics();
        g2d.setColor(Color.black);
        g2d.fillRect(10, 10, width, height);
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
        //Skrift farge
        g2d.setColor(Color.green);
        int y = fm.getAscent();
        for(String row: textrows)
        {
            g2d.drawString(row, 20, y);
            y += fm.getHeight();
        }
        g2d.dispose();
        return finalImg;

    }

    public static void main(String[] args) {
        try{
            BufferedImage bi = make("Kanta er best <3", "import 'fmt'", "func main(){", "fmt.Println('Hello World!')" , "}");
            File outputfile = new File("D:/Filer/Codes/IS213 Open Source/213OSB/spill_1", "testtest.png");
            ImageIO.write(bi, "png", outputfile);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
