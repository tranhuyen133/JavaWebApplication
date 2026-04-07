package re.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import re.mvc.model.Animal;
import re.mvc.service.AnimalServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/animals")
public class AnimalController {
    private AnimalServiceImpl animalService;

    public AnimalController(AnimalServiceImpl animalService) {
        this.animalService = animalService;
    }

    // hiển thị danh sách
    @GetMapping("/list")
    public String showListAnimals(Model model){
        List<Animal> animals = animalService.getAnimals();
        model.addAttribute("animals", animals);
        return "list-animal";
    }

    // Xóa động vật
    @GetMapping("/delete")
    public String delete(@RequestParam int id){ // nhận id của đối tượng cần xóa
        animalService.deleteById(id);
        // sau khi xóa xong : trả lại trang list
        return "redirect:/animals/list";
    }
    // Chuyển trang sang trang thêm mới
    @GetMapping("/add")
    public String showAddAnimal(){
        return "add-animal";
    }
    @PostMapping("/add")
    public String addAnimal(
            @RequestParam int id,
            @RequestParam String  name,
            @RequestParam String description,
            @RequestParam String url,
            @RequestParam float price
    ){
        Animal animal = new Animal(id, name, description, url, price);
        animalService.addAnimal(animal);
        return "redirect:/animals/list";
    }

    // Hiển thị thông tin cũ
    @GetMapping("/edit")
    public String showEditAnimal(@RequestParam int id, Model model){
        Animal animal = animalService.getAnimalById(id);
        model.addAttribute("animal", animal);
        return "edit-animal";
    }
    @PostMapping("/update")
    public String updateAnimal(
            @RequestParam int id,
            @RequestParam String  name,
            @RequestParam String description,
            @RequestParam String url,
            @RequestParam float price
    ){
        Animal animal = new Animal(id, name, description, url, price);
        animalService.updateAnimal(animal);
        return "redirect:/animals/list";
    }
}