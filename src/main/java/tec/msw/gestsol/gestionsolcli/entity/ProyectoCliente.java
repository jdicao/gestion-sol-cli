package tec.msw.gestsol.gestionsolcli.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="TCL_PROYECTO_CLIENTE")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProyectoCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_proyecto;
    //private Long id_producto;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ProductoCia productoCia;
    //private Long id_cliente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Cliente cliente;
    private String descripcion;
    private Date fecha_inicio;
    private Date fecha_fin;
    private String estado;
}
