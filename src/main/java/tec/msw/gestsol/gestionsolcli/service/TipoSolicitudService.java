package tec.msw.gestsol.gestionsolcli.service;

import tec.msw.gestsol.gestionsolcli.entity.TipoSolicitud;

import java.util.List;

public interface TipoSolicitudService {
    public List<TipoSolicitud> listAllTiposSolicitud();
    public TipoSolicitud getTipoSolicitud(Long id);
    public TipoSolicitud createTipoSolicitud(TipoSolicitud tipo_solicitud);
    public TipoSolicitud updateTipoSolicitud(TipoSolicitud tipo_solicitud);
    public String deleteTipoSolicitud(Long id);
}
