package tec.msw.gestsol.gestionsolcli.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="TMC_CLIENTE")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cliente;
    private String identificacion;
    private String nombre;
    private String contacto_principal;
    private String correo_contacto;
    private String telefono_contacto;
    private Date fecha_inicio;
    private Date fecha_baja;
    private String logo;
    private String estado;
}
