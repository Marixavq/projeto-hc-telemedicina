package br.com.fiap.dao;

import br.com.fiap.beans.Paciente;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
            // abre a conexao dentro do metodo
            minhaConexao = new ConexaoFactory().conexao();
            stmt = minhaConexao.prepareStatement
                    ("Insert into PACIENTE values (?, ?, ?, ?, ?, ?, ?)");

            stmt.setInt(1, paciente.getIdPaciente());
            stmt.setString(2, paciente.getNomePaciente());
            stmt.setDate(3, paciente.getDataNascimento());


            stmt.execute();
            return "Paciente cadastrado com sucesso!";

        } finally {
            if (stmt != null) stmt.close();
            if (minhaConexao != null && !minhaConexao.isClosed()) minhaConexao.close();
        }
    }
}
