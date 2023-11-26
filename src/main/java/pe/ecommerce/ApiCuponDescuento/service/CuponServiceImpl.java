
package pe.ecommerce.ApiCuponDescuento.service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.ecommerce.ApiCuponDescuento.dao.CuponRepository;
import pe.ecommerce.ApiCuponDescuento.entity.Cupon;
import pe.ecommerce.ApiCuponDescuento.exception.EntityNotFoundException;

@Service
@Slf4j
public class CuponServiceImpl implements CuponService{
    @Autowired
    private CuponRepository cuponRepository;
    
    @Override
    public Cupon findByCodigo(String codigo) {
        log.info("Buscando Cupon...");
       return cuponRepository.findByCodigo(codigo);
    }

    @Override
    public Cupon agregar(Cupon cupon) {
        log.info("Agregando nuevo cupon...");
        return cuponRepository.save(cupon);
    }

    @Override
    public List<Cupon> buscarTodo() {
        log.info("Buscando Cupones registrados...");
       return (List<Cupon>) cuponRepository.findAll();
    }

    @Override
    public Cupon buscarPorId(Long cuponId) {
        log.info("Buscando Cupon...");
        return cuponRepository.findById(cuponId).orElseThrow(()-> new EntityNotFoundException("ID de cupon no encontrado" +cuponId.toString()));
    }

    @Override
    public Cupon actualizar(Cupon cupon) {
        log.info("Buscando Cupones registrados...");
        var CuponDB = cuponRepository.findById(cupon.getIdcupon()).get();
        CuponDB.setCodigo(cupon.getCodigo());
        CuponDB.setDescripcion(cupon.getDescripcion());
        CuponDB.setFechaVencimiento(cupon.getFechaVencimiento());
        CuponDB.setEstado(cupon.getEstado());
        return cuponRepository.save(CuponDB);
    }

    @Override
    public void eliminar(Long cuponId) {
        log.info("Eliminando Cupon...");
        var CuponBD = cuponRepository.findById(cuponId).get();
        cuponRepository.delete(CuponBD);
    }
    
}
