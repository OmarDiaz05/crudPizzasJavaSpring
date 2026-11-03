package mx.unam.aragon.tsp.omar.pizzas.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.unam.aragon.tsp.omar.pizzas.dtos.idDto;


@RestController 
public class SaludoController {
    
    @GetMapping("/api/v1/saludos")
    public idDto Saludar(){
        idDto IdDto = new idDto(1, "Hola mundo desde SPRING");

        return IdDto;
    }


}
