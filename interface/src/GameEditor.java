import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class GameEditor extends JFrame {

    private JFrame parent;
    private JPanel panel;
    private JPanel buttonPanel;
    private JTextArea inputField;
    private JButton saveButton;
    private JButton loadButton;
    private Path lastOpened;
    private int width = 600;
    private int height = 400;

    Properties properties;

    public GameEditor(String title, JFrame parent) {
        super(title);
        this.parent = parent;
        init();
    }

    private void loadProperties() {
        try {
            //UIManager.put("OptionPane.messageFont", new FontUIResource("Lucida Sans", Font.PLAIN, 16));
            FileInputStream settings = new FileInputStream("settings/config.properties");
            properties = new Properties();
            properties.load(settings);
            loadLanguagePack(properties.getProperty("language"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init() {
        loadProperties();
        setMinimumSize(new Dimension(width, height));

        this.add(panel = new JPanel());
        inputField = new JTextArea();
        inputField.setLineWrap(true);

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

        panel.setLayout(new BorderLayout());
        panel.add(inputField, BorderLayout.CENTER);
        buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        setLocation(parent.getX()-parent.getWidth()+parent.getWidth()/2, parent.getY()+parent.getHeight());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void loadLanguagePack(String chosenLanguage) throws IOException {
        // Load a language pack based on what is selected in the config properties file
        // i.e. Constants.ENGLISH_UK selects the en_UK_standard language package
        properties = new Properties();
        String prefix = "resources/Messages_";
        String suffix = ".properties";
        FileInputStream language = null;

        switch(chosenLanguage) {

            case Constants.NORWEGIAN:
                language = new FileInputStream(prefix + "NO_bokmaal" + suffix);
                properties.load(language);
                break;

            default:
                language = new FileInputStream(prefix + "en_UK_standard" + suffix);
                properties.load(language);
                break;
        }
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
        String folderName = "gamesave";
        String folderPath = "./" + folderName;

        String input = area.getText();
        Path path = Paths.get(folderName);
        if(Files.notExists(path) && !Files.exists(path)) {
            createDir(folderPath);
        } else {
            System.out.println("Could not determine if the directory exists.");
        }

        saveFile(folderPath, input);
    }

    private void createDir(String filepath) {
        boolean dir = new File(filepath).mkdirs();
        if(dir) {
            System.out.println("directory created");
        } else {
            System.out.println("could not create directory");
        }
    }

    private void saveFile(String folderPath, String input) throws IOException {
        FileOutputStream fos = null;
        Path filepath = Paths.get(folderPath + "/hello.txt");
        if(Files.notExists(filepath)) {
            System.out.println("Creating and writing to file.");
            fos = new FileOutputStream(filepath.toString());
            fos.write(input.getBytes());
        } else {
            // Prompt the user if they want to override the existing file, and do nothing if they don't.
            System.out.println("Prompting for overriding.");
            int result = JOptionPane.showConfirmDialog(this,
                    properties.getProperty("textFileOverridePrompt"),
                    properties.getProperty("overrideNotice"),
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
