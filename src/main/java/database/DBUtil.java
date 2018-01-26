package database;

import model.Record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Created by Qiushan on 2018/1/20.
 */
public class DBUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(DBUtil.class);
    // TODO move to config file
    public static String HOST = "localhost";
    public static String PORT = "3306";
    public static String USERNAME = "root";
    public static String PASSWORD = "123";

    public static String DEFAULT_DATABASE = "recordr";

    private static String getJdbcUrl(String database){
        // TODO move to config file
        String template = "jdbc:mysql://%s:%s/%s?useSSL=false";
        return String.format(template, HOST, PORT, database);
    }

    // Find record with give ID; If not, return null
    private static String GET_RECORD_BY_ID_SQL = "SELECT * " +
            "FROM records " +
            "WHERE Id = ?";
    public static Record getRecordById(int recordId){
        LOGGER.info(GET_RECORD_BY_ID_SQL);
        try(Connection conn = DriverManager.getConnection(getJdbcUrl(DEFAULT_DATABASE), USERNAME, PASSWORD);
            PreparedStatement ps = conn.prepareStatement(GET_RECORD_BY_ID_SQL)) {
            ps.setInt(1, recordId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    // TODO need a way to unify access to table fields
                    return new Record(recordId, rs.getString("Title"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }
}
