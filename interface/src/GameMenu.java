import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameMenu {

    private JFrame frame;
    private JPanel launchEditPanel;
    private ArrayList<JButton> gameLaunchers;
    private ArrayList<JButton> gameEditors;

    private int width = 300;

    public GameMenu() {
        gameLaunchers = new ArrayList<>();
        gameEditors = new ArrayList<>();
        frame = new JFrame("Game Menu");
        frame.setMinimumSize(new Dimension(width, width/2));
        launchEditPanel = new JPanel();
        launchEditPanel.setLayout(new FlowLayout());

        JButton launchEditor1 = new JButton("Launch editor 1");
        launchEditor1.addActionListener(e -> openEditor("Editor 1"));
        gameEditors.add(launchEditor1);

        JButton launchEditor2 = new JButton("Launch editor 2");
        launchEditor2.addActionListener(e -> openEditor("Editor 2"));
        gameEditors.add(launchEditor2);

        launchEditPanel.add(launchEditor1);
        launchEditPanel.add(launchEditor2);

        frame.add(launchEditPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void openEditor(String title) {
        new GameEditor(title, frame);
    }

    public static void main(String[] args) {
        new GameMenu();
    }
}
