package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import web.service.CarService;


@Controller
public class CarController {
    private final WebApplicationContext context;
    private final CarService carService;

    public CarController(WebApplicationContext context, CarService carService) {
        this.context = context;
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String carsPage(@RequestParam(value = "count", defaultValue = "-1") int count, Model model) {
        model.addAttribute("list", carService.getCars(count));
        return "/cars";
    }
}
