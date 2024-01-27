package tec.msw.gestsol.gestionsolcli.service;

import tec.msw.gestsol.gestionsolcli.entity.Detalle_Adjunto;
import tec.msw.gestsol.gestionsolcli.entity.Solicitud;

import java.util.List;

public interface DetalleAdjuntoService
{
    public List<Detalle_Adjunto> listAllDetalleAdjuntos();
    public Detalle_Adjunto getDetalleAdjunto(Long id);
    public Detalle_Adjunto createDetalleAdjunto(Detalle_Adjunto detalle_adjunto);
    public Detalle_Adjunto updateDetalleAdjunto(Detalle_Adjunto detalle_adjunto);
    public String deleteDetalleAdjunto(Long id);
    public List<Detalle_Adjunto> findBySolicitud(Solicitud solicitud);
}
