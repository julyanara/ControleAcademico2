package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import domain.Secretario;
import domain.SexoEnum;

public class SecretarioDao {

    private Connection connection;

    public SecretarioDao(Connection connection) {
        this.connection = connection;
    }

    public void create(Secretario secretario) throws SQLException {
        String sql = "INSERT INTO secretarios (nome, email, senha, sexo, area, salario) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, secretario.getNome());
            stmt.setString(2, secretario.getEmail());
            stmt.setString(3, secretario.getSenha());
            stmt.setString(4, secretario.getSexo().name()); 
            stmt.setString(5, secretario.getÁrea());
            stmt.setFloat(6, secretario.getSalario());

            stmt.executeUpdate();

           
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    secretario.setCódigo(generatedKeys.getInt(1)); // Assume que Funcionario tem um método setCodigo()
                }
            }
        }
    }

    public Secretario read(Integer codigo) throws SQLException {
        String sql = "SELECT * FROM secretarios WHERE codigo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Secretario secretario = new Secretario(
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    SexoEnum.valueOf(rs.getString("sexo")), 
                    rs.getString("area"),
                    rs.getFloat("salario")
                );
                secretario.setCódigo(codigo);                 return secretario;
            }
        }
        return null;
    }
}

