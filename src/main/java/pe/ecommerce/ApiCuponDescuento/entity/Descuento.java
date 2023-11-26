
package pe.ecommerce.ApiCuponDescuento.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "descuento")
public class Descuento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long iddescuento;
    private String descuento;
    private BigDecimal valor;
    @OneToMany(mappedBy = "descuento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("descuento")
    private Set<Cupon> Cupon;    
}

