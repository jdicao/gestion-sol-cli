package tec.msw.gestsol.gestionsolcli.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="TSR_DETALLE_ADJUNTO")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Detalle_Adjunto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_adjunto;
    //private Long id_solicitud;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_solicitud")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Solicitud solicitud;
    private String nombre_archivo;
    private String nombre_original;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha_carga;
}
