import java.sql.*;

/**
 * Created by usuario on 10/11/2015.
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:People");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM people");
            System.out.println("id\tname");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2));
            }
            resultSet.close();
            statement.close();
            connection.close();
        }

        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@10.22.143.90:1521:orcl", "system", "orcl");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM people");
            System.out.println("id\tname");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2));
            }
            resultSet.close();
            statement.close();
            connection.close();
        }
    }
}
