import java.sql.*;
import java.util.List;

/**
 * Created by usuario on 10/11/2015.
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        DomainReader domainReader = new DomainReader("domains.txt");
        List<String> domains = domainReader.getDomains();

        SQLInsert sqlInsert = new SQLInsert(domains);
        sqlInsert.execute();
    }
}
