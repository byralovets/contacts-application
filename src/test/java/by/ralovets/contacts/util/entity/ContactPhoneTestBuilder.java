package by.ralovets.contacts.util.entity;

import by.ralovets.contacts.entity.ContactPhone;
import by.ralovets.contacts.util.TestBuilder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

@AllArgsConstructor
@NoArgsConstructor(staticName = "contactPhone")
@With
public class ContactPhoneTestBuilder implements TestBuilder<ContactPhone> {

    private Long id = 1L;
    private String primary = "+385";
    private String phoneValue = "123456789";

    @Override
    public ContactPhone build() {
        final ContactPhone phone = new ContactPhone();

        phone.setId(id);
        phone.setPrimary(primary);
        phone.setPhone(phoneValue);

        return phone;
    }
}
