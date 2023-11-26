
package pe.ecommerce.ApiCuponDescuento.controller;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.ecommerce.ApiCuponDescuento.entity.Cupon;
import pe.ecommerce.ApiCuponDescuento.service.CuponService;

@RestController
@Slf4j
@RequestMapping("api/v1/cupon") 
public class CuponController {
    
    @Autowired
    private CuponService cuponService;
     
    @GetMapping("/BuscarTodo")
    public ResponseEntity<List<Cupon>> buscarTodo() {
        log.info("Endpoint para buscar todos los cupones iniciado.");
        List<Cupon> cupones = cuponService.buscarTodo();
        log.info("Se encontraron {} cupones.", cupones.size());
        return new ResponseEntity<>(cupones, HttpStatus.OK);
    }

    @GetMapping("/BuscarPorId/{cuponId}")
    public ResponseEntity<Cupon> BuscarPorId(@PathVariable Long cuponId) {
        log.info("Endpoint para buscar cupón por ID iniciado. ID: {}", cuponId);
        Cupon cupon = cuponService.buscarPorId(cuponId);
        if (cupon != null) {
            log.info("Cupón encontrado: {}", cupon);
            return new ResponseEntity<>(cupon, HttpStatus.OK);
        } else {
            log.warn("No se encontró ningún cupón con ID: {}", cuponId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByCodigo/{codigo}")
    public ResponseEntity<Cupon> findByCodigo(@PathVariable String codigo) {
        log.info("Endpoint para buscar cupón por código iniciado. Código: {}", codigo);
        Cupon cupon = cuponService.findByCodigo(codigo);
        if (cupon != null) {
            log.info("Cupón encontrado: {}", cupon);
            return new ResponseEntity<>(cupon, HttpStatus.OK);
        } else {
            log.warn("No se encontró ningún cupón con código: {}", codigo);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/agregar")
    public ResponseEntity<Cupon> Agregar(@RequestBody Cupon cupon) {
        log.info("Endpoint para agregar un nuevo cupón iniciado. Nuevo cupón: {}", cupon);
        Cupon nuevoCupon = cuponService.agregar(cupon);
        log.info("Cupón agregado con éxito: {}", nuevoCupon);
        return new ResponseEntity<>(nuevoCupon, HttpStatus.CREATED);
    }

    @PutMapping("/Actualizar")
    public ResponseEntity<Cupon> Actualizar(@RequestBody Cupon cupon) {
        log.info("Endpoint para actualizar un cupón iniciado. Cupón a actualizar: {}", cupon);
        Cupon cuponActualizado = cuponService.actualizar(cupon);
        if (cuponActualizado != null) {
            log.info("Cupón actualizado con éxito: {}", cuponActualizado);
            return new ResponseEntity<>(cuponActualizado, HttpStatus.OK);
        } else {
            log.warn("No se pudo actualizar el cupón. Cupón no encontrado.");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/Eliminar/{cuponId}")
    public void Eliminar(@PathVariable Long cuponId) {
        log.info("Endpoint para eliminar cupón iniciado. ID a eliminar: {}", cuponId);
        cuponService.eliminar(cuponId);
        log.info("Cupón eliminado con éxito.");
    }
}

