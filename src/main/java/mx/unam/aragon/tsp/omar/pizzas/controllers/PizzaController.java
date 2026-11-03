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

import mx.unam.aragon.tsp.omar.pizzas.businessLayer.PizzasBusinessLayer;
import mx.unam.aragon.tsp.omar.pizzas.dtos.PizzaDto;
import mx.unam.aragon.tsp.omar.pizzas.dtos.PizzaDtoIn;
import mx.unam.aragon.tsp.omar.pizzas.dtos.idDto;

@RestController
@RequestMapping("/api/v1/pizzas")
public class PizzaController {

    private PizzasBusinessLayer pizzasBusinessLayer;

    public PizzaController(PizzasBusinessLayer businessLayer) {
        this.pizzasBusinessLayer = businessLayer;
    }

    @GetMapping
    public ArrayList<PizzaDto> obtenerTodas() {
        return pizzasBusinessLayer.obtenerTodas();
    }

    @GetMapping("/{id}")
    public PizzaDto obtenerPorId(@PathVariable int id) {
        return pizzasBusinessLayer.obtenerPorId(id);
    }

    @PostMapping
    public idDto agregar(@RequestBody PizzaDtoIn pizzaDtoIn) {
        return pizzasBusinessLayer.Agregar(pizzaDtoIn);
    }

    @PutMapping("/{id}")
    public void actualizar(@PathVariable int id, @RequestBody PizzaDtoIn pizzaDtoIn) {
        pizzasBusinessLayer.actualizar(id, pizzaDtoIn);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable int id) {
        pizzasBusinessLayer.borrar(id);
    }
}
