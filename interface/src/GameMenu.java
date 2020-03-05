import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GameMenu {

    private ArrayList<JButton> gameLaunchers;
    private ArrayList<JButton> gameEditors;
    private String OS;

    private JFrame frame;
    private JPanel containerPanel;
    private JPanel launchEditPanel;
    private JPanel launchGamePanel;

    private int width = 300;

    public GameMenu() {
        init();
    }

    private void init() {
        gameLaunchers = new ArrayList<>();
        gameEditors = new ArrayList<>();
        OS = System.getProperty("os.name").toLowerCase();

        containerPanel = new JPanel();
        containerPanel.setLayout(new BorderLayout());
        frame = new JFrame("Game Menu");
        frame.setMinimumSize(new Dimension(width, width/2));

        launchGamePanel = new JPanel();
        launchGamePanel.setLayout(new FlowLayout());

        launchEditPanel = new JPanel();
        launchEditPanel.setLayout(new FlowLayout());

        try {
            addGameLaunchers(launchGamePanel);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton launchEditor1 = new JButton("Launch editor 1");
        launchEditor1.addActionListener(e -> openEditor("Editor 1"));
        gameEditors.add(launchEditor1);

        JButton launchEditor2 = new JButton("Launch editor 2");
        launchEditor2.addActionListener(e -> openEditor("Editor 2"));
        gameEditors.add(launchEditor2);

        for(JButton b : gameEditors) {
            launchEditPanel.add(b);
        }

        containerPanel.add(launchGamePanel, BorderLayout.CENTER);
        containerPanel.add(launchEditPanel, BorderLayout.SOUTH);

        frame.add(containerPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void addGameLaunchers(JPanel panel) throws Exception {
        //TODO: Lettere å legge til flere games?
        JButton launchGame1 = new JButton("Launch game 1");
        // Retrieve the operating system name to open the right executable.
        String os = getOSName();
        if (os != null) {
            // Find and open the right file depending on the operating system, when you click the launching button.
            if(os.equals(Constants.WINDOWS)) {
                //TODO: Finne path til fil, og prøve å tracke endringer om filen flyttes
                //TODO: Flytte hver executable inn i en egen mappe, for hver os
                launchGame1.addActionListener(e -> launchGame(findGamePath() + "\\interface\\test\\windows\\runTest.exe"));
                printGamePath();

            } else if(os.equals(Constants.MAC)) {
                launchGame1.addActionListener(e -> launchGame(findGamePath() + "/interface/test/runTest.app"));
                printGamePath();

            } else if(os.equals(Constants.UNIX)) {
                launchGame1.addActionListener(e -> launchGame(findGamePath() + "/interface/test/runTest"));
                printGamePath();

            }
        }
        // Add the button to the list of launchers, and to the panel.
        gameLaunchers.add(launchGame1);

        for(JButton b : gameLaunchers) {
            panel.add(b);
        }
    }

    /**
     *
     * @return operating system name as a string, or null if the os is not recognized
     */
    private String getOSName() {
        if (isWindows(OS)) {
            return Constants.WINDOWS;

        } else if (isMac(OS)) {
            return Constants.MAC;

        } else if (isUnix(OS)) {
            return Constants.UNIX;

        } else {
            System.out.println("OS not supported.");
            return null;
        }

    }

    private String findGamePath() {
        // Burde pathen lagres til en config fil for hver gang, eller når den gamel pathen ikke matcher en ny en?
        // Evt. Når pathen ikke matcher, bruk JFileChooser og be brukeren navigere til riktig mappe
        //TODO: Implement path finding of applications

        String path;

        path = new File("").getAbsolutePath();

        return path;
    }

    public void printGamePath() {
        System.out.println("[GameMenu]" + findGamePath());
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

    private boolean isWindows(String OS) {
        return (OS.contains("win"));
    }
    private boolean isMac(String OS) {
        return (OS.contains("mac"));
    }
    private boolean isUnix(String OS) {
        return (OS.contains("nix") || OS.contains("nux") || OS.contains("aix"));
    }


    public static void main(String[] args) {
        new GameMenu();
    }
}
