
package pe.ecommerce.ApiCuponDescuento.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.ecommerce.ApiCuponDescuento.entity.Cupon;


public interface CuponRepository extends JpaRepository<Cupon, Long>{
    
    Cupon findByCodigo (String codigo );
}
