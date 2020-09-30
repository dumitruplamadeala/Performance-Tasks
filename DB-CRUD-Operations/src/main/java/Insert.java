import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class Insert {

    private String table;
    private String[] columns;
    private String[] values;

    public Insert(String table, String[] columns) {
        this.table = table;
        this.columns = columns;
    }

    public Insert(String table, String[] columns, String[] values) {
        this.table = table;
        this.columns = columns;
        this.values = values;
    }

    public ResultSet insertIntoTable(Connection connection) throws SQLException {
        String sql = QueryFormatter.insertQueryFormatter(table, columns, values);
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.execute();
        return preparedStatement.getGeneratedKeys();
    }

    public void printIdOfInsertedRow(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.println("Generated ID: " + resultSet.getString(1));
        }
    }

    public void bulkInsert(Connection connection, String filePath) throws IOException, SQLException {
        String sql = QueryFormatter.bulkInsertFormatter(table, columns);

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String lineText;
        reader.readLine(); //skip header line

        while((lineText = reader.readLine()) != null) {
            String[] data = lineText.split(",");

            for (int i = 0; i < columns.length; i++) {
                columns[i] = data[i];
                preparedStatement.setString(i+1, data[i]);
            }
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
        reader.close();
    }
}
