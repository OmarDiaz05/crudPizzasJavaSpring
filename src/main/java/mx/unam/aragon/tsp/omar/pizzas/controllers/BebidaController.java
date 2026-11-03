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

import mx.unam.aragon.tsp.omar.pizzas.businessLayer.BebidaBusinessLayer;
import mx.unam.aragon.tsp.omar.pizzas.dtos.BebidaDto;
import mx.unam.aragon.tsp.omar.pizzas.dtos.BebidaDtoIn;
import mx.unam.aragon.tsp.omar.pizzas.dtos.idDto;

@RestController
@RequestMapping("/api/v1/bebidas")
public class BebidaController {

    private BebidaBusinessLayer bebidaBusinessLayer;

    public BebidaController(BebidaBusinessLayer businessLayer) {
        this.bebidaBusinessLayer = businessLayer;
    }

    @GetMapping
    public ArrayList<BebidaDto> obtenerTodas() {
        return bebidaBusinessLayer.obtenerTodas();
    }

    @GetMapping("/{id}")
    public BebidaDto obtenerPorId(@PathVariable int id) {
        return bebidaBusinessLayer.obtenerPorId(id);
    }

    @PostMapping
    public idDto agregar(@RequestBody BebidaDtoIn bebidaDtoIn) {
        return bebidaBusinessLayer.agregar(bebidaDtoIn);
    }

    @PutMapping("/{id}")
    public void actualizar(@PathVariable int id, @RequestBody BebidaDtoIn bebidaDtoIn) {
        bebidaBusinessLayer.actualizar(id, bebidaDtoIn);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable int id) {
        bebidaBusinessLayer.borrar(id);
    }
}
