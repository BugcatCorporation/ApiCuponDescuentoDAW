
package pe.ecommerce.ApiCuponDescuento.service;

import java.util.List;
import pe.ecommerce.ApiCuponDescuento.entity.Cupon;


public interface CuponService {
    public List<Cupon> buscarTodo();
    public Cupon buscarPorId(Long cuponId);
     public Cupon agregar(Cupon cupon);
     public Cupon findByCodigo (String codigo );
     public Cupon actualizar(Cupon cupon);
     public void eliminar(Long cuponId);
}
