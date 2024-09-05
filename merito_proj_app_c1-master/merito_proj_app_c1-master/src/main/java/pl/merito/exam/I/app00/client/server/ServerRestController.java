package pl.merito.exam.I.app00.client.server;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
public class ServerRestController {

    private static List<Person> persons = new ArrayList<>();

    @GetMapping("/")
    public String home() {
        return "Spring is here!";
    }

    @GetMapping("/persons")
    public List<Person> getPersons() {
        return persons;
    }

    @PostMapping("/person")
    public Person addPerson(@RequestBody Person person) {
        persons.add(person);
        System.out.println(String.format("Person [%s] added ", person.toString()));
        
        savePersonToFile(person);
        
        return person;
    }

    private void savePersonToFile(Person person) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("persons.txt",true))){
            writer.write(person.toString());
            writer.newLine();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}