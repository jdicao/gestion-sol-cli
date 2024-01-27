package tec.msw.gestsol.gestionsolcli.service;

import tec.msw.gestsol.gestionsolcli.entity.PlanCliente;
import tec.msw.gestsol.gestionsolcli.entity.Solicitud;
import tec.msw.gestsol.gestionsolcli.entity.TipoSolicitud;

import java.util.List;

public interface SolicitudService {
    public List<Solicitud> listAllSolicitudes();
    public Solicitud getSolicitud(Long id);
    public Solicitud createSolicitud(Solicitud solicitud);
    public Solicitud updateSolicitud(Solicitud solicitud);
    public String deleteSolicitud(Long id);
    public List<Solicitud> findByTipoSolicitud(TipoSolicitud tipo_solicitud);
    public List<Solicitud> findByPlanCliente(PlanCliente plan_cliente);
    public String asignaConsultor(Long id, String consultor, String usuario);
}
