package mx.unam.aragon.tsp.omar.pizzas.webController;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import mx.unam.aragon.tsp.omar.pizzas.businessLayer.ClienteBusinessLayer;
import mx.unam.aragon.tsp.omar.pizzas.dtos.ClienteDto;
import mx.unam.aragon.tsp.omar.pizzas.dtos.ClienteDtoIn;

@Controller
public class ClienteWebController {

    private final ClienteBusinessLayer clienteBusinessLayer;

    public ClienteWebController(ClienteBusinessLayer businessLayer) {
        this.clienteBusinessLayer = businessLayer;
    }

    @GetMapping("/clientes")
    public String index(Model model) {
        ArrayList<ClienteDto> clientes = clienteBusinessLayer.obtenerTodos();
        model.addAttribute("clientes", clientes);
        return "clientes/index";
    }

    @GetMapping("/clientes/crear")
    public String crear() {
        return "clientes/crear";
    }

    @PostMapping("/clientes/crear")
    public String guardar(@ModelAttribute ClienteDtoIn clienteDtoIn) {
        clienteBusinessLayer.agregar(clienteDtoIn);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        ClienteDto cliente = clienteBusinessLayer.obtenerPorId(id);
        model.addAttribute("cliente", cliente);
        return "clientes/editar";
    }

    @PostMapping("/clientes/actualizar/{id}")
    public String actualizar(@PathVariable int id, @ModelAttribute ClienteDtoIn clienteDtoIn) {
        clienteBusinessLayer.actualizar(id, clienteDtoIn);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/borrar/{id}")
    public String borrar(@PathVariable int id) {
        clienteBusinessLayer.borrar(id);
        return "redirect:/clientes";
    }
}
