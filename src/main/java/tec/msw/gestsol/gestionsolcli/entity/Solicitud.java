package tec.msw.gestsol.gestionsolcli.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="TSR_SOLICITUD")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_solicitud;
    //private Long id_tipo_solicitud;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_solicitud")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private TipoSolicitud tipoSolicitud;
    //private Long id_plan_cliente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plan_cliente")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private PlanCliente planCliente;
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_registro;
    private String usuario_registro;
    private String medio_llegada;
    private String usr_funcional;
    private String dep_funcional;
    private String usr_tecnico;
    private String dep_tecnico;
    private String datos_equipo;
    private String todas_estaciones;
    private String detalle;
    private Date fecha_asignacion;
    private String usuario_asignacion;
    private String consultor_asignado;
    private String estado;
}
