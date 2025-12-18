package br.com.fiap.dao;

import br.com.fiap.beans.Paciente;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PacienteDAO {

    public Connection minhaConexao;

    // metodo construtor com parâmetro vazio
    public PacienteDAO() {
        super();
    }

    // Insert
    public String inserirPaciente(Paciente paciente) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = null;

        try {
            minhaConexao = new ConexaoFactory().conexao();
            stmt = minhaConexao.prepareStatement
                    ("Insert into PACIENTE values (?, ?, ?, ?, ?, ?, ?)");

            stmt.setString(1, paciente.getNomePaciente());
            stmt.setDate(2, java.sql.Date.valueOf(paciente.getDataNascimento()));
            stmt.setString(3,paciente.getCpf());
            stmt.setString(4,paciente.getRg());
            stmt.setString(5,paciente.getEmail());
            stmt.setString(6,paciente.getTelefone());
            stmt.setString(7,paciente.getSenha());

            stmt.execute();
            return "Paciente cadastrado com sucesso!";

        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null && !minhaConexao.isClosed()) minhaConexao.close();
        }
    }

    // Delete
    public String deletarPaciente(int idPaciente) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = null;

        try {
            minhaConexao = new ConexaoFactory().conexao();
            stmt = minhaConexao.prepareStatement(
                    "Delete from PACIENTE where ID_PACIENTE = ?"
            );
            stmt.setInt(1, idPaciente);

            stmt.execute();
            return "Paciente deletado com sucesso!";

        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null && !minhaConexao.isClosed()) minhaConexao.close();
        }
    }

    // UpDate
    public String atualizarPaciente(Paciente paciente) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = null;
        try {
            minhaConexao = new ConexaoFactory().conexao();

            stmt = minhaConexao.prepareStatement(
                    "Update PACIENTE set NOME_PACIENTE = ?, DATA_NASCIMENTO = ?, CPF = ?, RG = ?, EMAIL = ?, TELEFONE = ?, SENHA = ? where ID_PACIENTE = ?"
            );

            stmt.setString(1, paciente.getNomePaciente());
            stmt.setDate(2, java.sql.Date.valueOf(paciente.getDataNascimento()));
            stmt.setString(3, paciente.getCpf());
            stmt.setString(4, paciente.getRg());
            stmt.setString(5, paciente.getEmail());
            stmt.setString(6, paciente.getTelefone());
            stmt.setString(7, paciente.getSenha());
            stmt.setInt(8, paciente.getIdPaciente());

            stmt.executeUpdate();
            return "Paciente atualizado com sucesso!";

        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null && !minhaConexao.isClosed()) minhaConexao.close();
        }
    }


    // Buscar pelo email -> login
    public Paciente buscarPorEmail(String email) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            minhaConexao = new ConexaoFactory().conexao();

            stmt = minhaConexao.prepareStatement("select * from PACIENTE where EMAIL = ?");
            stmt.setString(1, email);

            rs = stmt.executeQuery();

            if (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setIdPaciente(rs.getInt(1));
                paciente.setNomePaciente(rs.getString(2));
                paciente.setDataNascimento(rs.getDate(3).toLocalDate());
                paciente.setCpf(rs.getString(4));
                paciente.setRg(rs.getString(5));
                paciente.setEmail(rs.getString(6));
                paciente.setTelefone(rs.getString(7));
                paciente.setSenha(rs.getString(8));

                return paciente;
            }
            return null;

        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (minhaConexao != null && !minhaConexao.isClosed()) minhaConexao.close(); // fecha Conexão
        }
    }

}
