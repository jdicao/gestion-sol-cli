package tec.msw.gestsol.gestionsolcli.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tec.msw.gestsol.gestionsolcli.entity.Cliente;
import tec.msw.gestsol.gestionsolcli.entity.ProductoCia;
import tec.msw.gestsol.gestionsolcli.entity.ProyectoCliente;
import tec.msw.gestsol.gestionsolcli.repository.ProyectoClienteRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProyectoClienteServiceImpl implements ProyectoClienteService{

    @Autowired
    private ProyectoClienteRepository proyectoClienteRepository;

    @Override
    public List<ProyectoCliente> listAllProyectosClientes() {
        return proyectoClienteRepository.findAll();
    }

    @Override
    public ProyectoCliente getProyectoCliente(Long id) {
        return proyectoClienteRepository.findById(id).orElse(null);
    }

    @Override
    public ProyectoCliente createProyectoCliente(ProyectoCliente proyecto_cliente) {
        proyecto_cliente.setEstado("I");
        return proyectoClienteRepository.save(proyecto_cliente);
    }

    @Override
    public ProyectoCliente updateProyectoCliente(ProyectoCliente proyecto_cliente) {
        ProyectoCliente proyecto_clienteDB = getProyectoCliente(proyecto_cliente.getId_proyecto());
        if (proyecto_clienteDB == null){
            return null;
        }
        proyecto_clienteDB.setEstado(proyecto_cliente.getEstado());
        proyecto_clienteDB.setDescripcion(proyecto_cliente.getDescripcion());
        proyecto_clienteDB.setFecha_inicio(proyecto_cliente.getFecha_inicio());
        proyecto_clienteDB.setFecha_fin(proyecto_cliente.getFecha_fin());
        return proyectoClienteRepository.save(proyecto_clienteDB);
    }

    @Override
    public String deleteProyectoCliente(Long id) {
        ProyectoCliente proyecto_clienteDB = getProyectoCliente(id);
        if (proyecto_clienteDB == null){
            return "No se encontró el proyecto a eliminar";
        }
        proyectoClienteRepository.delete(proyecto_clienteDB);
        return "Proyecto eliminado correctamente.";
    }

    @Override
    public List<ProyectoCliente> findByProducto(ProductoCia producto_cia) {
        return proyectoClienteRepository.findByProductoCia(producto_cia);
    }

    @Override
    public List<ProyectoCliente> findByCliente(Cliente cliente) {
        return proyectoClienteRepository.findByCliente(cliente);
    }
}
