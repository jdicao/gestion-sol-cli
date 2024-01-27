package tec.msw.gestsol.gestionsolcli.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tec.msw.gestsol.gestionsolcli.entity.PlanCliente;
import tec.msw.gestsol.gestionsolcli.entity.Solicitud;
import tec.msw.gestsol.gestionsolcli.entity.TipoSolicitud;
import tec.msw.gestsol.gestionsolcli.repository.SolicitudRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SolicitudServiceImpl implements SolicitudService{

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Override
    public List<Solicitud> listAllSolicitudes() {
        return solicitudRepository.findAll();
    }

    @Override
    public Solicitud getSolicitud(Long id) {
        return solicitudRepository.findById(id).orElse(null);
    }

    @Override
    public Solicitud createSolicitud(Solicitud solicitud) {
        solicitud.setFecha_registro(new Date());
        solicitud.setEstado("I"); //ingresada
        return solicitudRepository.save(solicitud);
    }

    @Override
    public Solicitud updateSolicitud(Solicitud solicitud) {
        Solicitud solicitudDB = getSolicitud(solicitud.getId_solicitud());
        if (solicitudDB == null){
            return null;
        }
        solicitudDB.setEstado(solicitud.getEstado());
        solicitudDB.setDatos_equipo(solicitud.getDatos_equipo());
        solicitudDB.setTipoSolicitud(solicitud.getTipoSolicitud());
        solicitudDB.setDep_funcional(solicitud.getDep_funcional());
        solicitudDB.setDep_tecnico(solicitud.getDep_tecnico());
        solicitudDB.setDetalle(solicitud.getDetalle());
        solicitudDB.setTodas_estaciones(solicitud.getTodas_estaciones());
        solicitudDB.setUsr_funcional(solicitud.getUsr_funcional());
        solicitudDB.setUsr_tecnico(solicitud.getUsr_tecnico());
        return solicitudRepository.save(solicitudDB);
    }

    @Override
    public String deleteSolicitud(Long id) {
        Solicitud solicitudDB = getSolicitud(id);
        if (solicitudDB == null){
            return "No se encontró la solicitud a eliminar";
        }
        if (solicitudDB.getEstado() != "I"){
            return "No se pueden eliminar solicitudes en proceso";
        }
        solicitudRepository.delete(solicitudDB);
        return "";
    }

    @Override
    public List<Solicitud> findByTipoSolicitud(TipoSolicitud tipo_solicitud) {
        return solicitudRepository.findByTipoSolicitud(tipo_solicitud);
    }

    @Override
    public List<Solicitud> findByPlanCliente(PlanCliente plan_cliente) {
        return solicitudRepository.findByPlanCliente(plan_cliente);
    }

    @Override
    public String asignaConsultor(Long id, String consultor, String usuario) {
        Solicitud solicitudDB = getSolicitud(id);
        if (solicitudDB == null){
            return "No se encontró la enviada";
        }
        solicitudDB.setUsuario_asignacion(usuario);
        solicitudDB.setConsultor_asignado(consultor);
        solicitudDB.setFecha_asignacion(new Date());
        solicitudRepository.save(solicitudDB);
        return "Consultor asignado correctamente";
    }
}
