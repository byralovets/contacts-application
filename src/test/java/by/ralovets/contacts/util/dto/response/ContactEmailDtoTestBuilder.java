package by.ralovets.contacts.util.dto.response;

import by.ralovets.contacts.data.response.ContactEmailDTO;
import by.ralovets.contacts.util.TestBuilder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

@AllArgsConstructor
@NoArgsConstructor(staticName = "contactEmailDto")
@With
public class ContactEmailDtoTestBuilder implements TestBuilder<ContactEmailDTO> {

    private Long id = 1L;
    private String emailValue = "john.doe@example.com";

    @Override
    public ContactEmailDTO build() {
        final ContactEmailDTO emailDTO = new ContactEmailDTO();

        emailDTO.setId(id);
        emailDTO.setEmail(emailValue);

        return emailDTO;
    }
}
