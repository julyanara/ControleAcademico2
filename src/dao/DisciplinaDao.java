package dao;

import domain.Disciplina;

import java.sql.*;

public class DisciplinaDao {

    private Connection connection;

    public DisciplinaDao(Connection connection) {
        this.connection = connection;
    }

    public void create(Disciplina disciplina) throws SQLException {
        String sql = "INSERT INTO disciplinas (codigo, nome, situacao, carga_horaria, professor_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, disciplina.getCódigo());
            stmt.setString(2, disciplina.getNome());
            stmt.setString(3, disciplina.getSituação());
            stmt.setString(4, disciplina.getCargaHorária());
            stmt.setInt(5, disciplina.getProfessor().getId()); 
            stmt.executeUpdate();
        }
    }

    public Disciplina read(Integer codigo) throws SQLException {
        String sql = "SELECT * FROM disciplinas WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Disciplina(new Date(codigo), rs.getString("nome"), rs.getString("situacao"),
                                rs.getString("carga_horaria"), null);
            }
        }
        return null;
    }

    public void update(Disciplina disciplina) throws SQLException {
        String sql = "UPDATE disciplinas SET nome = ?, situacao = ?, carga_horaria = ?, professor_id = ? WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, disciplina.getNome());
            stmt.setString(2, disciplina.getSituação());
            stmt.setString(3, disciplina.getCargaHorária());
            stmt.setInt(4, disciplina.getProfessor().getId());
            stmt.setInt(5, disciplina.getCódigo());
            stmt.executeUpdate();
        }
    }
}

