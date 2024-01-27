package tec.msw.gestsol.gestionsolcli.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tec.msw.gestsol.gestionsolcli.entity.Cliente;
import tec.msw.gestsol.gestionsolcli.entity.ProyectoCliente;
import tec.msw.gestsol.gestionsolcli.entity.TipoSolicitud;
import tec.msw.gestsol.gestionsolcli.service.ProyectoClienteService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/proyectocliente")
public class ProyectoClienteController {

    @Autowired
    private ProyectoClienteService proyectoClienteService;

    @GetMapping
    public ResponseEntity<List<ProyectoCliente>> listProyectoCliente(@RequestParam(name = "clienteId", required = false) Long clienteId){
        List<ProyectoCliente> proyectoClientes = new ArrayList<>();
        if (clienteId == null){
          proyectoClientes = proyectoClienteService.listAllProyectosClientes();
        } else {
            proyectoClientes = proyectoClienteService.findByCliente(Cliente.builder().id_cliente(clienteId).build());
        }
        if (proyectoClientes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(proyectoClientes);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProyectoCliente> getProyectosCliente(@PathVariable("id") Long id){

        ProyectoCliente proyectoCliente = proyectoClienteService.getProyectoCliente(id);

        if (proyectoCliente == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(proyectoCliente);
    }

}
