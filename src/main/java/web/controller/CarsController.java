package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
public class CarsController {

    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public String showCars(@RequestParam(value = "count", required = false) Integer count, Model model){
        if (count != null && count < 0) {
            // If count is negative, generate an error and return a page with an error message
            model.addAttribute("errorMessage", "The number of cars cannot be negative");
            return "errorPage"; // Assuming you have an errorPage for error messages
        }

        model.addAttribute("cars", carService.getCars(count == null ? 5 : count));
        return "cars";
    }

}
