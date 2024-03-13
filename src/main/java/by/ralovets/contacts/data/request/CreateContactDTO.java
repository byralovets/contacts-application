package by.ralovets.contacts.data.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateContactDTO {

    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private CreateEmailDTO email;
    private CreatePhoneDTO phone;
    private CreateAddressDTO address;
}
