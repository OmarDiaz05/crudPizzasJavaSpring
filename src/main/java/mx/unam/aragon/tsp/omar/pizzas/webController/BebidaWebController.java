package mx.unam.aragon.tsp.omar.pizzas.webController;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import mx.unam.aragon.tsp.omar.pizzas.businessLayer.BebidaBusinessLayer;
import mx.unam.aragon.tsp.omar.pizzas.dtos.BebidaDto;
import mx.unam.aragon.tsp.omar.pizzas.dtos.BebidaDtoIn;

@Controller
public class BebidaWebController {

    private final BebidaBusinessLayer bebidaBusinessLayer;

    public BebidaWebController(BebidaBusinessLayer businessLayer) {
        this.bebidaBusinessLayer = businessLayer;
    }

    @GetMapping("/bebidas")
    public String index(Model model) {
        ArrayList<BebidaDto> bebidas = bebidaBusinessLayer.obtenerTodas();
        model.addAttribute("bebidas", bebidas);
        return "bebidas/index";
    }

    @GetMapping("/bebidas/crear")
    public String crear() {
        return "bebidas/crear";
    }

    @PostMapping("/bebidas/crear")
    public String guardar(@ModelAttribute BebidaDtoIn bebidaDtoIn) {
        bebidaBusinessLayer.agregar(bebidaDtoIn);
        return "redirect:/bebidas";
    }

    @GetMapping("/bebidas/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        BebidaDto bebida = bebidaBusinessLayer.obtenerPorId(id);
        model.addAttribute("bebida", bebida);
        return "bebidas/editar";
    }

    @PostMapping("/bebidas/actualizar/{id}")
    public String actualizar(@PathVariable int id, @ModelAttribute BebidaDtoIn bebidaDtoIn) {
        bebidaBusinessLayer.actualizar(id, bebidaDtoIn);
        return "redirect:/bebidas";
    }

    @GetMapping("/bebidas/borrar/{id}")
    public String borrar(@PathVariable int id) {
        bebidaBusinessLayer.borrar(id);
        return "redirect:/bebidas";
    }
}
