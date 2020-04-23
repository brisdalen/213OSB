import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class GameEditor extends JFrame {

    private JFrame parent;
    private JFrame thisFrame;
    private int width = 600;
    private int height = 400;
    private JPanel panel;

    private JTextArea inputField;
    private Font font1;
    private int initialFontSize = 24;
    private int textSize = initialFontSize;

    private JPanel buttonPanel;
    private JButton saveButton;
    private JButton loadButton;
    private JButton exportTextButton;
    private JButton exportImageButton;

    private JPanel colorPanel;
    private JLabel foregroundLabel;
    private JLabel backgroundLabel;
    private JButton foregroundButton;
    private JButton backgroundButton;
    private Color foregroundColor;
    private Color backgroundColor;
    private ArrayList<JButton> buttons;
    private JLabel textSizeLabel;
    private JTextField textSizeInput;

    private Path lastOpened;

    CustomProperties buttonProperties;
    CustomProperties messageProperties;

    public GameEditor(String title, JFrame parent) {
        super(title);
        this.parent = parent;
        // Used for the error message in fontSize
        thisFrame = this;
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

        initInputField();
        // --------------- inputField panel complete ---------------
        // Button panel initialization
        initButtons();
        // --------------- Button panel complete ---------------
        // Color panel initialization
        initColorPanel();
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

    private void initInputField() {
        inputField = new JTextArea();
        font1 = new Font(Font.SANS_SERIF, Font.PLAIN, initialFontSize);
        inputField.setFont(font1);
        inputField.setLineWrap(true);
    }

    private void initButtons() {
        saveButton = new JButton(buttonProperties.getProperty("saveText"));
        saveButton.addActionListener(e -> {
            try {
                saveText(inputField);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        loadButton = new JButton(buttonProperties.getProperty("loadText"));
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

        exportTextButton = new JButton(buttonProperties.getProperty("exportText"));
        exportTextButton.addActionListener(e -> {
            String exportPath = "../spill_1/TextInput/";
            String[] count = new File(exportPath).list();
            int numFiles = 0;
            if(count != null) {
                numFiles = count.length;
            }
            String fileName;
            if(numFiles == 0) {
                fileName = "export_0";
            } else {
                fileName = "export_" + numFiles;
            }
            int foregroundColor = foregroundButton.getBackground().getRGB();
            int backgroundColor = backgroundButton.getBackground().getRGB();
            String content = inputField.getText();
            try {
                exportFile(exportPath, fileName, foregroundColor, backgroundColor, textSize, content);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        exportImageButton = new JButton(buttonProperties.getProperty("exportImage"));
        exportImageButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser("../spill_1/TextInput");
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text exports", "export");
            chooser.setFileFilter(filter);

            int returnVal = chooser.showOpenDialog(this);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                // Open and retrieve the path of the selected file
                File selected = chooser.getSelectedFile();
                try {
                    TextImage.createFile(selected);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        buttonPanel = new JPanel();
        buttonPanel.setFocusable(true);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        buttonPanel.add(exportTextButton);
        buttonPanel.add(exportImageButton);
    }

    private void initColorPanel() {
        String chooseForeground = buttonProperties.getProperty("selectForeground");
        foregroundLabel = new JLabel(chooseForeground);
        foregroundColor = Color.GREEN;
        foregroundButton = new JButton("");

        foregroundButton.addActionListener(e -> {
            addForegroundColorChooser(foregroundButton, chooseForeground, foregroundColor);
            //inputField.setForeground(foregroundColor);
        });
        buttons.add(foregroundButton);

        String chooseBackground = buttonProperties.getProperty("selectBackground");
        backgroundLabel = new JLabel(chooseBackground);
        backgroundColor = Color.BLACK;
        backgroundButton = new JButton("");

        backgroundButton.addActionListener(e -> {
            addBackgroundColorChooser(backgroundButton, chooseBackground, backgroundColor);
            //inputField.setBackground(backgroundColor);
        });
        buttons.add(backgroundButton);

        foregroundButton.setBackground(foregroundColor);
        backgroundButton.setBackground(backgroundColor);

        colorPanel = new JPanel();
        colorPanel.setLayout(new GridLayout(8, 3));
        colorPanel.setPreferredSize(new Dimension(150, 0));

        for(JButton button : buttons) {
            button.setPreferredSize(new Dimension(30, 30));
        }

        textSizeLabel = new JLabel(buttonProperties.getProperty("selectTextSize"));
        textSizeInput = new JTextField(String.valueOf(textSize), 1);
        textSizeInput.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                //TODO: Fix error handling if the user enters a non-number into the fontSize input
                try {
                    textSize = Integer.parseInt(textSizeInput.getText());
                } catch(NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(thisFrame,
                            //messageProperties.getProperty("textFileOverridePrompt"),
                            "Please write a number instead.",
                            //messageProperties.getProperty("overrideNotice"),
                            "Number Expected Error",
                            JOptionPane.ERROR_MESSAGE,
                            null);
                    nfe.printStackTrace();
                    textSize = initialFontSize;
                }
                font1 = new Font(font1.getFontName(), font1.getStyle(), textSize);
                inputField.setFont(font1);
                inputField.repaint();
            }
        });
        textSizeInput.setHorizontalAlignment(JTextField.CENTER);
        inputField.setForeground(foregroundColor);
        inputField.setBackground(backgroundColor);
        inputField.setTabSize(2);

        colorPanel.add(foregroundLabel);
        colorPanel.add(foregroundButton);
        colorPanel.add(backgroundLabel);
        colorPanel.add(backgroundButton);
        colorPanel.add(textSizeLabel);
        colorPanel.add(textSizeInput);
    }

    private void addForegroundColorChooser(JButton jButton, String frameText, Color color) {
        inputField.setForeground(addColorChooser(jButton, frameText, color));
        //inputField.repaint();
    }

    private void addBackgroundColorChooser(JButton jButton, String frameText, Color color) {
        inputField.setBackground(addColorChooser(jButton, frameText, color));
        //inputField.repaint();
    }

    private Color addColorChooser(JButton jButton, String frameText, Color color) {
        Color newColor = JColorChooser.showDialog(this, frameText, color);
        if(newColor != null) {
            jButton.setBackground(newColor);
            return newColor;
        }
        return color;
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

    private void exportFile(String folderPath, String fileName, int foregroundRGB, int backgroundRGB, int textSize, String content) throws IOException {
        Path filepath = Paths.get(folderPath + fileName + ".export");
        FileOutputStream fos = new FileOutputStream(filepath.toString());
        String export = "[" + backgroundRGB + "]\n[" + foregroundRGB+ "]\n[" + textSize + "]\n" + content;
        fos.write(export.getBytes());
        System.out.println("Export success! " + filepath);
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
