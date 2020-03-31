import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;

public class GameEditor extends JFrame {

    private JFrame parent;
    private int width = 600;
    private int height = 400;
    private JPanel panel;

    private JTextArea inputField;

    private JPanel buttonPanel;
    private JButton saveButton;
    private JButton loadButton;

    private JPanel colorPanel;
    private JLabel foregroundLabel;
    private JLabel backgroundLabel;
    private JButton foregroundButton;
    private JButton backgroundButton;
    private Color foregroundColor;
    private Color backgroundColor;
    private ArrayList<JButton> buttons;

    private Path lastOpened;

    CustomProperties buttonProperties;
    CustomProperties messageProperties;

    public GameEditor(String title, JFrame parent) {
        super(title);
        this.parent = parent;
        init();
    }

    private void init() {
        initProperties();
        initGUI();
    }

    private void initProperties() {
        // Provide which folder in the resoures folder you want to use, and the up till the first '_'
        buttonProperties = new CustomProperties("buttons/ButtonText");
        messageProperties = new CustomProperties("warnings/Messages");
        loadProperty(buttonProperties);
        loadProperty(messageProperties);
    }

    //TODO: static metode eller fra en Utility klasse
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
    //TODO: static metode eller fra en Utility klasse
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
    //TODO: static metode eller fra en Utility klasse
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
        buttons = new ArrayList<>();
        try {
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
        } catch (Exception e) {
            e.printStackTrace();
        }
        setMinimumSize(new Dimension(width, height));
        // Main panel with the inputField initialization
        this.add(panel = new JPanel());

        inputField = new JTextArea();
        inputField.setLineWrap(true);
        // --------------- inputField panel complete ---------------
        // Button panel initialization
        saveButton = new JButton("Save text");
        saveButton.addActionListener(e -> {
            try {
                saveText(inputField);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        loadButton = new JButton("Load textfile");
        //TODO: kanskje refactore til egen klasse?
        loadButton.addActionListener(e -> {
            try {
                JFileChooser fileChooser;
                if(lastOpened == null) {
                    fileChooser = new JFileChooser();
                } else {
                    // If a file has already been opened, open the fileChooser at the last saved path
                    fileChooser = new JFileChooser(lastOpened.toString());
                }
                int returnVal = fileChooser.showOpenDialog(this);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    // Open and retrieve the path of the selected file
                    File selectedFile = fileChooser.getSelectedFile();
                    String opened = selectedFile.getAbsolutePath();
                    if(lastOpened != null) {
                        // Update the lastOpened path to the most recent, if they are not the same
                        if (!opened.equals(lastOpened.toString())) {
                            lastOpened = Paths.get(opened);
                        }
                    } else {
                        // This sets the lastOpened path for the first time it runs
                        //TODO: Lagre lastOpened i en config fil?
                        lastOpened = Paths.get(opened);
                    }
                    // Load the content of the selected file to the textarea
                    loadText(selectedFile, inputField);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        // --------------- Button panel complete ---------------
        // Color panel initialization

        foregroundLabel = new JLabel(buttonProperties.getProperty("selectForeground"));
        foregroundColor = Color.GREEN;
        foregroundButton = new JButton("");
        buttons.add(foregroundButton);

        backgroundLabel = new JLabel(buttonProperties.getProperty("selectBackground"));
        backgroundColor = Color.BLACK;
        backgroundButton = new JButton("");
        buttons.add(backgroundButton);

        foregroundButton.setBackground(foregroundColor);
        backgroundButton.setBackground(backgroundColor);

        colorPanel = new JPanel();
        colorPanel.setLayout(new FlowLayout());
        colorPanel.setPreferredSize(new Dimension(150, 0));

        for(JButton button : buttons) {
            button.setPreferredSize(new Dimension(30, 30));
        }

        colorPanel.add(foregroundLabel);
        colorPanel.add(foregroundButton);
        colorPanel.add(backgroundLabel);
        colorPanel.add(backgroundButton);
        // --------------- Color panel complete ---------------
        // Adding all panels to the main panel
        panel.setLayout(new BorderLayout());
        panel.add(inputField, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        panel.add(colorPanel, BorderLayout.EAST);

        setLocation(parent.getX()-parent.getWidth()+parent.getWidth()/2, parent.getY()+parent.getHeight());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        this.pack();
    }

    public void loadText(File selectedFile, JTextArea area) throws IOException {
        FileReader fileReader = new FileReader(selectedFile);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = null;
        StringBuilder sb = new StringBuilder();
        // If it find a new line, it appends and sets the area text to the final result.
        while((line = reader.readLine()) != null) {
            sb.append(line);
        }
        area.setText(sb.toString());
    }

    public void saveText(JTextArea area) throws IOException {
        String folderName = "TextInput";
        String folderPath = "../spill_1/" + folderName;

        String input = area.getText();
        Path path = Paths.get(folderName);
        if(Files.notExists(path) && !Files.exists(path)) {
            createDir(folderPath);
        } else {
            System.err.println("Could not determine if the directory exists.");
        }

        saveFile(folderPath, input);
    }

    private void createDir(String filepath) {
        boolean dir = new File(filepath).mkdirs();
        if(dir) {
            System.out.println("directory created");
        } else {
            System.err.println("could not create directory");
        }
    }

    private void saveFile(String folderPath, String input) throws IOException {
        FileOutputStream fos = null;
        Path filepath = Paths.get(folderPath + "/hello.txt");
        System.out.println("[GE]" + filepath);
        if(Files.notExists(filepath)) {
            System.out.println("Creating and writing to file.");
            fos = new FileOutputStream(filepath.toString());
            fos.write(input.getBytes());
        } else {
            // Prompt the user if they want to override the existing file, and do nothing if they don't.
            System.out.println("Prompting for overriding.");
            int result = JOptionPane.showConfirmDialog(this,
                    messageProperties.getProperty("textFileOverridePrompt"),
                    messageProperties.getProperty("overrideNotice"),
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null);

            if(result == 0) {
                System.out.println("Overriding existing file.");
                fos = new FileOutputStream(filepath.toString());
                fos.write(input.getBytes());
            } else {
                System.err.println("Aborting override.");
            }
        }

        if(fos != null) {
            fos.flush();
            fos.close();
        }
    }
}
