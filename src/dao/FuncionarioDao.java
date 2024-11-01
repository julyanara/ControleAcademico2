package dao;

import java.sql.*;
import domain.Funcionario;

public class FuncionarioDao {

    public void inserir(Funcionario funcionario) throws Exception {
        String sql = "INSERT INTO TB_FUNCIONARIO (CODIGO, NOME, EMAIL, SENHA, SEXO, AREA) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexao = ConexaoMysql.getConexao();
        PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, funcionario.getCódigo());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getEmail());
            stmt.setString(4, funcionario.getSenha());
            stmt.setString(5, funcionario.getSexo().toString());
            stmt.setString(6, funcionario.getÁrea());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    funcionario.setCódigo(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Erro ao inserir funcionário: " + e.getMessage());
        }
    }
}

