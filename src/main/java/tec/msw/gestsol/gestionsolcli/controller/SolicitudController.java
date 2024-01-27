package tec.msw.gestsol.gestionsolcli.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tec.msw.gestsol.gestionsolcli.entity.PlanCliente;
import tec.msw.gestsol.gestionsolcli.entity.Solicitud;
import tec.msw.gestsol.gestionsolcli.service.SolicitudService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/solicitud")
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;

    @GetMapping
    public ResponseEntity<List<Solicitud>> listSolicitud(@RequestParam(name = "planClienteId", required = false) Long planClienteId){
        List<Solicitud> solicitudList = new ArrayList<>();
        if (planClienteId == null){
            solicitudList = solicitudService.listAllSolicitudes();
        } else {
            solicitudList = solicitudService.findByPlanCliente(PlanCliente.builder().id_plan(planClienteId).build());
        }
        if (solicitudList.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(solicitudList);
    }

    @GetMapping(value = "/{id}")
    public  ResponseEntity<Solicitud> getSolicitud(@PathVariable("id") Long id){
        Solicitud solicitud = solicitudService.getSolicitud(id);
        if (solicitud == null){
            return ResponseEntity.noContent().build();
        }
        return  ResponseEntity.ok(solicitud);
    }

    //Creacion de solicitud
    @PostMapping
    public ResponseEntity<Solicitud> createSolicitud(@RequestBody Solicitud solicitud){
        Solicitud solicitudCreada = solicitudService.createSolicitud(solicitud);
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitudCreada);
    }

    //eliminar solicitud
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteSolicitud(@PathVariable("id") Long id){
        String respuesta = solicitudService.deleteSolicitud(id);
        if (respuesta != ""){
            return new ResponseEntity<>(respuesta, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok("Solicitud eliminada correctamente.");
    }

}
