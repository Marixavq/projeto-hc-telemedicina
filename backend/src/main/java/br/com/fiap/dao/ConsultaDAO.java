package br.com.fiap.dao;

import br.com.fiap.beans.Consulta;
import br.com.fiap.beans.Medico;
import br.com.fiap.beans.Paciente;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {

    private Connection minhaConexao;

    // Insert
    public void inserirConsulta(Consulta consulta) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = null;

        try {
            minhaConexao = new ConexaoFactory().conexao();
            stmt = minhaConexao.prepareStatement
                    ("Insert into CONSULTA (id_medico, id_paciente, data_hora, status) VALUES (?, ?, ?, ?)");

            stmt.setInt(1, consulta.getMedico().getIdMedico());
            stmt.setInt(2, consulta.getPaciente().getIdPaciente());
            stmt.setTimestamp(3, Timestamp.valueOf(consulta.getDataHora()));
            stmt.setString(4,consulta.getStatus());

            stmt.execute(); } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null && !minhaConexao.isClosed()) minhaConexao.close();
        }
    }

    // Delete
    public void deletarConsulta(int idConsulta) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = null;

        try {
            minhaConexao = new ConexaoFactory().conexao();
            stmt = minhaConexao.prepareStatement(
                    "Delete from CONSULTA where id_consulta = ?"
            );
            stmt.setInt(1, idConsulta);

            stmt.execute();

        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null && !minhaConexao.isClosed()) minhaConexao.close();
        }
    }

    // UpDate
    public void atualizarConsulta(Consulta consulta) throws SQLException, ClassNotFoundException {
        PreparedStatement stmt = null;
        try {
            minhaConexao = new ConexaoFactory().conexao();

            stmt = minhaConexao.prepareStatement(
                    "Update CONSULTA set id_medico = ?, id_paciente = ?, data_hora = ?, status = ? where id_consulta = ?"
            );

            stmt.setInt(1, consulta.getMedico().getIdMedico());
            stmt.setInt(2, consulta.getPaciente().getIdPaciente());
            stmt.setTimestamp(3, Timestamp.valueOf(consulta.getDataHora()));
            stmt.setString(4,consulta.getStatus());
            stmt.setInt(5,consulta.getIdConsulta());

            stmt.executeUpdate();

        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null && !minhaConexao.isClosed()) minhaConexao.close();
        }
    }

    // metodo mapear Consulta
    private Consulta mapearConsultas(ResultSet rs) throws SQLException {
        Consulta consulta = new Consulta();
        consulta.setIdConsulta(rs.getInt("id_consulta"));

        Medico medico = new Medico();
        medico.setIdMedico(rs.getInt("id_medico"));

        Paciente paciente = new Paciente();
        paciente.setIdPaciente(rs.getInt("id_paciente"));

        consulta.setMedico(medico);
        consulta.setPaciente(paciente);

        consulta.setDataHora(rs.getTimestamp("data_hora").toLocalDateTime());
        consulta.setStatus(rs.getString("status"));
        return consulta;
    }


    // Select
    public List<Consulta> listarConsultas() throws SQLException, ClassNotFoundException {
        List<Consulta> listaConsultas = new ArrayList<Consulta>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            minhaConexao = new ConexaoFactory().conexao();

            stmt = minhaConexao.prepareStatement("select id_consulta, id_medico, id_paciente, data_hora, status from CONSULTA");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Consulta consulta = mapearConsultas(rs);
                listaConsultas.add(consulta);
            }

            return listaConsultas;

        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (minhaConexao != null && !minhaConexao.isClosed()) minhaConexao.close();
        }
    }


    // Buscar consultas por IdPaciente
    public Consulta selecionarConsultasPorIdPaciente(int idPaciente) throws SQLException, ClassNotFoundException {
        List<Consulta> listaConsultas = new ArrayList<Consulta>();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            minhaConexao = new ConexaoFactory().conexao();

            stmt = minhaConexao.prepareStatement("select id_consulta, id_medico, id_paciente, data_hora, status from CONSULTA where id_paciente = ?");
            stmt.setInt(1, idPaciente);

            rs = stmt.executeQuery();

            while (rs.next()) {
                Consulta consulta = mapearConsultas(rs);
                listaConsultas.add(consulta);
            }

            return null;

        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (minhaConexao != null && !minhaConexao.isClosed()) minhaConexao.close(); // fecha Conexão
        }
    }


}
