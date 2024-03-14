package by.ralovets.contacts.util.dto.response;

import by.ralovets.contacts.data.response.ContactAddressDTO;
import by.ralovets.contacts.util.TestBuilder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

@AllArgsConstructor
@NoArgsConstructor(staticName = "contactAddressDto")
@With
public class ContactAddressDtoTestBuilder implements TestBuilder<ContactAddressDTO> {

    private Long id = 1L;
    private String city = "NY";
    private String street = "42th st.";
    private String postCode = "424242";

    @Override
    public ContactAddressDTO build() {
        final ContactAddressDTO addressDTO = new ContactAddressDTO();

        addressDTO.setId(id);
        addressDTO.setCity(city);
        addressDTO.setStreet(street);
        addressDTO.setPostCode(postCode);

        return addressDTO;
    }
}
