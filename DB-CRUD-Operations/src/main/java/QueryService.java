public class QueryService {

    /**
     * Generic queries
     * */

    public static final String SELECT_ALL_FROM_TABLE = "select %s from %s;";

    public static final String INSERT_INTO_TABLE = "insert into %s (%s) values (%s);";

    public static final String DELETE_FROM_TABLE = "delete from %s where %s %s %s;";

    public static final String UPDATE_TABLE = "update %s set %s where %s %s %s";

    /**
     * Sample queries
     * */

    public static final String DELETE_FROM_PRODUCTS_BY_ID = "delete from production.products where product_id = %s";

    public static final String SELECT_FROM_PRODUCTS_BY_PRICE =
            "select product_name from production.products where list_price > %d";

    public static final String UPDATE_PROD_PRICE_BY_BRAND =
            "update production.products " +
            "set list_price = list_price+100 " +
            "where brand_id = %d;";

    public static final String BULK_INSERT = "insert into %s (%s) values (%s)";
}
