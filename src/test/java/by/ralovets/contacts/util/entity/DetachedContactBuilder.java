package by.ralovets.contacts.util.entity;

import by.ralovets.contacts.entity.Contact;
import by.ralovets.contacts.entity.ContactAddress;
import by.ralovets.contacts.entity.ContactEmail;
import by.ralovets.contacts.entity.ContactPhone;
import by.ralovets.contacts.util.TestBuilder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor(staticName = "detachedContact")
@With
public class DetachedContactBuilder implements TestBuilder<Contact> {

    private String firstName = "John";
    private String lastName = "Doe";
    private LocalDate birthday = LocalDate.of(1984, 1, 1);
    private ContactPhone phone = ContactPhoneTestBuilder.contactPhone().build();
    private ContactEmail email = ContactEmailTestBuilder.contactEmail().build();
    private ContactAddress address = ContactAddressTestBuilder.contactAddress().build();

    @Override
    public Contact build() {
        final Contact contact = new Contact();

        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setBirthday(birthday);
        contact.setPhones(Set.of(phone));
        contact.setEmails(Set.of(email));
        contact.setAddresses(Set.of(address));

        return contact;
    }
}