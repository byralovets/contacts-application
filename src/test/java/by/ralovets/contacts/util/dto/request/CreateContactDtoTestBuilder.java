package by.ralovets.contacts.util.dto.request;

import by.ralovets.contacts.data.request.CreateAddressDTO;
import by.ralovets.contacts.data.request.CreateContactDTO;
import by.ralovets.contacts.data.request.CreateEmailDTO;
import by.ralovets.contacts.data.request.CreatePhoneDTO;
import by.ralovets.contacts.util.TestBuilder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor(staticName = "contact")
@With
public class CreateContactDtoTestBuilder implements TestBuilder<CreateContactDTO> {

    private String firstName = "John";
    private String lastName = "Doe";
    private LocalDate birthday = LocalDate.of(1984, 1, 1);
    private CreatePhoneDTO phone = CreatePhoneDtoTestBuilder.contactPhone().build();
    private CreateEmailDTO email = CreateEmailDtoTestBuilder.contactEmail().build();
    private CreateAddressDTO address = CreateAddressDtoTestBuilder.contactAddress().build();

    @Override
    public CreateContactDTO build() {
        final CreateContactDTO contact = new CreateContactDTO();

        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setBirthday(birthday);
        contact.setPhones(Set.of(phone));
        contact.setEmails(Set.of(email));
        contact.setAddresses(Set.of(address));

        return contact;
    }
}
