package by.ralovets.contacts.util.dto.request;

import by.ralovets.contacts.data.request.UpdateContactDTO;
import by.ralovets.contacts.util.TestBuilder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor(staticName = "updateContactDto")
@With
public class UpdateContactDtoTestBuilder implements TestBuilder<UpdateContactDTO> {

    private String firstName = "Alice";
    private String lastName = "Frank";
    private LocalDate birthday = LocalDate.of(1994, 3, 4);

    @Override
    public UpdateContactDTO build() {
        final UpdateContactDTO contactDTO = new UpdateContactDTO();

        contactDTO.setFirstName(firstName);
        contactDTO.setLastName(lastName);
        contactDTO.setBirthday(birthday);

        return contactDTO;
    }
}