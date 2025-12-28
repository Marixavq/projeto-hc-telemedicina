package br.com.fiap.service;

import br.com.fiap.beans.Paciente;
import br.com.fiap.dao.PacienteDAO;

import java.sql.SQLException;
import java.util.List;

public class PacienteService {

    private PacienteDAO pacienteDAO = new PacienteDAO();

    // Criar paciente
    public void cadastrarPaciente(Paciente paciente) throws ClassNotFoundException, SQLException {
        if (pacienteDAO.buscarPorEmail(paciente.getEmail()) != null) {
            throw new RuntimeException("Email já cadastrado");
        }

        pacienteDAO.inserirPaciente(paciente);
    }

    // Listar pacientes
    public List<Paciente> listarPacientes() throws ClassNotFoundException, SQLException {

        return pacienteDAO.listarPacientes();
    }

    // Atualizar paciente
    public void atualizarPaciente(Paciente paciente) throws ClassNotFoundException, SQLException {
        Paciente pacienteExistente = pacienteDAO.buscarPorEmail(paciente.getEmail());

        if (pacienteExistente != null && pacienteExistente.getIdPaciente() != paciente.getIdPaciente()) {
            throw new RuntimeException("Email já cadastrado!");
        }

        pacienteDAO.atualizarPaciente(paciente);
    }

    // Remover paciente
    public void removerPaciente(int idUsuario) throws ClassNotFoundException, SQLException {
        pacienteDAO.deletarPaciente(idUsuario);
    }

    // Buscar por ID
    public Paciente buscarPacientePorId(int idPaciente) throws SQLException, ClassNotFoundException {
        return pacienteDAO.selecionarPacientePorId(idPaciente);
    }

    // login
    public boolean verificarLogin(String email, String senha) throws SQLException, ClassNotFoundException {
        Paciente paciente = pacienteDAO.buscarPorEmail(email);

        if (paciente == null) {
            return false;
        }
        return paciente.getSenha().equals(senha);
    }


}
