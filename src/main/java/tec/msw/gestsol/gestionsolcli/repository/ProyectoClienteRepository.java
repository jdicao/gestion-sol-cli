package tec.msw.gestsol.gestionsolcli.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tec.msw.gestsol.gestionsolcli.entity.Cliente;
import tec.msw.gestsol.gestionsolcli.entity.ProductoCia;
import tec.msw.gestsol.gestionsolcli.entity.ProyectoCliente;

import java.util.List;

public interface ProyectoClienteRepository extends JpaRepository<ProyectoCliente, Long> {
    public List<ProyectoCliente> findByProductoCia(ProductoCia producto_cia);
    public List<ProyectoCliente> findByCliente(Cliente cliente);

}
