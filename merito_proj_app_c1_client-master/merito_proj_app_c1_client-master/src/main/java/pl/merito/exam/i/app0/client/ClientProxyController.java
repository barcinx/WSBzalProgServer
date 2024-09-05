package pl.merito.exam.i.app0.client;

import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@RestController
public class ClientProxyController {

    private final RestTemplate restTemplate;

    @GetMapping("/persons")
    public List<Person> persons() {
        ResponseEntity<Person[]> response = restTemplate.getForEntity("http://localhost:8080/persons", Person[].class);
        return Arrays.stream(response.getBody()).toList();
    }

    @PostMapping("/person")
    public Person addPerson(@RequestBody Person person) {
        HttpEntity<Person> request = new HttpEntity<>(person);
        return restTemplate.postForObject("http://localhost:8080/person", request, Person.class);
    }

}
