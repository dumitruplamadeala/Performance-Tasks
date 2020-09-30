import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

    private String tableName;
    private String column;
    private String operation;
    private String value;

    public Delete() { }

    public Delete(String tableName, String column, String operation, String value) {
        this.tableName = tableName;
        this.column = column;
        this.operation = operation;
        this.value = value;
    }

    public void deleteFromTable(Statement statement) throws SQLException {
        String sql = QueryFormatter.deleteQueryFormatter(tableName, column, operation, value);
        statement.execute(sql);
        System.out.println("Record deleted successfully");
    }

    public void deleteFromTableWithoutFormatter(Statement statement, String query) throws SQLException {
        statement.execute(query);
        System.out.println("Record deleted successfully");
    }
}
