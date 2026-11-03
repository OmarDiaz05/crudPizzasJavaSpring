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

import mx.unam.aragon.tsp.omar.pizzas.businessLayer.ClienteBusinessLayer;
import mx.unam.aragon.tsp.omar.pizzas.dtos.ClienteDto;
import mx.unam.aragon.tsp.omar.pizzas.dtos.ClienteDtoIn;
import mx.unam.aragon.tsp.omar.pizzas.dtos.idDto;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    private ClienteBusinessLayer clienteBusinessLayer;

    public ClienteController(ClienteBusinessLayer businessLayer) {
        this.clienteBusinessLayer = businessLayer;
    }

    @GetMapping
    public ArrayList<ClienteDto> obtenerTodos() {
        return clienteBusinessLayer.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ClienteDto obtenerPorId(@PathVariable int id) {
        return clienteBusinessLayer.obtenerPorId(id);
    }

    @PostMapping
    public idDto agregar(@RequestBody ClienteDtoIn clienteDtoIn) {
        return clienteBusinessLayer.agregar(clienteDtoIn);
    }

    @PutMapping("/{id}")
    public void actualizar(@PathVariable int id, @RequestBody ClienteDtoIn clienteDtoIn) {
        clienteBusinessLayer.actualizar(id, clienteDtoIn);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable int id) {
        clienteBusinessLayer.borrar(id);
    }
}
