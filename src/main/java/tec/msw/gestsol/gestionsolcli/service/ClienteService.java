package tec.msw.gestsol.gestionsolcli.service;

import tec.msw.gestsol.gestionsolcli.entity.Cliente;

import java.util.List;

public interface ClienteService {
    public List<Cliente> listAllClientes();
    public Cliente getCliente(Long id);
    public Cliente createCliente(Cliente cliente);
    public Cliente updateCliente(Cliente cliente);
    public String deleteCliente(Long id);
}
