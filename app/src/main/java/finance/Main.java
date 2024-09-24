package finance;

import finance.sqlite.Sqlite;

public class Main {
    public static void main(String[] args) {
        Sqlite sqlite = new Sqlite();
        sqlite.connection();
    }
}