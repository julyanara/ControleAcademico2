package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import domain.Matricula;

public class MatriculaDao {

    public void inserir(Matricula matricula) throws Exception {

        String sql = "INSERT INTO TB_MATRICULA(CODIGO, DATAMAT) VALUES (?, ?)";

        Connection conexao = ConexaoMysql.getConexao();
        PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        stmt.setInt(1, matricula.getCodigo());
        stmt.setDate(2, matricula.getDataMat(), null);

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            matricula.setCodigo(rs.getInt(1));
        }

        stmt.close();
        conexao.close();
    }
}
