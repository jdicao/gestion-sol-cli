package tec.msw.gestsol.gestionsolcli.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="TCL_PLAN_CLIENTE")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PlanCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_plan;
    //private Long id_proyecto_cliente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_proyecto_cliente")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ProyectoCliente proyectoCliente;
    private String descripcion;
    private Double horas_contratadas;
    private Double horas_consumidas;
    private Double valor_hora;
    private Date ultimo_consumo;
    private Date fecha_contratacion;
    private Date fecha_fin;
    private String usuaro_registro;
}