import persistance.DomainReader;
import persistance.FileDomainReader;
import persistance.SQLInsert;
import persistance.SQLiteInsert;

import java.util.List;

/**
 * Created by usuario on 10/11/2015.
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");

        DomainReader domainReader = new FileDomainReader("domains.txt");
        List<String> domains = domainReader.getDomains();

        SQLInsert sqlInsert = new SQLiteInsert(domains);
        sqlInsert.execute();
    }
}
