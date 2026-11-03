package mx.unam.aragon.tsp.omar.pizzas.webController;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import mx.unam.aragon.tsp.omar.pizzas.businessLayer.PizzasBusinessLayer;
import mx.unam.aragon.tsp.omar.pizzas.dtos.PizzaDto;
import mx.unam.aragon.tsp.omar.pizzas.dtos.PizzaDtoIn;

@Controller
public class PizzaWebController {

    private final PizzasBusinessLayer pizzasBusinessLayer;

    public PizzaWebController(PizzasBusinessLayer businessLayer) {
        this.pizzasBusinessLayer = businessLayer;
    }

    @GetMapping("/pizzas")
    public String index(Model model) {
        ArrayList<PizzaDto> pizzas = pizzasBusinessLayer.obtenerTodas();
        model.addAttribute("pizzas", pizzas);
        return "pizzas/index";
    }

    @GetMapping("/pizzas/crear")
    public String crear() {
        return "pizzas/crear";
    }

    @PostMapping("/pizzas/crear")
    public String guardar(@ModelAttribute PizzaDtoIn pizzaDtoIn) {
        pizzasBusinessLayer.Agregar(pizzaDtoIn);
        return "redirect:/pizzas";
    }

    @GetMapping("/pizzas/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        PizzaDto pizza = pizzasBusinessLayer.obtenerPorId(id);
        model.addAttribute("pizza", pizza);
        return "pizzas/editar";
    }

    @PostMapping("/pizzas/actualizar/{id}")
    public String actualizar(@PathVariable int id, @ModelAttribute PizzaDtoIn pizzaDtoIn) {
        pizzasBusinessLayer.actualizar(id, pizzaDtoIn);
        return "redirect:/pizzas";
    }

    @GetMapping("/pizzas/borrar/{id}")
    public String borrar(@PathVariable int id) {
        pizzasBusinessLayer.borrar(id);
        return "redirect:/pizzas";
    }
}
