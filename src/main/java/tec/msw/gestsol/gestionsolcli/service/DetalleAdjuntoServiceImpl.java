package tec.msw.gestsol.gestionsolcli.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tec.msw.gestsol.gestionsolcli.entity.Detalle_Adjunto;
import tec.msw.gestsol.gestionsolcli.entity.Solicitud;
import tec.msw.gestsol.gestionsolcli.repository.DetalleAdjuntoRepository;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DetalleAdjuntoServiceImpl implements DetalleAdjuntoService{

    @Autowired
    private DetalleAdjuntoRepository detalleAdjuntoRepository;

    @Override
    public List<Detalle_Adjunto> listAllDetalleAdjuntos() {
        return detalleAdjuntoRepository.findAll();
    }

    @Override
    public Detalle_Adjunto getDetalleAdjunto(Long id) {
        return detalleAdjuntoRepository.findById(id).orElse(null);
    }

    @Override
    public Detalle_Adjunto createDetalleAdjunto(Detalle_Adjunto detalle_adjunto) {
        detalle_adjunto.setFecha_carga(new Date());
        return detalleAdjuntoRepository.save(detalle_adjunto);
    }

    @Override
    public Detalle_Adjunto updateDetalleAdjunto(Detalle_Adjunto detalle_adjunto) {
        Detalle_Adjunto detalleAdjuntoDB = getDetalleAdjunto(detalle_adjunto.getId_adjunto());
        if(detalleAdjuntoDB == null){
            return null;
        }
        detalleAdjuntoDB.setNombre_archivo(detalle_adjunto.getNombre_archivo());
        detalleAdjuntoDB.setNombre_original(detalle_adjunto.getNombre_original());
        return detalleAdjuntoRepository.save(detalleAdjuntoDB);
    }

    @Override
    public String deleteDetalleAdjunto(Long id) {
        Detalle_Adjunto detalleAdjuntoDB = getDetalleAdjunto(id);
        if(detalleAdjuntoDB == null){
            return "No se encontró el detalle adjunto a eliminar.";
        }
        detalleAdjuntoRepository.delete(detalleAdjuntoDB);
        return "Detalle adjunto eliminado correctamente";
    }

    @Override
    public List<Detalle_Adjunto> findBySolicitud(Solicitud solicitud) {
        return detalleAdjuntoRepository.findBySolicitud(solicitud);
    }
}
