package finance.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Sqlite {

    public void connection() {
        String dbRelativePath = "src/main/resources/db/";
        String dbName = "finance.db";

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + dbRelativePath + dbName)) {
            System.out.println("Conexao com sucesso");
        } catch (SQLException e) {
            System.out.println("Exception: " + e);
        }
    }

}
