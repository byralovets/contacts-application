package by.ralovets.contacts.data.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UpdateContactDTO {

    private String firstName;
    private String lastName;
    private LocalDate birthday;
}
