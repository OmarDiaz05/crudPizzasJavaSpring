package mx.unam.aragon.tsp.omar.pizzas.businessLayer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import mx.unam.aragon.tsp.omar.pizzas.dtos.PizzaDto;
import mx.unam.aragon.tsp.omar.pizzas.dtos.PizzaDtoIn;
import mx.unam.aragon.tsp.omar.pizzas.dtos.idDto;

// Es la clase donde estan las reglas de negocio
@Service 
public class PizzasBusinessLayer {

    // Lista en memoria persistente mientras la aplicación se encuentre en ejecución
    private final List<PizzaDto> pizzas = new ArrayList<>();
    private final AtomicInteger contadorId = new AtomicInteger(0);

    public PizzasBusinessLayer() {
        // Datos iniciales de prueba
        pizzas.add(new PizzaDto(contadorId.incrementAndGet(), "Hawaiana", "Jamon,Piña y Queso", 120));
        pizzas.add(new PizzaDto(contadorId.incrementAndGet(), "Mexicana", "Jalapeño, Carne Molida y Queso", 150));
    }

    public ArrayList<PizzaDto> obtenerTodas() {
        return new ArrayList<>(pizzas);
    }

    public idDto Agregar(PizzaDtoIn pizzaDtoIn) {
        int nuevoId = contadorId.incrementAndGet();
        PizzaDto nuevaPizza = new PizzaDto(nuevoId, pizzaDtoIn.getNombre(), pizzaDtoIn.getDescripcion(), pizzaDtoIn.getPrecio());
        pizzas.add(nuevaPizza);
        return new idDto(nuevoId, "Pizza registrada con éxito");
    }

    public idDto agregar(PizzaDtoIn pizzaDtoIn) {
        return Agregar(pizzaDtoIn);
    }

    public PizzaDto obtenerPorId(int id) {
        for (PizzaDto pizza : pizzas) {
            if (pizza.getId() == id) {
                return pizza;
            }
        }
        return null;
    }

    public void actualizar(int id, PizzaDtoIn pizzaDtoIn) {
        for (PizzaDto pizza : pizzas) {
            if (pizza.getId() == id) {
                pizza.setNombre(pizzaDtoIn.getNombre());
                pizza.setDescripcion(pizzaDtoIn.getDescripcion());
                pizza.setPrecio(pizzaDtoIn.getPrecio());
                break;
            }
        }
    }

    public void borrar(int id) {
        pizzas.removeIf(pizza -> pizza.getId() == id);
    }
}
