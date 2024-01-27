package tec.msw.gestsol.gestionsolcli.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tec.msw.gestsol.gestionsolcli.entity.Cliente;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    //public List<Cliente>
}
