package by.ralovets.contacts.util.entity;

import by.ralovets.contacts.entity.ContactEmail;
import by.ralovets.contacts.util.TestBuilder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;

@AllArgsConstructor
@NoArgsConstructor(staticName = "contactEmail")
@With
public class ContactEmailTestBuilder implements TestBuilder<ContactEmail> {

    private Long id = 1L;
    private String emailValue = "john.doe@example.com";

    @Override
    public ContactEmail build() {
        final ContactEmail email = new ContactEmail();

        email.setId(id);
        email.setEmail(emailValue);

        return email;
    }
}
