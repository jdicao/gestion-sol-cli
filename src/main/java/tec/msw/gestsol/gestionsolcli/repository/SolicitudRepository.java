package tec.msw.gestsol.gestionsolcli.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tec.msw.gestsol.gestionsolcli.entity.PlanCliente;
import tec.msw.gestsol.gestionsolcli.entity.Solicitud;
import tec.msw.gestsol.gestionsolcli.entity.TipoSolicitud;

import java.util.List;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    public List<Solicitud> findByTipoSolicitud(TipoSolicitud tipo_solicitud);
    public List<Solicitud> findByPlanCliente(PlanCliente plan_cliente);
}
