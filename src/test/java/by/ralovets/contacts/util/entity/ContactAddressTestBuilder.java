package by.ralovets.contacts.util.entity;

import by.ralovets.contacts.entity.ContactAddress;
import by.ralovets.contacts.util.TestBuilder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

@AllArgsConstructor
@NoArgsConstructor(staticName = "contactAddress")
@With
public class ContactAddressTestBuilder implements TestBuilder<ContactAddress> {

    private Long id = 1L;
    private String city = "NY";
    private String street = "42th st.";
    private String postCode = "424242";

    @Override
    public ContactAddress build() {
        final ContactAddress address = new ContactAddress();

        address.setId(id);
        address.setCity(city);
        address.setStreet(street);
        address.setPostCode(postCode);

        return address;
    }
}
