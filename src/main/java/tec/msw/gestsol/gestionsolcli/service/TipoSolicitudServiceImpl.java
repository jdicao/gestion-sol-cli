package tec.msw.gestsol.gestionsolcli.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tec.msw.gestsol.gestionsolcli.entity.TipoSolicitud;
import tec.msw.gestsol.gestionsolcli.repository.TipoSolicitudRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoSolicitudServiceImpl implements TipoSolicitudService{

    @Autowired
    private TipoSolicitudRepository tipoSolicitudRepository;

    @Override
    public List<TipoSolicitud> listAllTiposSolicitud() {
        return tipoSolicitudRepository.findAll();
    }

    @Override
    public TipoSolicitud getTipoSolicitud(Long id) {
        return tipoSolicitudRepository.findById(id).orElse(null);
    }

    @Override
    public TipoSolicitud createTipoSolicitud(TipoSolicitud tipo_solicitud) {
        tipo_solicitud.setFecha_actualizacion(new Date());
        return tipoSolicitudRepository.save(tipo_solicitud);
    }

    @Override
    public TipoSolicitud updateTipoSolicitud(TipoSolicitud tipo_solicitud) {
        TipoSolicitud tipo_solicitudDB = getTipoSolicitud(tipo_solicitud.getId_tipo_solicitud());
        if (tipo_solicitudDB == null){
            return null;
        }
        tipo_solicitudDB.setFecha_actualizacion(new Date());
        tipo_solicitudDB.setDescripcion(tipo_solicitud.getDescripcion());
        tipo_solicitudDB.setEstado(tipo_solicitud.getEstado());
        tipo_solicitudDB.setUsuario_actualizacion(tipo_solicitud.getUsuario_actualizacion());
        return tipoSolicitudRepository.save(tipo_solicitudDB);
    }

    @Override
    public String deleteTipoSolicitud(Long id) {
        TipoSolicitud tipo_solicitudDB = getTipoSolicitud(id);
        if (tipo_solicitudDB == null){
            return "No se encontró el tipo de solicitud enviado.";
        }
        tipoSolicitudRepository.delete(tipo_solicitudDB);
        return "Tipo de solicitud eliminada correctamente.";
    }
}
