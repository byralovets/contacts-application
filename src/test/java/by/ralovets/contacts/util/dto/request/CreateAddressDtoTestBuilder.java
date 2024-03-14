package by.ralovets.contacts.util.dto.request;

import by.ralovets.contacts.data.request.CreateAddressDTO;
import by.ralovets.contacts.util.TestBuilder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

@AllArgsConstructor
@NoArgsConstructor(staticName = "contactAddress")
@With
public class CreateAddressDtoTestBuilder implements TestBuilder<CreateAddressDTO> {

    private String city = "NY";
    private String street = "42th st.";
    private String postCode = "424242";

    @Override
    public CreateAddressDTO build() {
        final CreateAddressDTO address = new CreateAddressDTO();

        address.setCity(city);
        address.setStreet(street);
        address.setPostCode(postCode);

        return address;
    }
}
