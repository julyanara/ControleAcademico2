package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoMysql {

    public static Connection getConexao() throws Exception{
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/academico", 
    "root", "");
    }

}
