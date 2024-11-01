package dao;

import domain.Historico;
import java.sql.*;

public class HistoricoDao {

    private Connection connection;

    public HistoricoDao(Connection connection) {
        this.connection = connection;
    }

    public void create(Historico historico) throws SQLException {
        String sql = "INSERT INTO historicos (nota) VALUES (?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setFloat(1, historico.getNota());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    historico.setCodigo(generatedKeys.getInt(1));
                }
            }
        }
    }

    public Historico read(Integer codigo) throws SQLException {
        String sql = "SELECT * FROM historicos WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Historico historico = new Historico(rs.getFloat("nota"));
                historico.setCodigo(codigo);
                return historico;
            }
        }
        return null;
    }

    public void update(Historico historico) throws SQLException {
        String sql = "UPDATE historicos SET nota = ? WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setFloat(1, historico.getNota());
            stmt.setInt(2, historico.getCodigo());
            stmt.executeUpdate();
        }
    }

}
