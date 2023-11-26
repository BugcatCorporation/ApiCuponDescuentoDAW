

package pe.ecommerce.ApiCuponDescuento.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.ecommerce.ApiCuponDescuento.entity.Descuento;


public interface DescuentoRepository extends JpaRepository<Descuento, Long>{
    
}
