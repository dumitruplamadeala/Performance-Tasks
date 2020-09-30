import java.sql.SQLException;
import java.sql.Statement;

public class Update {

    private String table;
    private String[] columnToUpdate;
    private String[] valueForUpdate;
    private String columnToCompare;
    private String operationToCompare;
    private String valueToCompare;

    public Update() { }

    public Update(String table, String[] columnToUpdate, String[] valueForUpdate, String columnToCompare,
                  String operationToCompare, String valueToCompare
    ) {
        this.table = table;
        this.columnToUpdate = columnToUpdate;
        this.valueForUpdate = valueForUpdate;
        this.columnToCompare = columnToCompare;
        this.operationToCompare = operationToCompare;
        this.valueToCompare = valueToCompare;
    }

    public void updateTable(Statement statement) throws SQLException {
        String sql = QueryFormatter.updateQueryFormatter(
                table, columnToUpdate, valueForUpdate, columnToCompare, operationToCompare, valueToCompare);
        statement.executeUpdate(sql);
        System.out.println("Update successfully executed.");
    }

    public void updateTableWithoutFormatting(Statement statement, String query) throws SQLException {
        statement.executeUpdate(query);
        System.out.println("Update successfully executed.");
    }
}
