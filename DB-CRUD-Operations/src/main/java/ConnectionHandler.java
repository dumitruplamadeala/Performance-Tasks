import java.io.IOException;
import java.sql.*;

public class ConnectionHandler {

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement;

        try {
            ConnectionSettings connectionSettings = new ConnectionSettings();

            connection = DriverManager.getConnection(
                    connectionSettings.getDbURL(),
                    connectionSettings.getUser(),
                    connectionSettings.getPassword());

            if (connection != null) {
                DatabaseMetaData databaseMetaData = connection.getMetaData();
                System.out.println("Driver name: " + databaseMetaData.getDriverName());
                System.out.println("Driver version: " + databaseMetaData.getDriverVersion());
                System.out.println("Product name: " + databaseMetaData.getDatabaseProductName());
                System.out.println("Create Statemanet");
                statement = connection.createStatement();


                /**
                 * Implementation of task nr 1
                 */
//                Select select = new Select(new String[]{"brand_id", "brand_name"}, "production.brands");
//                ResultSet resultSet = select.selectResultSet(statement);
//                select.printResult(resultSet);
//             //     option without formatting
//                Select selectProd = new Select(new String[]{"product_name"});
//                ResultSet resultSet = selectProd.selectResultSetWithoutFormatting(
//                        statement, String.format(QueryService.SELECT_FROM_PRODUCTS_BY_PRICE, 700));
//                selectProd.printResult(resultSet);
                /**
                 * Implementation of task nr 2
                 */
//                Insert insert = new Insert(
//                        "production.products",
//                        new String[]{"product_name", "brand_id", "category_id", "model_year", "list_price"},
//                        new String[]{"Masseratti", "1", "2", "2020", "200.99"});
//                ResultSet resultSet = insert.insertIntoTable(connection);
//                insert.printIdOfInsertedRow(resultSet);

                /**
                 * Implementation of task nr 3
                 */
//                Delete delete = new Delete("production.products", "product_id", "=", "322");
//                delete.deleteFromTable(statement);
//              //  option without formatting
//                Delete deleteProd = new Delete();
//                deleteProd.deleteFromTableWithoutFormatter(statement, String.format(QueryService.DELETE_FROM_PRODUCTS_BY_ID, 325));

                /**
                 * Implementation of task nr 4
                 */
//                Update update = new Update("production.products", new String[]{"product_name", "list_price"},
//                        new String[]{"New Prod", "666.66"}, "product_id", "=", "325");
//                update.updateTable(statement);
//              //  option without formatting
//                Update updateProd = new Update();
//                updateProd.updateTableWithoutFormatting(statement, String.format(QueryService.UPDATE_PROD_PRICE_BY_BRAND, 1));

                /**
                 * Implementation of task nr 5 BulkInsert
                 */

                Insert insert = new Insert("production.products",
                        new String[]{"product_name", "brand_id", "category_id", "model_year", "list_price"});
                insert.bulkInsert(connection, "src/main/resources/products.csv");


//                /**
//                 * Implementation of task bulks insert
//                 */
//
//                String sql = "insert into production.products (product_name, brand_id, category_id, model_year, list_price)" +
//                        "values (?,?,?,?,?)";
//                PreparedStatement preparedStatement = connection.prepareStatement(sql);
//                BufferedReader lineReader = new BufferedReader(new FileReader("src/main/java/csv/products.csv"));
//                String lineText = null;
//                int count = 0, batchSize = 2;
//                lineReader.readLine();
//
//                while ((lineText = lineReader.readLine()) != null) {
//                    String[] data = lineText.split(",");
//                    String product_name = data[0];
//                    String brand_id = data[1];
//                    String category_id = data[2];
//                    String model_year = data[3];
//                    String list_price = data[4];
//
//                    preparedStatement.setString(1, product_name);
//                    preparedStatement.setString(2, brand_id);
//                    preparedStatement.setString(3, category_id);
//                    preparedStatement.setString(4, model_year);
//                    preparedStatement.setString(5, list_price);
//                    preparedStatement.addBatch();
//                    if(++count % batchSize == 0) {
//                        preparedStatement.executeBatch();
//                    }
//                }
//                preparedStatement.executeBatch();
//                lineReader.close();

            }
        } catch (SQLException | IOException exc) {
            exc.printStackTrace();
        } finally {
            try {
                if (connection != null && connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException exc) {
                exc.printStackTrace();
            }
        }
    }
}
