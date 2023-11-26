package pe.ecommerce.ApiCuponDescuento.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.ecommerce.ApiCuponDescuento.entity.Descuento;
import pe.ecommerce.ApiCuponDescuento.service.DescuentoService;

@RestController
@Slf4j
@RequestMapping("api/v1/Descuento")
public class DescuentoController {

    @Autowired
    private DescuentoService descuentoService;

    @GetMapping("/BuscarTodo")
    public ResponseEntity<List<Descuento>> buscarTodo() {
        log.info("Solicitando todos los descuentos");
        List<Descuento> descuentos = descuentoService.buscarTodo();
        log.info("Se encontraron {} descuentos", descuentos.size());
        return new ResponseEntity<>(descuentos, HttpStatus.OK);
    }

    @GetMapping("/BuscarPorId/{desId}")
    public ResponseEntity<Descuento> buscarPorId(@PathVariable Long desId) {
        log.info("Solicitando descuento con ID: {}", desId);
        Descuento descuento = descuentoService.buscarPorId(desId);
        log.info("Descuento encontrado: {}", descuento);
        return new ResponseEntity<>(descuento, HttpStatus.OK);
    }

    @PostMapping("/agregar")
    public ResponseEntity<Descuento> agregar(@RequestBody Descuento descuento) {
        log.info("Agregando un nuevo descuento: {}", descuento);
        Descuento nuevoDescuento = descuentoService.agregar(descuento);
        log.info("Descuento agregado exitosamente: {}", nuevoDescuento);
        return new ResponseEntity<>(nuevoDescuento, HttpStatus.CREATED);
    }

    @PutMapping("/Actualizar")
    public ResponseEntity<Descuento> actualizar(@RequestBody Descuento descuento) {
        log.info("Actualizando descuento con ID: {}", descuento.getIddescuento());
        Descuento descuentoActualizado = descuentoService.actualizar(descuento);
        log.info("Descuento actualizado exitosamente: {}", descuentoActualizado);
        return new ResponseEntity<>(descuentoActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/Eliminar/{desId}")
    public void eliminar(@PathVariable Long desId) {
        log.info("Eliminando descuento con ID: {}", desId);
        descuentoService.eliminar(desId);
        log.info("Descuento con ID {} eliminado exitosamente", desId);
    }
}
