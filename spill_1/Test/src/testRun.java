import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.File;
import javax.imageio.ImageIO;

class ImageWriteEx extends JPanel{

    public void paint(Graphics g){

        Image img = createImageWithText();
        g.drawImage(img, 30, 30, this);

    }

    private static BufferedImage createImageWithText(){

        BufferedImage bufferedImage = new BufferedImage(300, 300, BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.getGraphics();

        g.drawString("package main", 30, 30);
        g.drawString("import 'fmt'", 30, 60);
        g.drawString("func main(){", 30, 90);
        g.drawString("fmt.Println('Hello world')", 30, 120);
        g.drawString("}", 30, 150);

        return bufferedImage;

    }

    public static void main(String[] args){

        try{
            BufferedImage bi = createImageWithText();
            File outputfile = new File("save.png");
            ImageIO.write(bi, "png", outputfile);
        } catch(Exception e){
            e.printStackTrace();
        }

        JFrame frame = new JFrame();
        frame.getContentPane().add(new ImageWriteEx());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);

    }

}
