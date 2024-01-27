package tec.msw.gestsol.gestionsolcli.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tec.msw.gestsol.gestionsolcli.entity.Cliente;
import tec.msw.gestsol.gestionsolcli.repository.ClienteRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getCliente(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        cliente.setEstado("A");
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente updateCliente(Cliente cliente) {
        Cliente clienteDB = getCliente(cliente.getId_cliente());
        if (clienteDB == null){
            return null;
        }
        clienteDB.setEstado(cliente.getEstado());
        clienteDB.setContacto_principal(cliente.getContacto_principal());
        clienteDB.setCorreo_contacto(cliente.getCorreo_contacto());
        clienteDB.setFecha_baja(cliente.getFecha_baja());
        clienteDB.setFecha_inicio(cliente.getFecha_inicio());
        clienteDB.setLogo(cliente.getLogo());
        clienteDB.setNombre(cliente.getNombre());
        clienteDB.setTelefono_contacto(cliente.getTelefono_contacto());
        return clienteRepository.save(clienteDB);
    }

    @Override
    public String deleteCliente(Long id) {
        Cliente clienteDB = getCliente(id);
        if (clienteDB == null){
            return "No se encontro el cliente.";
        }

        clienteRepository.delete(clienteDB);
        return "Cliente eliminado correctamente.";
    }
}
