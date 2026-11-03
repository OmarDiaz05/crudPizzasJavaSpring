package mx.unam.aragon.tsp.omar.pizzas.webController;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import mx.unam.aragon.tsp.omar.pizzas.businessLayer.TamanoBusinessLayer;
import mx.unam.aragon.tsp.omar.pizzas.dtos.TamanoDto;
import mx.unam.aragon.tsp.omar.pizzas.dtos.TamanoDtoIn;

@Controller
public class TamanoWebController {

    private final TamanoBusinessLayer tamanoBusinessLayer;

    public TamanoWebController(TamanoBusinessLayer businessLayer) {
        this.tamanoBusinessLayer = businessLayer;
    }

    @GetMapping("/tamanos")
    public String index(Model model) {
        ArrayList<TamanoDto> tamanos = tamanoBusinessLayer.obtenerTodos();
        model.addAttribute("tamanos", tamanos);
        return "tamanos/index";
    }

    @GetMapping("/tamanos/crear")
    public String crear() {
        return "tamanos/crear";
    }

    @PostMapping("/tamanos/crear")
    public String guardar(@ModelAttribute TamanoDtoIn tamanoDtoIn) {
        tamanoBusinessLayer.agregar(tamanoDtoIn);
        return "redirect:/tamanos";
    }

    @GetMapping("/tamanos/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        TamanoDto tamano = tamanoBusinessLayer.obtenerPorId(id);
        model.addAttribute("tamano", tamano);
        return "tamanos/editar";
    }

    @PostMapping("/tamanos/actualizar/{id}")
    public String actualizar(@PathVariable int id, @ModelAttribute TamanoDtoIn tamanoDtoIn) {
        tamanoBusinessLayer.actualizar(id, tamanoDtoIn);
        return "redirect:/tamanos";
    }

    @GetMapping("/tamanos/borrar/{id}")
    public String borrar(@PathVariable int id) {
        tamanoBusinessLayer.borrar(id);
        return "redirect:/tamanos";
    }
}
