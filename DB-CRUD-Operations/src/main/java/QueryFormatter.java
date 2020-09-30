public class QueryFormatter {

    public static String selectQueryFormatter(String[] columnNames, String table) {
        String listOfColumns = "";
        if (columnNames.length > 0) {
            listOfColumns = String.join(", ", columnNames);
        }
        return String.format(QueryService.SELECT_ALL_FROM_TABLE, listOfColumns, table);
    }

    public static String insertQueryFormatter(String tableName, String[] columnNames, String[] values) {
        String listOfColumns = "", listOfValues = "";

        for (int i = 0; i < values.length; i++) {
            String format = "'" + values[i] + "'";
            values[i] = format;
        }

        if (columnNames.length > 0 && values.length > 0) {
            listOfColumns = String.join(", ", columnNames);
            listOfValues = String.join(", ", values);
        }
        return String.format(QueryService.INSERT_INTO_TABLE, tableName, listOfColumns, listOfValues);
    }

    public static String deleteQueryFormatter(String tableName, String column, String operation, String value) {
        value = "'" + value + "'";
        return String.format(QueryService.DELETE_FROM_TABLE, tableName, column, operation, value);
    }

    public static String updateQueryFormatter(
            String table, String[] columnToUpdate, String[] valueForUpdate,
            String columnToCompare, String operationToCompare, String valueToCompare
    ) {
        String listOfCouplesToUpdate = "";
        String[] formatter;

        for (int i = 0, j = 0; i < valueForUpdate.length && j < columnToUpdate.length; i++, j++) {
            valueForUpdate[i] = "'" + valueForUpdate[i] + "'";
            formatter = columnToUpdate;
            formatter[i] = columnToUpdate[i] + " = " + valueForUpdate[i];
        }

        listOfCouplesToUpdate = String.join(", ", columnToUpdate);
        valueToCompare = "'" + valueToCompare + "'";

        return String.format(
                QueryService.UPDATE_TABLE, table, listOfCouplesToUpdate, columnToCompare, operationToCompare, valueToCompare);
    }

    public static String bulkInsertFormatter(String tableName, String[] columnNames) {
        String listOfColumns = "", listOfValues = "";

        String[] values = new String[columnNames.length];
        for (int i = 0; i < columnNames.length; i++) {
            values[i] = "?";
        }

        if (columnNames.length > 0) {
            listOfColumns = String.join(", ", columnNames);
            listOfValues = String.join(", ", values);
        }
        return String.format(QueryService.INSERT_INTO_TABLE, tableName, listOfColumns, listOfValues);
    }

    //todo: do not forget to delete before presentation

    public static void main(String[] args) {
//        System.out.println(insertQueryFormatter("people", new String[]{"col1", "col2"}, new String[]{"val1", "val2"}));
//        System.out.println(updateQueryFormatter("production.products", new String[]{"product_name", "list_price"},
//                new String[]{"New Prod", "666.66"}, "product_id", "=", "325"));
//        System.out.println(bulkInsertFormatter("table", new String[]{"col1", "col2"}));
    }
}