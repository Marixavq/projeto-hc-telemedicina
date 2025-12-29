package br.com.fiap.service;

import br.com.fiap.beans.Consulta;
import br.com.fiap.beans.Paciente;
import br.com.fiap.dao.ConsultaDAO;
import br.com.fiap.dao.PacienteDAO;

import java.sql.SQLException;
import java.util.List;

public class ConsultaService {

    private ConsultaDAO consultaDAO = new ConsultaDAO();

    // Criar paciente
    public void cadastrarConsulta(Consulta consulta) throws ClassNotFoundException, SQLException {

        consultaDAO.inserirConsulta(consulta);
    }

    // Listar pacientes
    public List<Consulta> listarConsultas() throws ClassNotFoundException, SQLException {

        return consultaDAO.listarConsultas();
    }

    // Atualizar paciente
    public void atualizarConsulta(Consulta consulta) throws ClassNotFoundException, SQLException {
        consultaDAO.atualizarConsulta(consulta);
    }

    // Remover paciente
    public void removerConsulta(int idUsuario) throws ClassNotFoundException, SQLException {
        consultaDAO.deletarConsulta(idUsuario);
    }

    // Buscar por IdPaciente
    public Consulta buscarConsultasPorPaciente(int idPaciente) throws SQLException, ClassNotFoundException {
        return consultaDAO.selecionarConsultasPorIdPaciente(idPaciente);
    }

}
