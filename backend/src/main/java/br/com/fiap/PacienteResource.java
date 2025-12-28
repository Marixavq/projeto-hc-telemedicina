package br.com.fiap;

import br.com.fiap.beans.Paciente;
import br.com.fiap.dto.LoginRequest;
import br.com.fiap.service.PacienteService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.List;


@Path("/paciente")

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class PacienteResource {

    private final PacienteService pacienteService = new PacienteService();

    @GET
    public List<Paciente> listarPacientes() throws Exception {
        return pacienteService.listarPacientes();
    }

    @GET
    @Path("/{idPaciente}")
    public Paciente selecionarPacientePorId(@PathParam("idPaciente") int idPaciente) throws Exception {
        return pacienteService.buscarPacientePorId(idPaciente);
    }

    @POST
    public Response cadastrar(Paciente paciente, @Context UriInfo uriInfo) throws Exception {
        pacienteService.cadastrarPaciente(paciente);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(String.valueOf(paciente.getIdPaciente()));

        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{idPaciente}")
    public Response atualizar(@PathParam("idPaciente") int idPaciente, Paciente paciente) throws Exception {
        paciente.setIdPaciente(idPaciente);
        pacienteService.atualizarPaciente(paciente);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{idPaciente}")
    public Response deletar(@PathParam("idPaciente") int idPaciente) throws Exception {
        pacienteService.removerPaciente(idPaciente);
        return Response.noContent().build();
    }

    // Login
    @POST
    @Path("/login")
    public Response login(LoginRequest request) throws Exception {

        boolean ok = pacienteService.verificarLogin(
                request.getEmail(),
                request.getSenha()
        );

        if (!ok) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        return Response.ok().build();
    }




}