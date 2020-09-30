import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select {

    private String[] columns;
    private String table;

    public Select(String[] columns) {
        this.columns = columns;
    }

    public Select(String[] columns, String table) {
        this.columns = columns;
        this.table = table;
    }

    public ResultSet selectResultSet(Statement statement) throws SQLException {
        String sql = QueryFormatter.selectQueryFormatter(this.columns, this.table);
        return statement.executeQuery(sql);
    }

    public ResultSet selectResultSetWithoutFormatting(Statement statement, String query) throws SQLException {
        return statement.executeQuery(query);
    }

    public void printResult(ResultSet resultSet) throws SQLException {
            while (resultSet.next()) {
                for (String column : columns) {
                    String resultSetParam = Utils.getResultSetParam(resultSet, column);
                    System.out.print(column + ": " + resultSetParam + " ");
                }
                System.out.println();
            }
        resultSet.close();
    }
}
