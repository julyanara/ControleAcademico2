package dao;

import java.sql.*;
import domain.Curso;

public class CursoDao {

    public void inserir(Curso curso) throws Exception {
        String sql = "INSERT INTO TB_CURSO (CODIGO, NOME, CARGAHORARIA) VALUES (?, ?, ?)";

        try (Connection conexao = ConexaoMysql.getConexao();
        PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, curso.getCódigo());
            stmt.setString(2, curso.getNome());
            stmt.setString(3, curso.getCargaHorária());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    curso.setCódigo(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception("Erro ao inserir curso: " + e.getMessage());
        }
    }
}

