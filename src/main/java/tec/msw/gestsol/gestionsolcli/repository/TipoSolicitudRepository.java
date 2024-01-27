package tec.msw.gestsol.gestionsolcli.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tec.msw.gestsol.gestionsolcli.entity.TipoSolicitud;

public interface TipoSolicitudRepository extends JpaRepository<TipoSolicitud, Long> {
}
