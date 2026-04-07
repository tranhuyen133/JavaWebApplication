package re.mvc.service;

import org.springframework.stereotype.Service;
import re.mvc.dao.AnimalDaoImpl;
import re.mvc.model.Animal;

import java.util.List;

@Service
public class AnimalServiceImpl {
    private AnimalDaoImpl animalDao;

    public AnimalServiceImpl(AnimalDaoImpl animalDao) {
        this.animalDao = animalDao;
    }

    public List<Animal> getAnimals() {
        return animalDao.getAnimals();
    }
    public void deleteById(int id){
        animalDao.deleteById(id);
    }
    public void addAnimal(Animal animal){
        animalDao.addAnimal(animal);
    }
    public Animal getAnimalById(int id){
        return animalDao.findById(id);
    }

    public void updateAnimal(Animal animal){
        animalDao.updateAnimal(animal);
    }
}