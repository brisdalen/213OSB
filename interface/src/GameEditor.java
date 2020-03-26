import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GameEditor extends JFrame {

    private JFrame parent;
    private JPanel panel;
    private JPanel buttonPanel;
    private JTextArea inputField;
    private JButton saveButton;
    private JButton loadButton;
    private Path lastOpened;

    public GameEditor(String title, JFrame parent) {
        super(title);
        this.parent = parent;
        setMinimumSize(new Dimension(600, 400));

        add(panel = new JPanel());
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

    public void loadText(File selectedFile, JTextArea area) throws IOException {
        FileReader fileReader = new FileReader(selectedFile);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = null;
        StringBuilder sb = new StringBuilder();
        while((line = reader.readLine()) != null) {
            sb.append(line);
        }
        area.setText(sb.toString());
    }

    public void saveText(JTextArea area) throws IOException {
        //TODO: Lagrer ikke ordentlig
        String input = area.getText();
        Path path = Paths.get("gameserver");
        if(Files.notExists(path) && !Files.exists(path)) {
            boolean dir = new File("./gamesave").mkdirs();
            if(dir) {
                System.out.println("directory created");
            } else {
                System.out.println("could not create directory");
            }
        } else {
            System.out.println("Could not determine if the directory exists.");
        }

        FileOutputStream fos;
        Path filepath = Paths.get("./gamesave/hello.txt");
        if(Files.notExists(filepath)) {
            fos = new FileOutputStream(filepath.toString());
            System.out.println("File created");
            fos.write(input.getBytes());
            fos.flush();
            fos.close();
        } else {
            FileReader fileReader = new FileReader(filepath.toString());
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            StringBuilder sb = new StringBuilder();
            while((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            fos = new FileOutputStream(filepath.toString());
            fos.write(sb.toString().getBytes());
            fos.flush();
            fos.close();
        }
    }
}
