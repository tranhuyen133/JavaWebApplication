package re.mvc.dao;

import org.springframework.stereotype.Repository;
import re.mvc.model.Animal;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AnimalDaoImpl {
    private List<Animal> animals;

    public AnimalDaoImpl() {
        animals = new ArrayList<>();
        animals.add(new Animal(1,"Dog", "Chó cỏ", "https://tse1.mm.bing.net/th/id/OIP.hZNmsfQ1PSyajrF35ZV9cgHaEV?pid=Api&P=0&h=180",750000.00f));
        animals.add(new Animal(2,"Cat", "Mèo anh lông ngắn", "https://petto.vn/wp-content/uploads/2021/08/meo-anh-long-ngan-mau-bicolor.jpg?v=1628516222",5000000.00f));
        animals.add(new Animal(3,"Dinosaur", "Khủng long ăn thịt", "https://tse1.mm.bing.net/th/id/OIP.iYQ3Jp15qwkaUjtnvGbCWQHaEO?pid=Api&P=0&h=180",1000000000.00f));

    }
    public List<Animal> getAnimals() {
        return animals;
    }
    public void deleteById(int id){
        animals.remove(findById(id));
    }

    public Animal findById(int id){
        return animals.stream().filter(animal -> animal.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public void addAnimal(Animal animal){
        animals.add(animal);
    }

    public void updateAnimal(Animal animal){
        animals.set(animals.indexOf(findById(animal.getId())), animal);
    }
}