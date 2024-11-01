package dao;

import java.sql.*;
import domain.Bolsista;

public class BolsistaDao {

    public void inserir(Bolsista bolsista) throws Exception {
        String sql = "INSERT INTO TB_BOLSISTA (CODIGO, HORASEMANAL, PROJETO_ID) VALUES (?, ?, ?)";

        Connection conexao = ConexaoMysql.getConexao();
        PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        stmt.setInt(1, bolsista.getCódigo());         stmt.setString(2, bolsista.getHoraSemanal());

                if (bolsista.getProjetos() != null) {
            stmt.setInt(3, bolsista.getProjetos().getId()); 
        } else {
            stmt.setNull(3, Types.INTEGER);
        }

        stmt.executeUpdate();

        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            bolsista.setCódigo(rs.getInt(1));
        }

        stmt.close();
        conexao.close();
    }
}

