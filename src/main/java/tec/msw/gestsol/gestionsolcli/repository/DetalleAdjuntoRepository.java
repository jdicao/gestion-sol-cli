package tec.msw.gestsol.gestionsolcli.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tec.msw.gestsol.gestionsolcli.entity.Detalle_Adjunto;
import tec.msw.gestsol.gestionsolcli.entity.Solicitud;

import java.util.List;

public interface DetalleAdjuntoRepository extends JpaRepository<Detalle_Adjunto, Long> {
    public List<Detalle_Adjunto> findBySolicitud(Solicitud solicitud);
}
