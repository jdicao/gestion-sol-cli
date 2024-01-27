package tec.msw.gestsol.gestionsolcli.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tec.msw.gestsol.gestionsolcli.entity.PlanCliente;
import tec.msw.gestsol.gestionsolcli.entity.ProyectoCliente;

import java.util.List;

public interface PlanClienteRepository extends JpaRepository<PlanCliente, Long> {
    public List<PlanCliente> findByProyectoCliente(ProyectoCliente proyecto_cliente);
}
