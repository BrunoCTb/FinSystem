package finance;

import finance.sqlite.Sqlite;

import java.sql.Statement;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Sqlite sqlite = new Sqlite();

        // [ ["id", "INTEGER PRIMARY KEY"], ["title", "VARCHAR(250)"], [] ]
        List<Map<String, String>> sqlValues = new ArrayList<>();

        // List<Map<String, String>>
        sqlValues.add(Map.of("id", "INTEGER PRIMARY KEY"));
        sqlValues.add(Map.of("title", "VARCHAR(250)"));

        String tableValues = sqlite.makeSqlSript(sqlValues);

        sqlite.createTable("tabela_test", tableValues);


    }
}