package pl.merito.exam.I.app00.client.server;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    private static final String FILE_PATH = "persons.txt"; 

    public ServerRestController() {
        loadPersonsFromFile();
    }

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
        
        savePersonsToFile();
        
        return person;
    }

    private void savePersonsToFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            objectMapper.writeValue(writer, persons);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadPersonsFromFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            persons = objectMapper.readValue(reader, new TypeReference<List<Person>>(){});
        } catch (IOException e) {
            System.out.println("No persons file found, starting with an empty list.");
            persons = new ArrayList<>();
        }
    }

}