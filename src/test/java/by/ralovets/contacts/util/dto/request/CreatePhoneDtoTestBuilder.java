package by.ralovets.contacts.util.dto.request;

import by.ralovets.contacts.data.request.CreatePhoneDTO;
import by.ralovets.contacts.util.TestBuilder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

@AllArgsConstructor
@NoArgsConstructor(staticName = "contactPhone")
@With
public class CreatePhoneDtoTestBuilder implements TestBuilder<CreatePhoneDTO> {

    private String primary = "+385";
    private String phoneValue = "123456789";

    @Override
    public CreatePhoneDTO build() {
        final CreatePhoneDTO phone = new CreatePhoneDTO();

        phone.setPrimary(primary);
        phone.setPhone(phoneValue);

        return phone;
    }
}
