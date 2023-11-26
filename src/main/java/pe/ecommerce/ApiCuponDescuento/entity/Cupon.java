
package pe.ecommerce.ApiCuponDescuento.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cupon")
public class Cupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcupon ;
    private String codigo ;
    private String descripcion;
    private Date fechaVencimiento;
    private String estado;
    
    @ManyToOne
    @JoinColumn(name = "iddescuento")
    private Descuento descuento;
    
}
