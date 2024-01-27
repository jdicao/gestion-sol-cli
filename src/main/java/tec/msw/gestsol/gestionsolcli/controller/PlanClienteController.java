package tec.msw.gestsol.gestionsolcli.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tec.msw.gestsol.gestionsolcli.entity.PlanCliente;
import tec.msw.gestsol.gestionsolcli.entity.ProyectoCliente;
import tec.msw.gestsol.gestionsolcli.service.PlanClienteService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/plancliente")
public class PlanClienteController {

    @Autowired
    private PlanClienteService planClienteService;

    @GetMapping
    public ResponseEntity<List<PlanCliente>> listPlanesClientes(@RequestParam(name = "proyectoId", required = false) Long proyectoId){
        List<PlanCliente> planClientes = new ArrayList<>();
        if (proyectoId == null){
            planClientes = planClienteService.listAllPlanesClientes();
        } else {
            planClientes = planClienteService.findByProyectoCliente(ProyectoCliente.builder().id_proyecto(proyectoId).build());
        }
        return ResponseEntity.ok(planClientes);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PlanCliente> getPlanCliente(@PathVariable("id") Long id){
        PlanCliente planCliente = planClienteService.getPlaCliente(id);
        if (planCliente == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(planCliente);
    }

}
