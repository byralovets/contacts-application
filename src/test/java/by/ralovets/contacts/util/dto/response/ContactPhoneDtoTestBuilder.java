package by.ralovets.contacts.util.dto.response;

import by.ralovets.contacts.data.response.ContactPhoneDTO;
import by.ralovets.contacts.util.TestBuilder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

@AllArgsConstructor
@NoArgsConstructor(staticName = "contactPhoneDto")
@With
public class ContactPhoneDtoTestBuilder implements TestBuilder<ContactPhoneDTO> {

    private Long id = 1L;
    private String primary = "+385";
    private String phoneValue = "123456789";

    @Override
    public ContactPhoneDTO build() {
        final ContactPhoneDTO phoneDTO = new ContactPhoneDTO();

        phoneDTO.setId(id);
        phoneDTO.setPrimary(primary);
        phoneDTO.setPhone(phoneValue);

        return phoneDTO;
    }
}
