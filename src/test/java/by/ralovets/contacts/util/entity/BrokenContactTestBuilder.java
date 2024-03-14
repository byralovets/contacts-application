package by.ralovets.contacts.util.entity;

import by.ralovets.contacts.entity.Contact;
import by.ralovets.contacts.util.TestBuilder;
import lombok.NoArgsConstructor;

@NoArgsConstructor(staticName = "brokenContact")
public class BrokenContactTestBuilder implements TestBuilder<Contact> {

    @Override
    public Contact build() {
        return new Contact();
    }
}
