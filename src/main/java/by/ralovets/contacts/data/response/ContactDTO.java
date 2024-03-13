package by.ralovets.contacts.data.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class ContactDTO {

    private Long id;

    private String firstName;

    private String lastName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    private Set<ContactPhoneDTO> phones;

    private Set<ContactEmailDTO> emails;

    private Set<ContactAddressDTO> addresses;
}
