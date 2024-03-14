package by.ralovets.contacts.util.dto.request;

import by.ralovets.contacts.data.request.CreateEmailDTO;
import by.ralovets.contacts.util.TestBuilder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

@AllArgsConstructor
@NoArgsConstructor(staticName = "contactEmail")
@With
public class CreateEmailDtoTestBuilder implements TestBuilder<CreateEmailDTO> {

    private String emailValue = "john.doe@example.com";

    @Override
    public CreateEmailDTO build() {
        final CreateEmailDTO email = new CreateEmailDTO();

        email.setEmail(emailValue);

        return email;
    }
}
