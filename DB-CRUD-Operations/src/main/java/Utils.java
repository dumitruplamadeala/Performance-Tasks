import java.sql.ResultSet;
import java.sql.SQLException;

public class Utils {

    public static String getResultSetParam(ResultSet resultSet, String columnLabel) throws SQLException {
        return resultSet.getString(columnLabel);
    }
}
