import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GameMenu {

    private JFrame frame;
    private JPanel containerPanel;
    private JPanel launchEditPanel;
    private JPanel launchGamePanel;
    private ArrayList<JButton> gameLaunchers;
    private ArrayList<JButton> gameEditors;

    private int width = 300;

    public GameMenu() {
        init();
    }

    private void init() {
        gameLaunchers = new ArrayList<>();
        gameEditors = new ArrayList<>();
        containerPanel = new JPanel();
        containerPanel.setLayout(new BorderLayout());
        frame = new JFrame("Game Menu");
        frame.setMinimumSize(new Dimension(width, width/2));

        launchGamePanel = new JPanel();
        launchGamePanel.setLayout(new FlowLayout());

        launchEditPanel = new JPanel();
        launchEditPanel.setLayout(new FlowLayout());

        JButton launchGame1 = new JButton("Launch game 1");
        //TODO: Finne path til fil, og prøve å tracke endringer om filen flyttes
        launchGame1.addActionListener(e -> launchGame("/Users/bjornar.risdalen/github/prosjekter/interface/test/runTest.app"));
        System.out.println(findGamePath());
        gameLaunchers.add(launchGame1);

        launchGamePanel.add(launchGame1);

        JButton launchEditor1 = new JButton("Launch editor 1");
        launchEditor1.addActionListener(e -> openEditor("Editor 1"));
        gameEditors.add(launchEditor1);

        JButton launchEditor2 = new JButton("Launch editor 2");
        launchEditor2.addActionListener(e -> openEditor("Editor 2"));
        gameEditors.add(launchEditor2);

        launchEditPanel.add(launchEditor1);
        launchEditPanel.add(launchEditor2);

        containerPanel.add(launchGamePanel, BorderLayout.CENTER);
        containerPanel.add(launchEditPanel, BorderLayout.SOUTH);

        frame.add(containerPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private String findGamePath() {
        // Burde pathen lagres til en config fil for hver gang, eller når den gamel pathen ikke matcher en ny en?
        // Evt. Når pathen ikke matcher, bruk JFileChooser og be brukeren navigere til riktig mappe
        //TODO: Implement path finding of applications
        String path;

        path = new File("").getAbsolutePath();

        return path;
    }

    public void launchGame(String path) {
        System.out.println("path = " + path);
        File file = new File(path);
        try {
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openEditor(String title) {
        new GameEditor(title, frame);
    }

    public static void main(String[] args) {
        new GameMenu();
    }
}
