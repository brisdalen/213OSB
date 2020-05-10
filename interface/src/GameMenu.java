import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

public class GameMenu {

    CustomProperties buttonProperties;
    CustomProperties uiProperties;

    private ArrayList<JButton> gameLaunchers;
    private ArrayList<JButton> gameEditors;
    private String OS;

    private JFrame frame;
    private JPanel containerPanel;
    private JPanel launchEditPanel;
    private JPanel launchGamePanel;

    private int width = 300;

    public static void main(String[] args) {
        new GameMenu();
    }

    public GameMenu() {
        init();
    }

    private void init() {
        initProperties();
        initGUI();
    }

    private void initProperties() {
        // Provide which folder in the resoures folder you want to use, and the up till the first '_'
        buttonProperties = new CustomProperties("buttons/ButtonText");
        uiProperties = new CustomProperties("uitext/UIText");
        loadProperty(buttonProperties);
        loadProperty(uiProperties);
    }

    private void loadProperty(CustomProperties properties) {
        try {
            // When I tried to use the same FileInputStream for 2 properties, it didn't work.
            // Coincidentally, this lead to better cohesion through this method, as it now loads a specific Properties.
            FileInputStream settings = new FileInputStream("settings/config.properties");
            // Initially the config.properties is loaded into the given CustomProperties object. This temporarly loads
            // the country and language, which we use to load the rest of our properties.
            properties.load(settings);
            String language = properties.getProperty("language");
            loadLanguagePack(language, properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load a language pack based on what is selected in the config properties file
    // i.e. Constants.ENGLISH_UK selects the en_UK_standard language package
    private void loadLanguagePack(String chosenLanguage, CustomProperties properties) throws IOException {
        System.out.println("loadLanguagePack params: " + chosenLanguage + ", " + properties);
        // As you see, the prefix takes in the CustomProperties name in the prefix path. This is to be able to
        // choose which folder and type of properties to load. I.e. to load buttons, I set the name value to
        // "buttons/ButtonText".
        String prefix = "resources/" + properties.getName() + "_";
        loadLanguage(chosenLanguage, prefix, properties);
    }

    static void loadLanguage(String chosenLanguage, String prefix, Properties properties) throws IOException {
        String suffix = ".properties";
        Reader language = null;
        // Re-load the given property, based on which language pack has been selected in the config.properties file,
        // and encode it as UTF-8
        switch(chosenLanguage) {

            case Constants.NORWEGIAN:
                language = new InputStreamReader(new FileInputStream(prefix + "NO_bokmaal" + suffix), "UTF-8");
                properties.load(language);
                break;

            default:
                language = new InputStreamReader(new FileInputStream(prefix + "en_UK_standard" + suffix), "UTF-8");
                properties.load(language);
                break;
        }

        language.close();
    }

    private void initGUI() {
        // Initial variable initializations and property loading
        gameLaunchers = new ArrayList<>();
        gameEditors = new ArrayList<>();
        OS = System.getProperty("os.name").toLowerCase();
        // Panel, frame and button initializations
        containerPanel = new JPanel();
        containerPanel.setLayout(new BorderLayout());
        frame = new JFrame(uiProperties.getProperty("menuFrameTitle"));
        frame.setMinimumSize(new Dimension(width, width/2));
        // ----- Game launcher panel initialization and adding all game launcher buttons
        launchGamePanel = new JPanel();
        launchGamePanel.setLayout(new FlowLayout());
        try {
            addGameLaunchers(launchGamePanel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        containerPanel.add(launchGamePanel, BorderLayout.CENTER);
        // --------------- game launchers complete ---------------
        // Editing launcher panel initialization and adding all editor launcher buttons
        launchEditPanel = new JPanel();
        launchEditPanel.setLayout(new FlowLayout());
        // Retrieve button and ui text from the property files and apply them to ui buttons and frames.
        String launchEditorText = buttonProperties.getProperty("launchEditor");
        String frameEditorText = uiProperties.getProperty("editorFrameTitle");

        JButton launchEditor1 = new JButton(launchEditorText + " 1");
        launchEditor1.addActionListener(e -> openEditor(frameEditorText + " 1"));
        gameEditors.add(launchEditor1);

        JButton launchEditor2 = new JButton(launchEditorText + " 2");
        launchEditor2.addActionListener(e -> openEditor(frameEditorText + " 2"));
        gameEditors.add(launchEditor2);

        for(JButton b : gameEditors) {
            launchEditPanel.add(b);
        }
        containerPanel.add(launchEditPanel, BorderLayout.SOUTH);
        // --------------- game editors complete ---------------
        frame.add(containerPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // frame.pack() is very important, as the size of buttons change drastically depending on which language is chosen.
        frame.pack();
        frame.setLocation(getScreenCenter());
        frame.setVisible(true);
    }
    // Calculates the cener point of the screen by the value returned as the screensize
    private Point getScreenCenter() {
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        return new Point(screenDimension.width/2 - frame.getWidth()/2, screenDimension.height/2 - frame.getHeight()/2);
    }

    private void addGameLaunchers(JPanel panel) throws Exception {
        //TODO: Make it easier to add a game
        //TODO: WRITE ABOUT THIS HORRIBLE PROCESS ON THE WIKI
        JButton launchGame1 = new JButton(buttonProperties.getProperty("launchGame") + " 1");
        JButton launchGame2 = new JButton(buttonProperties.getProperty("launchGame") + " 2");
        // Retrieve the operating system name to open the right executable.
        String os = getOSName();
        if (os != null) {
            // Find and open the right file depending on the operating system, when you click the launching button.
            if(os.equals(Constants.WINDOWS)) {
                launchGame1.addActionListener(e -> launchGame(findGamePath() + "/Chewie/Exports/windows/Puzzle game.exe"));
                launchGame2.addActionListener(e -> notSupportedError("windows"));
                printGamePath();

            } else if(os.equals(Constants.MAC)) {
                launchGame1.addActionListener(e -> launchGame(findGamePath() + "/Chewie/Exports/mac/Puzzle game.app"));
                launchGame2.addActionListener(e -> notSupportedError("mac"));
                printGamePath();

            } else if(os.equals(Constants.UNIX)) {
                launchGame1.addActionListener(e -> launchGame(findGamePath() + "/Chewie/Exports/linux/Puzzle game.x86_64"));
                launchGame2.addActionListener(e -> notSupportedError("unix"));
                printGamePath();

            }
        }
        // Add the button to the list of launchers, and to the panel.
        gameLaunchers.add(launchGame1);
        gameLaunchers.add(launchGame2);

        for(JButton b : gameLaunchers) {
            panel.add(b);
        }
    }

    private void notSupportedError(String osNotSupported) {
        displayErrorMessage("Game not exported for " + osNotSupported, "Game Not Exported for this OS");
    }

    private void displayErrorMessage(String errorMessage, String frameTitle) {
        JOptionPane.showMessageDialog(this.frame,
                //TODO: use properties, like messageProperties.getProperty(errorMessage),
                errorMessage,
                //and messageProperties.getProperty("osNotExported"),
                frameTitle,
                JOptionPane.ERROR_MESSAGE,
                null);
    }

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
        // Find the path starting at the project list instead of in the interface folder
        path = new File("../").getAbsolutePath();

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

    public boolean isWindows(String OS) {
        return (OS.contains("win"));
    }
    public boolean isMac(String OS) {
        return (OS.contains("mac"));
    }
    public boolean isUnix(String OS) {
        return (OS.contains("nix") || OS.contains("nux") || OS.contains("aix"));
    }
}
