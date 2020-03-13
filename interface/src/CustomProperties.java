import java.util.Properties;

public class CustomProperties extends Properties {
    private String name;

    public CustomProperties(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
