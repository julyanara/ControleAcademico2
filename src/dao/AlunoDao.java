package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import domain.Aluno;

public class AlunoDao {

    public void inserir(Aluno aluno) throws Exception {

        String sql = "INSERT INTO TB_ALUNO (CODIGO, NOME, CPF, EMAIL, SENHA, RG, SEXO, DATANASC, CURSO, BOLSITA, HISTORICO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = ConexaoMysql.getConexao();
        PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        stmt.setInt(1, aluno.getCodigo());
        stmt.setString(2, aluno.getNome());
        stmt.setString(3, aluno.getCpf());
        stmt.setString(4, aluno.getEmail());
        stmt.setString(5, aluno.getSenha());
        stmt.setString(6, aluno.getRg());
        stmt.setString(7, aluno.getSexo());
        stmt.setDate(8, aluno.getDataNasc());
        stmt.setString(9, aluno.getCurso());
        stmt.setString(10, aluno.getBolsista());
        stmt.setString(11, aluno.getHistorico());

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            aluno.setCodigo(rs.getInt(1));
        }

        stmt.close();
        connection.close();
    }
}
