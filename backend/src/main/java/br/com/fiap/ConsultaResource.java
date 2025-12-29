package br.com.fiap;

import br.com.fiap.beans.Consulta;
import br.com.fiap.beans.Paciente;
import br.com.fiap.service.ConsultaService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.List;

@Path("/consulta")

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class ConsultaResource {

    private final ConsultaService consultaService = new ConsultaService();

    @GET
    public List<Consulta> listarConsultas() throws Exception {
        return consultaService.listarConsultas();
    }

    // revisar essa parte pq parece estranha
    @GET
    @Path("/{idPaciente}")
    public Consulta selecionarConsultasPorIdPaciente(@PathParam("idPaciente") int idPaciente) throws Exception {
        return consultaService.buscarConsultasPorPaciente(idPaciente);
    }

    @POST
    public Response cadastrar(Consulta consulta, @Context UriInfo uriInfo) throws Exception {
        consultaService.cadastrarConsulta(consulta);

        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(String.valueOf(consulta.getIdConsulta()));

        return Response.created(builder.build()).build();
    }

    @PUT
    @Path("/{idConsulta}")
    public Response atualizar(@PathParam("idConsulta") int idConsulta, Consulta consulta) throws Exception {
        consulta.setIdConsulta(idConsulta);
        consultaService.atualizarConsulta(consulta);
        return Response.ok().build();
    }


    @DELETE
    @Path("/{idConsulta}")
    public Response deletar(@PathParam("idConsulta") int idConsulta) throws Exception {
        consultaService.removerConsulta(idConsulta);
        return Response.noContent().build();
    }
}