package mx.unam.aragon.tsp.omar.pizzas.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.unam.aragon.tsp.omar.pizzas.businessLayer.TamanoBusinessLayer;
import mx.unam.aragon.tsp.omar.pizzas.dtos.TamanoDto;
import mx.unam.aragon.tsp.omar.pizzas.dtos.TamanoDtoIn;
import mx.unam.aragon.tsp.omar.pizzas.dtos.idDto;

@RestController
@RequestMapping("/api/v1/tamanos")
public class TamanoController {

    private TamanoBusinessLayer tamanoBusinessLayer;

    public TamanoController(TamanoBusinessLayer businessLayer) {
        this.tamanoBusinessLayer = businessLayer;
    }

    @GetMapping
    public ArrayList<TamanoDto> obtenerTodos() {
        return tamanoBusinessLayer.obtenerTodos();
    }

    @GetMapping("/{id}")
    public TamanoDto obtenerPorId(@PathVariable int id) {
        return tamanoBusinessLayer.obtenerPorId(id);
    }

    @PostMapping
    public idDto agregar(@RequestBody TamanoDtoIn tamanoDtoIn) {
        return tamanoBusinessLayer.agregar(tamanoDtoIn);
    }

    @PutMapping("/{id}")
    public void actualizar(@PathVariable int id, @RequestBody TamanoDtoIn tamanoDtoIn) {
        tamanoBusinessLayer.actualizar(id, tamanoDtoIn);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable int id) {
        tamanoBusinessLayer.borrar(id);
    }
}
