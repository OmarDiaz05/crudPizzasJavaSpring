package mx.unam.aragon.tsp.omar.pizzas.businessLayer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import mx.unam.aragon.tsp.omar.pizzas.dtos.BebidaDto;
import mx.unam.aragon.tsp.omar.pizzas.dtos.BebidaDtoIn;
import mx.unam.aragon.tsp.omar.pizzas.dtos.idDto;

// Es la clase donde estan las reglas de negocio de Bebidas
@Service
public class BebidaBusinessLayer {

    // Lista en memoria persistente mientras la aplicación se encuentre en ejecución
    private final List<BebidaDto> bebidas = new ArrayList<>();
    private final AtomicInteger contadorId = new AtomicInteger(0);

    public BebidaBusinessLayer() {
        // Datos iniciales de prueba
        bebidas.add(new BebidaDto(contadorId.incrementAndGet(), "Coca-Cola", "Refresco de cola 600ml", 25));
        bebidas.add(new BebidaDto(contadorId.incrementAndGet(), "Agua Natural", "Agua purificada 500ml", 15));
    }

    public ArrayList<BebidaDto> obtenerTodas() {
        return new ArrayList<>(bebidas);
    }

    public idDto agregar(BebidaDtoIn bebidaDtoIn) {
        int nuevoId = contadorId.incrementAndGet();
        BebidaDto nuevaBebida = new BebidaDto(nuevoId, bebidaDtoIn.getNombre(), bebidaDtoIn.getDescripcion(), bebidaDtoIn.getPrecio());
        bebidas.add(nuevaBebida);
        return new idDto(nuevoId, "Bebida registrada con éxito");
    }

    public BebidaDto obtenerPorId(int id) {
        for (BebidaDto bebida : bebidas) {
            if (bebida.getId() == id) {
                return bebida;
            }
        }
        return null;
    }

    public void actualizar(int id, BebidaDtoIn bebidaDtoIn) {
        for (BebidaDto bebida : bebidas) {
            if (bebida.getId() == id) {
                bebida.setNombre(bebidaDtoIn.getNombre());
                bebida.setDescripcion(bebidaDtoIn.getDescripcion());
                bebida.setPrecio(bebidaDtoIn.getPrecio());
                break;
            }
        }
    }

    public void borrar(int id) {
        bebidas.removeIf(bebida -> bebida.getId() == id);
    }
}
