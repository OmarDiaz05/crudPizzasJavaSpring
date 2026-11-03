package mx.unam.aragon.tsp.omar.pizzas.businessLayer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import mx.unam.aragon.tsp.omar.pizzas.dtos.ClienteDto;
import mx.unam.aragon.tsp.omar.pizzas.dtos.ClienteDtoIn;
import mx.unam.aragon.tsp.omar.pizzas.dtos.idDto;

// Es la clase donde estan las reglas de negocio de Clientes
@Service
public class ClienteBusinessLayer {

    // Lista en memoria persistente mientras la aplicación se encuentre en ejecución
    private final List<ClienteDto> clientes = new ArrayList<>();
    private final AtomicInteger contadorId = new AtomicInteger(0);

    public ClienteBusinessLayer() {
        // Datos iniciales de prueba
        clientes.add(new ClienteDto(contadorId.incrementAndGet(), "Juan Pérez", "5551234567", "Av. Insurgentes 100"));
        clientes.add(new ClienteDto(contadorId.incrementAndGet(), "María López", "5559876543", "Calle Reforma 200"));
    }

    public ArrayList<ClienteDto> obtenerTodos() {
        return new ArrayList<>(clientes);
    }

    public idDto agregar(ClienteDtoIn clienteDtoIn) {
        int nuevoId = contadorId.incrementAndGet();
        ClienteDto nuevoCliente = new ClienteDto(nuevoId, clienteDtoIn.getNombre(), clienteDtoIn.getTelefono(), clienteDtoIn.getDireccion());
        clientes.add(nuevoCliente);
        return new idDto(nuevoId, "Cliente registrado con éxito");
    }

    public ClienteDto obtenerPorId(int id) {
        for (ClienteDto cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    public void actualizar(int id, ClienteDtoIn clienteDtoIn) {
        for (ClienteDto cliente : clientes) {
            if (cliente.getId() == id) {
                cliente.setNombre(clienteDtoIn.getNombre());
                cliente.setTelefono(clienteDtoIn.getTelefono());
                cliente.setDireccion(clienteDtoIn.getDireccion());
                break;
            }
        }
    }

    public void borrar(int id) {
        clientes.removeIf(cliente -> cliente.getId() == id);
    }
}
