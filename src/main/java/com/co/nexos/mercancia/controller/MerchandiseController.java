package com.co.nexos.mercancia.controller;

import com.co.nexos.mercancia.config.exceptions.BadRequestException;
import com.co.nexos.mercancia.dtos.MerchandiseDto;
import com.co.nexos.mercancia.service.MerchandiseService;
import com.co.nexos.mercancia.utility.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RequestMapping("/api")
@RestController
public class MerchandiseController {

    @Autowired
    private MerchandiseService mercanciaService;

    private final Response response = new Response();
    String error = "Error : ";

    private HttpStatus httpStatus = HttpStatus.OK;

    @GetMapping(path = "/mercancias")
    public ResponseEntity<Response> listMerchadise() {
        response.restart();
        response.message = "La lista de mercancia es : ";
        response.data = mercanciaService.listMerchandise();
        httpStatus = HttpStatus.OK;
        return new ResponseEntity<>(response, httpStatus);
    }

    @GetMapping(path = "/mercancia/{id}")
    public ResponseEntity<Response> findByIdMercancia(@PathVariable(value = "id") Integer id) {
        response.restart();
        response.message = "La mercancia es : ";
        response.data = mercanciaService.findByIdMerchandise(id);
        httpStatus = HttpStatus.OK;
        return new ResponseEntity<>(response, httpStatus);
    }

    @PostMapping(path = "/mercancia")
    public ResponseEntity<Response> createMerchandise(@RequestBody MerchandiseDto merchandiseDto) {
        response.restart();
        try {
            mercanciaService.createMerchandise(merchandiseDto);
            response.message = "Mercancia creada";
            httpStatus = HttpStatus.CREATED;
            return new ResponseEntity<>(response, httpStatus);
        }catch (BadRequestException exception){
            response.error = true;
            response.message = error + exception.getMessage();
            httpStatus = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(response,httpStatus);
        }catch (DataIntegrityViolationException ex){
            response.error = true;
            response.message = Objects.requireNonNull(ex.getRootCause()).getMessage();
            httpStatus = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(response,httpStatus);
        }catch (Exception e){
            response.error = true;
            response.message = error + e.getMessage();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<>(response,httpStatus);
        }
    }

    @PutMapping(path = "/mercancia/{id}/{idUser}")
    public ResponseEntity<Response> updateMerchandise(
            @RequestBody MerchandiseDto merchandiseDto,
            @PathVariable(value="id") Integer id,
            @PathVariable(value="idUser") Integer idUser) {
        response.restart();
        try {
            mercanciaService.updateMerchandise(id,idUser, merchandiseDto);
            response.message = "Mercancia actualizada";
            httpStatus = HttpStatus.OK;
            return new ResponseEntity<>(response, httpStatus);
        }catch (BadRequestException exception){
            response.error = true;
            response.message = error + exception.getMessage();
            httpStatus = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(response,httpStatus);
        }catch (DataIntegrityViolationException ex){
            response.error = true;
            response.message = Objects.requireNonNull(ex.getRootCause()).getMessage();
            httpStatus = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(response,httpStatus);
        }catch (Exception e){
            response.error = true;
            response.message = error + e.getMessage();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<>(response,httpStatus);
        }
    }

    @GetMapping(path = "/mercancia/name/{dataToSearch}")
    public ResponseEntity<Response> findByNameMerchandise(
            @PathVariable(value="dataToSearch") String dataToSearch){
        response.restart();
        try {
            response.data = mercanciaService.findMerchandiseName(dataToSearch);
            httpStatus = HttpStatus.OK;
            return new ResponseEntity<>(response, httpStatus);
        } catch (BadRequestException exception) {
            response.error = true;
            response.message = error + exception.getMessage();
            httpStatus = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(response, httpStatus);
        } catch (DataIntegrityViolationException ex) {
            response.error = true;
            response.message = Objects.requireNonNull(ex.getRootCause()).getMessage();
            httpStatus = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(response, httpStatus);
        } catch (Exception e) {
            response.error = true;
            response.message = error + e.getMessage();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<>(response, httpStatus);
        }
    }

    @DeleteMapping(path = "/mercancia/{id}/{idUser}")
    public ResponseEntity<Response> borrarMercancia(
            @PathVariable(value="id") Integer id,
            @PathVariable(value="idUser") Integer idUser) {
        response.restart();
        try {
            response.data= mercanciaService.deleteMerchandise(id,idUser);
            httpStatus = HttpStatus.OK;
            return new ResponseEntity<>(response, httpStatus);
        }catch (BadRequestException exception){
            response.error = true;
            response.message = error + exception.getMessage();
            httpStatus = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(response,httpStatus);
        }catch (DataIntegrityViolationException ex){
            response.error = true;
            response.message = Objects.requireNonNull(ex.getRootCause()).getMessage();
            httpStatus = HttpStatus.BAD_REQUEST;
            return new ResponseEntity<>(response,httpStatus);
        }catch (Exception e){
            response.error = true;
            response.message = error + e.getMessage();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<>(response,httpStatus);
        }
    }
}