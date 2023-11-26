package pe.ecommerce.ApiCuponDescuento.service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.ecommerce.ApiCuponDescuento.dao.DescuentoRepository;
import pe.ecommerce.ApiCuponDescuento.entity.Descuento;
import pe.ecommerce.ApiCuponDescuento.exception.EntityNotFoundException;

@Service
@Slf4j
public class DescuentoServiceImpl implements DescuentoService {

    @Autowired
    private DescuentoRepository descuentoRepository;

    @Override
    public List<Descuento> buscarTodo() {
        log.info("Recuperando todos los descuentos");
        return (List<Descuento>) descuentoRepository.findAll();
    }

    @Override
    public Descuento buscarPorId(Long desId) {
        log.info("Buscando descuento con ID: {}", desId);
        return descuentoRepository.findById(desId)
                .orElseThrow(() -> {
                    log.error("Descuento con ID {} no encontrado", desId);
                    return new EntityNotFoundException("ID de Descuento no encontrado" + desId.toString());
                });
    }

    @Override
    public Descuento agregar(Descuento descuento) {
        log.info("Añadiendo un nuevo descuento: {}", descuento);
        return descuentoRepository.save(descuento);
    }

    @Override
    public Descuento actualizar(Descuento descuento) {
        log.info("Actualizando descuento con ID: {}", descuento.getIddescuento());
        var DescuentoBD = descuentoRepository.findById(descuento.getIddescuento()).get();
        DescuentoBD.setDescuento(descuento.getDescuento());
        DescuentoBD.setValor(descuento.getValor());
        return descuentoRepository.save(DescuentoBD);
    }

    @Override
    public void eliminar(Long desId) {
        log.info("Eliminando descuento con ID: {}", desId);
        var DescuentoBD = descuentoRepository.findById(desId).get();
        descuentoRepository.delete(DescuentoBD);
        log.info("Descuento con ID {} eliminado exitosamente", desId);
    }

}
