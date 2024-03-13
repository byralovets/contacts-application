package by.ralovets.contacts.data.response;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
public class ContactDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private Set<ContactPhoneDTO> phones;
    private Set<ContactEmailDTO> emails;
    private Set<ContactAddressDTO> addresses;
}
