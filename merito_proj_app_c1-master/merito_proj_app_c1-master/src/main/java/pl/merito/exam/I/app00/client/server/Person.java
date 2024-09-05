package pl.merito.exam.I.app00.client.server;

import lombok.ToString;

@ToString
public class Person {

    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
