package pl.merito.exam.I.app00.client.server;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServerRestController {

    @GetMapping("/")
    public String home() {
        return "Spring is here!";
    }

    @GetMapping("/persons")
    public List<Person> person() {
        Person person = new Person();
        person.setFirstName("FirstName");
        return List.of(person);
    }

    @PostMapping("/person")
    public Person addPerson(@RequestBody Person person) {
        System.out.println(String.format("Person [%s] added ", person.toString()));
        return person;
    }
}