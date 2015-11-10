import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by usuario on 10/11/2015.
 */
public class SQLInsert {

    private List<String> domains;

    public SQLInsert(List<String> domains) {
        this.domains = domains;
    }

    public void execute() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:People");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO mail VALUES(?,?)");
            int currentName = 1;
            for(String currentDomain : domains){
                preparedStatement.setInt(1, currentName++);
                preparedStatement.setString(2, currentDomain);
                preparedStatement.executeUpdate();
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
