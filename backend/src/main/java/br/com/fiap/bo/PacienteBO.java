package br.com.fiap.bo;

import br.com.fiap.beans.Paciente;
import br.com.fiap.dao.PacienteDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class PacienteBO {

    PacienteDAO pacienteDAO;

    // Selecionar
    public ArrayList<Paciente> selecionarPacienteBo() throws ClassNotFoundException, SQLException {
        pacienteDAO = new PacienteDAO();

        return (ArrayList<Paciente>) pacienteDAO.selecionarPaciente();
    }


}