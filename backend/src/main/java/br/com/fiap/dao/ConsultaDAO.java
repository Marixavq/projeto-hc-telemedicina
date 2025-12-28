package br.com.fiap.dao;

import br.com.fiap.beans.Consulta;
import br.com.fiap.beans.Paciente;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

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

}
