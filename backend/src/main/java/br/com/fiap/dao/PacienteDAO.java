package br.com.fiap.dao;

import br.com.fiap.beans.Paciente;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    private Connection minhaConexao;

    // metodo construtor com parâmetro vazio
    public PacienteDAO() {
        super();
    }

    // Insert
    public void inserirPaciente(Paciente paciente) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = null;

        try {
            minhaConexao = new ConexaoFactory().conexao();
            stmt = minhaConexao.prepareStatement
                    ("Insert into PACIENTE (nome_paciente, data_nascimento, cpf, rg, email, telefone, senha) VALUES (?, ?, ?, ?, ?, ?, ?)");

            stmt.setString(1, paciente.getNomePaciente());
            stmt.setDate(2, java.sql.Date.valueOf(paciente.getDataNascimento()));
            stmt.setString(3,paciente.getCpf());
            stmt.setString(4,paciente.getRg());
            stmt.setString(5,paciente.getEmail());
            stmt.setString(6,paciente.getTelefone());
            stmt.setString(7,paciente.getSenha());

            stmt.execute();

        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null && !minhaConexao.isClosed()) minhaConexao.close();
        }
    }

    // Delete
    public void deletarPaciente(int idPaciente) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = null;

        try {
            minhaConexao = new ConexaoFactory().conexao();
            stmt = minhaConexao.prepareStatement(
                    "Delete from PACIENTE where ID_PACIENTE = ?"
            );
            stmt.setInt(1, idPaciente);

            stmt.execute();

        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null && !minhaConexao.isClosed()) minhaConexao.close();
        }
    }

    // UpDate
    public void atualizarPaciente(Paciente paciente) throws SQLException, ClassNotFoundException {
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

        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null && !minhaConexao.isClosed()) minhaConexao.close();
        }
    }


    // metodo mapear Paciente
    private Paciente mapearPaciente(ResultSet rs) throws SQLException {
        Paciente paciente = new Paciente();
        paciente.setIdPaciente(rs.getInt("id_paciente"));
        paciente.setNomePaciente(rs.getString("nome_paciente"));
        paciente.setDataNascimento(rs.getDate("data_nascimento").toLocalDate());
        paciente.setCpf(rs.getString("cpf"));
        paciente.setRg(rs.getString("rg"));
        paciente.setEmail(rs.getString("email"));
        paciente.setTelefone(rs.getString("telefone"));
        paciente.setSenha(rs.getString("senha"));
        return paciente;
    }

    // Select
    public List<Paciente> listarPacientes() throws SQLException, ClassNotFoundException {
        List<Paciente> listaPacientes = new ArrayList<Paciente>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            minhaConexao = new ConexaoFactory().conexao();

            stmt = minhaConexao.prepareStatement("select id_paciente, nome_paciente, data_nascimento, cpf, rg, email, telefone, senha from PACIENTE");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Paciente paciente = mapearPaciente(rs);
                listaPacientes.add(paciente);
            }

            return listaPacientes;

        } finally {
            if (rs != null) rs.close();// fecha ResultSet
            if (stmt != null) stmt.close();// fecha Statement
            if (minhaConexao != null && !minhaConexao.isClosed()) minhaConexao.close(); // fecha Conexão
        }
    }



    // Buscar pelo email -> login
    public Paciente buscarPorEmail(String email) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            minhaConexao = new ConexaoFactory().conexao();

            stmt = minhaConexao.prepareStatement("select id_paciente, nome_paciente, data_nascimento, cpf, rg, email, telefone, senha from PACIENTE where EMAIL = ?");
            stmt.setString(1, email);

            rs = stmt.executeQuery();

            if (rs.next()) {
                Paciente paciente = mapearPaciente(rs);

                return paciente;
            }
            return null;

        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (minhaConexao != null && !minhaConexao.isClosed()) minhaConexao.close(); // fecha Conexão
        }
    }



    // Buscar Paciente pelo ID
    public Paciente selecionarPacientePorId(int idPaciente) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            minhaConexao = new ConexaoFactory().conexao();

            stmt = minhaConexao.prepareStatement("select id_paciente, nome_paciente, data_nascimento, cpf, rg, email, telefone, senha from PACIENTE where ID_PACIENTE = ?");
            stmt.setInt(1, idPaciente);
            rs = stmt.executeQuery();

            if (rs.next()) {
                Paciente paciente = mapearPaciente(rs);

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
