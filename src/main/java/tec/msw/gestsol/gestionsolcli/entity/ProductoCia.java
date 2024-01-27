package tec.msw.gestsol.gestionsolcli.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="GEN_PRODUCTO_CIA")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductoCia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_producto;
    private String nombre;
    private String descripcion;
    private String logo;
    private String estado;
}
