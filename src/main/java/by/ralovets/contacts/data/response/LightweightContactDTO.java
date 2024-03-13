package by.ralovets.contacts.data.response;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LightweightContactDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
}
