package tec.msw.gestsol.gestionsolcli.service;

import tec.msw.gestsol.gestionsolcli.entity.Cliente;
import tec.msw.gestsol.gestionsolcli.entity.ProductoCia;
import tec.msw.gestsol.gestionsolcli.entity.ProyectoCliente;

import java.util.List;

public interface ProyectoClienteService {
    public List<ProyectoCliente> listAllProyectosClientes();
    public ProyectoCliente getProyectoCliente(Long id);
    public ProyectoCliente createProyectoCliente(ProyectoCliente proyecto_cliente);
    public ProyectoCliente updateProyectoCliente(ProyectoCliente proyecto_cliente);
    public String deleteProyectoCliente(Long id);
    public List<ProyectoCliente> findByProducto(ProductoCia producto_cia);
    public List<ProyectoCliente> findByCliente(Cliente cliente);
}
