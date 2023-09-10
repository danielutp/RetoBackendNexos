package com.co.nexos.mercancia.controller;

import com.co.nexos.mercancia.domain.Mercancia;
import com.co.nexos.mercancia.service.MercanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class MercanciaController {

    @Autowired
    private MercanciaService mercanciaService;

    @GetMapping(path = "/mercancias")
    public List<Mercancia> listaMercacias() {
        return mercanciaService.listaMercancias();
    }

    @GetMapping(path = "/team/mercancia/{id}")
    public Mercancia findMercancia(@PathVariable(value = "id") Integer id) {
       return mercanciaService.findByIdMercancia(id);
    }

    @PostMapping(path = "/mercancia")
    public Mercancia crearMercancia(@RequestBody Mercancia mercansia) {
        return mercanciaService.crearMercancia(mercansia);
    }

    @PutMapping(path = "/mercancia/{id}")
    public Mercancia actualizarMercancia(
            @RequestBody Mercancia mercancia,
            @PathVariable(value="id") Integer id ) {
        return mercanciaService.actualizarMercancia(id, mercancia);
    }

    @DeleteMapping(path = "/mercancia/{id}")
    public Mercancia deleteMercancia(@PathVariable(value="id") Integer id) {
        return mercanciaService.eliminarMercancia(id);
    }

}