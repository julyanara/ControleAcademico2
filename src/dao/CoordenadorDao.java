package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import domain.Coordenador;

public class CoordenadorDao {

    public void inserir(Coordenador coordinator) throws Exception {
        String sql = "INSERT INTO TB_COORDENADOR (CODIGO, NOME, EMAIL, SENHA, SEXO, AREA, SALARIO) VALUES (?, ?, ?, ?, ?, ?, ?)";

        Connection conexao = ConexaoMysql.getConexao();
        PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        stmt.setLong(1, coordinator.getCódigo());
        stmt.setString(2, coordinator.getNome());
        stmt.setString(3, coordinator.getEmail());
        stmt.setString(4, coordinator.getSenha());
        stmt.setString(5, coordinator.getSexo().name());
        stmt.setString(6, coordinator.getÁrea());
        stmt.setFloat(7, coordinator.getSalario());

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            coordinator.setCódigo(rs.getLong(1));
        }

        stmt.close();
        conexao.close();
    }
}
