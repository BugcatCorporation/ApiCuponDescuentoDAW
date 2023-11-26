
package pe.ecommerce.ApiCuponDescuento.service;

import java.util.List;
import pe.ecommerce.ApiCuponDescuento.entity.Descuento;


public interface DescuentoService {
    
     public List<Descuento> buscarTodo();
     public Descuento buscarPorId(Long desId);
     public Descuento agregar(Descuento descuento);
     public Descuento actualizar(Descuento descuento);
     public void eliminar(Long desId);
}
