package tec.msw.gestsol.gestionsolcli.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tec.msw.gestsol.gestionsolcli.entity.TipoSolicitud;
import tec.msw.gestsol.gestionsolcli.service.TipoSolicitudService;

import java.util.List;

@RestController
@RequestMapping(value = "/tiposolicitudes")
public class TipoSolicitudController {

    @Autowired
    private TipoSolicitudService tipoSolicitudService;

    @GetMapping
    public ResponseEntity<List<TipoSolicitud>> listTipoSolicitudes(){
      List<TipoSolicitud> tipo_solicitudes = tipoSolicitudService.listAllTiposSolicitud();

      if (tipo_solicitudes.isEmpty()){
          return ResponseEntity.noContent().build();
      }
      return ResponseEntity.ok(tipo_solicitudes);
    }
}
