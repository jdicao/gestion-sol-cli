package tec.msw.gestsol.gestionsolcli.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="TMS_TIPO_SOLICITUD")
@AllArgsConstructor @NoArgsConstructor
@Data
public class TipoSolicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipo_solicitud;
    private String descripcion;
    private String estado;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_actualizacion;
    private String usuario_actualizacion;
}
