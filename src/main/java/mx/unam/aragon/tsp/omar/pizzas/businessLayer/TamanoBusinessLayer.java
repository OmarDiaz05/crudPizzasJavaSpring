package mx.unam.aragon.tsp.omar.pizzas.businessLayer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import mx.unam.aragon.tsp.omar.pizzas.dtos.TamanoDto;
import mx.unam.aragon.tsp.omar.pizzas.dtos.TamanoDtoIn;
import mx.unam.aragon.tsp.omar.pizzas.dtos.idDto;

// Es la clase donde estan las reglas de negocio de Tamaños
@Service
public class TamanoBusinessLayer {

    // Lista en memoria persistente mientras la aplicación se encuentre en ejecución
    private final List<TamanoDto> tamanos = new ArrayList<>();
    private final AtomicInteger contadorId = new AtomicInteger(0);

    public TamanoBusinessLayer() {
        // Datos iniciales de prueba
        tamanos.add(new TamanoDto(contadorId.incrementAndGet(), "Chica", "Pizza de 20 cm"));
        tamanos.add(new TamanoDto(contadorId.incrementAndGet(), "Mediana", "Pizza de 30 cm"));
        tamanos.add(new TamanoDto(contadorId.incrementAndGet(), "Grande", "Pizza de 40 cm"));
    }

    public ArrayList<TamanoDto> obtenerTodos() {
        return new ArrayList<>(tamanos);
    }

    public idDto agregar(TamanoDtoIn tamanoDtoIn) {
        int nuevoId = contadorId.incrementAndGet();
        TamanoDto nuevoTamano = new TamanoDto(nuevoId, tamanoDtoIn.getNombre(), tamanoDtoIn.getDescripcion());
        tamanos.add(nuevoTamano);
        return new idDto(nuevoId, "Tamaño registrado con éxito");
    }

    public TamanoDto obtenerPorId(int id) {
        for (TamanoDto tamano : tamanos) {
            if (tamano.getId() == id) {
                return tamano;
            }
        }
        return null;
    }

    public void actualizar(int id, TamanoDtoIn tamanoDtoIn) {
        for (TamanoDto tamano : tamanos) {
            if (tamano.getId() == id) {
                tamano.setNombre(tamanoDtoIn.getNombre());
                tamano.setDescripcion(tamanoDtoIn.getDescripcion());
                break;
            }
        }
    }

    public void borrar(int id) {
        tamanos.removeIf(tamano -> tamano.getId() == id);
    }
}
