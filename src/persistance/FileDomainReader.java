package persistance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by usuario on 10/11/2015.
 */
public class FileDomainReader implements  DomainReader {

    private String path;

    public FileDomainReader(String path) {
        this.path = path;
    }

    public List<String> getDomains() {
        try {
            List<String> domains = new LinkedList<>();
            BufferedReader reader = new BufferedReader(new FileReader(this.path));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                domains.add(currentLine);
            }
            reader.close();
            return domains;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
