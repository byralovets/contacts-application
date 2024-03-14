package by.ralovets.contacts.util.dto.response;

import by.ralovets.contacts.data.response.ContactAddressDTO;
import by.ralovets.contacts.data.response.ContactDTO;
import by.ralovets.contacts.data.response.ContactEmailDTO;
import by.ralovets.contacts.data.response.ContactPhoneDTO;
import by.ralovets.contacts.util.TestBuilder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor(staticName = "contactDto")
@With
public class ContactDtoTestBuilder implements TestBuilder<ContactDTO> {

    private Long id = 1L;
    private String firstName = "John";
    private String lastName = "Doe";
    private LocalDate birthday = LocalDate.of(1984, 1, 1);
    private ContactPhoneDTO phone = ContactPhoneDtoTestBuilder.contactPhoneDto().build();
    private ContactEmailDTO email = ContactEmailDtoTestBuilder.contactEmailDto().build();
    private ContactAddressDTO address = ContactAddressDtoTestBuilder.contactAddressDto().build();

    @Override
    public ContactDTO build() {
        final ContactDTO contactDTO = new ContactDTO();

        contactDTO.setId(id);
        contactDTO.setFirstName(firstName);
        contactDTO.setLastName(lastName);
        contactDTO.setBirthday(birthday);
        contactDTO.setPhones(Set.of(phone));
        contactDTO.setEmails(Set.of(email));
        contactDTO.setAddresses(Set.of(address));

        return contactDTO;
    }
}
