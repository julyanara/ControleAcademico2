package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.Turma;

public class TurmaDao {

    private Connection connection;

    public TurmaDao(Connection connection) {
        this.connection = connection;
    }

    public void create(Turma turma) throws SQLException {
        String sql = "INSERT INTO turmas (nome, situacao, carga_horaria, curso_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, turma.getNome());
            stmt.setString(2, turma.getSituação());
            stmt.setString(3, turma.getCargaHorária());
            stmt.setInt(4, turma.getCurso().getId()); // Assume que Curso tem um método getId()
            stmt.executeUpdate();

            // Obter o código gerado
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    turma.setCódigo(generatedKeys.getInt(1));
                }
            }
        }
    }

    public Turma read(Integer codigo) throws SQLException {
        String sql = "SELECT * FROM turmas WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Turma turma = new Turma(
                    rs.getDate("data_mat").toLocalDate(), // Converta conforme necessário
                    rs.getString("nome"),
                    rs.getString("situacao"),
                    rs.getString("carga_horaria")
                );
                turma.setCódigo(rs.getInt("codigo"));
                // Aqui você pode buscar e definir a lista de disciplinas e o curso, se necessário
                return turma;
            }
        }
        return null;
    }

    public List<Turma> readAll() throws SQLException {
        List<Turma> turmas = new ArrayList<>();
        String sql = "SELECT * FROM turmas";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Turma turma = new Turma(
                    rs.getDate("data_mat").toLocalDate(), // Converta conforme necessário
                    rs.getString("nome"),
                    rs.getString("situacao"),
                    rs.getString("carga_horaria")
                );
                turma.setCódigo(rs.getInt("codigo"));
                turmas.add(turma);
            }
        }
        return turmas;
    }
}
