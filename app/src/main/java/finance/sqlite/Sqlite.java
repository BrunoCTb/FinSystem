package finance.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

public class Sqlite {

    private final String DB_RELATIVE_PATH = "src/main/resources/db/";
    private final String DB_NAME = "finance.db";

    public Statement connection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:" + DB_RELATIVE_PATH + DB_NAME);
            Statement statement = connection.createStatement();

            return statement;
        } catch (SQLException e) {
            System.out.println("Exception ao gerar conexão: " + e);
            return null;
        }
    }

    public void createTable(String tableName, String tableValues){
        String script = "CREATE TABLE " + tableName + "(\n" +
                tableValues +
                " \n);";

        try (Statement statement  = this.connection()) {
            statement.execute(script);

            System.out.println("A tabela " + tableName + " foi criada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Exception: " + e);
        }
    }

    public String makeSqlSript(List<Map<String, String>> sqlValues) {
        String script = "";
        String vSyntax = ","; // virgula que vai ser removida caso seja a ultima linha
        int loop = sqlValues.size() - 1; // contaagem do loop

        for (Map<String, String> map : sqlValues) {
            for (Map.Entry<String, String> i : map.entrySet()) {
                if (loop <= 0) {
                    vSyntax = "";
                }
                script += "    " + i.getKey() + " " + i.getValue() + vSyntax + "\n";
                loop --;
            }
        }

        return script;
    }

}
