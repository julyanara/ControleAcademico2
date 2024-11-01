package dao;

import domain.Projeto;

import java.sql.*;

public class ProjetoDao {

    private Connection connection;

    public ProjetoDao(Connection connection) {
        this.connection = connection;
    }

    public void create(Projeto projeto) throws SQLException {
        String sql = "INSERT INTO projetos (descricao, titulo, carga_horaria, valor_bolsa, professor_id) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, projeto.getDescrição());
            stmt.setString(2, projeto.getTítulo());
            stmt.setString(3, projeto.getCargaHorária());
            stmt.setFloat(4, projeto.getValorBolsa());
            stmt.setInt(5, projeto.getProfessores().getId());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    projeto.setCódigo(generatedKeys.getInt(1));
                }
            }
        }
    }

    public Projeto read(Integer codigo) throws SQLException {
        String sql = "SELECT * FROM projetos WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Projeto projeto = new Projeto(rs.getString("descricao"), rs.getString("titulo"),
                        rs.getString("carga_horaria"), rs.getFloat("valor_bolsa"));
                projeto.setCódigo(rs.getInt("codigo"));
                return projeto;
            }
        }
        return null;
    }

    public void update(Projeto projeto) throws SQLException {
        String sql = "UPDATE projetos SET descricao = ?, titulo = ?, carga_horaria = ?, valor_bolsa = ?, professor_id = ? WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, projeto.getDescrição());
            stmt.setString(2, projeto.getTítulo());
            stmt.setString(3, projeto.getCargaHorária());
            stmt.setFloat(4, projeto.getValorBolsa());
            stmt.setInt(5, projeto.getProfessores().getId());
            stmt.setInt(6, projeto.getCódigo());
            stmt.executeUpdate();
        }
    }
}
