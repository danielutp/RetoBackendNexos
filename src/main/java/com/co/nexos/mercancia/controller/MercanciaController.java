package com.co.nexos.mercancia.controller;

import com.co.nexos.mercancia.config.exceptions.BadRequestException;
import com.co.nexos.mercancia.domain.MercanciaDto;
import com.co.nexos.mercancia.service.MercanciaService;
import com.co.nexos.mercancia.utility.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api")
@RestController
public class MercanciaController {

    @Autowired
    private MercanciaService mercanciaService;

    private Response response = new Response();

    private HttpStatus httpStatus = HttpStatus.OK;

    @GetMapping(path = "/mercancias")
    public ResponseEntity<Response> listaMercacias() {
        response.restart();
        response.message = "La lista de mercancia es : ";
        response.data = mercanciaService.listaMercancias();
        httpStatus = HttpStatus.OK;
        return new ResponseEntity(response, httpStatus);
    }

    @GetMapping(path = "/mercancia/{id}")
    public ResponseEntity<Response> encontrarMercancia(@PathVariable(value = "id") Integer id) {
        response.restart();
        response.message = "La mercancia es : ";
        response.data = mercanciaService.findByIdMercancia(id);
        httpStatus = HttpStatus.OK;
        return new ResponseEntity(response, httpStatus);
    }

    @PostMapping(path = "/mercancia")
    public ResponseEntity<Response> crearMercancia(@RequestBody MercanciaDto mercanciaDto) {
        response.restart();
        try {
            mercanciaService.crearMercancia(mercanciaDto);
            response.message = "Mercancia creada";
            httpStatus = HttpStatus.CREATED;
            return new ResponseEntity(response, httpStatus);
        }catch (BadRequestException exception){
            response.error = true;
            response.message = "Error : " + exception.getMessage();
            httpStatus = HttpStatus.BAD_REQUEST;
            return new ResponseEntity(response,httpStatus);
        }catch (DataIntegrityViolationException ex){
            response.error = true;
            response.message = ex.getRootCause().getMessage();
            httpStatus = HttpStatus.BAD_REQUEST;
            return new ResponseEntity(response,httpStatus);
        }catch (Exception e){
            response.error = true;
            response.message = "Error : " + e.getMessage();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity(response,httpStatus);
        }
    }

    @PutMapping(path = "/mercancia/{id}/{idUser}")
    public ResponseEntity<Response> actualizarMercancia(
            @RequestBody MercanciaDto mercanciaDto,
            @PathVariable(value="id") Integer id,
            @PathVariable(value="idUser") Integer idUser) {
        response.restart();
        try {
            mercanciaService.actualizarMercancia(id,idUser, mercanciaDto);
            response.message = "Mercancia actualizada";
            httpStatus = HttpStatus.OK;
            return new ResponseEntity(response, httpStatus);
        }catch (BadRequestException exception){
            response.error = true;
            response.message = "Error : " + exception.getMessage();
            httpStatus = HttpStatus.BAD_REQUEST;
            return new ResponseEntity(response,httpStatus);
        }catch (DataIntegrityViolationException ex){
            response.error = true;
            response.message = ex.getRootCause().getMessage();
            httpStatus = HttpStatus.BAD_REQUEST;
            return new ResponseEntity(response,httpStatus);
        }catch (Exception e){
            response.error = true;
            response.message = "Error : " + e.getMessage();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity(response,httpStatus);
        }
    }

    @DeleteMapping(path = "/mercancia/{id}/{idUser}")
    public ResponseEntity<Response> borrarMercancia(
            @PathVariable(value="id") Integer id,
            @PathVariable(value="idUser") Integer idUser) {
        response.restart();
        try {
            mercanciaService.eliminarMercancia(id,idUser);
            httpStatus = HttpStatus.OK;
            return new ResponseEntity(response, httpStatus);
        }catch (BadRequestException exception){
            response.error = true;
            response.message = "Error : " + exception.getMessage();
            httpStatus = HttpStatus.BAD_REQUEST;
            return new ResponseEntity(response,httpStatus);
        }catch (DataIntegrityViolationException ex){
            response.error = true;
            response.message = ex.getRootCause().getMessage();
            httpStatus = HttpStatus.BAD_REQUEST;
            return new ResponseEntity(response,httpStatus);
        }catch (Exception e){
            response.error = true;
            response.message = "Error : " + e.getMessage();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity(response,httpStatus);
        }
    }
}