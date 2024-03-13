package by.ralovets.contacts.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "contacts", schema = "contacts_schema")
@Getter
@Setter
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contacts_id_seq")
    @SequenceGenerator(name = "contacts_id_seq", sequenceName = "contacts_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", nullable = false, length = 64)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 64)
    private String lastName;

    @Column(name = "birthday")
    private LocalDate birthday;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ContactEmail> emails = new HashSet<>();

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ContactPhone> phones = new HashSet<>();

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ContactAddress> addresses = new HashSet<>();

    public void setEmails(Set<ContactEmail> emails) {
        emails.stream()
                .filter(email -> Objects.isNull(email.getContact()))
                .forEach(email -> email.setContact(this));

        this.emails = emails;
    }

    public void setPhones(Set<ContactPhone> phones) {
        phones.stream()
                .filter(phone -> Objects.isNull(phone.getContact()))
                .forEach(phone -> phone.setContact(this));

        this.phones = phones;
    }

    public void setAddresses(Set<ContactAddress> addresses) {
        addresses.stream()
                .filter(address -> Objects.isNull(address.getContact()))
                .forEach(address -> address.setContact(this));

        this.addresses = addresses;
    }

    public void addEmail(ContactEmail email) {
        emails.add(email);
        email.setContact(this);
    }

    public void removeEmail(ContactEmail email) {
        emails.remove(email);
        email.setContact(null);
    }

    public void addPhone(ContactPhone phone) {
        phones.add(phone);
        phone.setContact(this);
    }

    public void removePhone(ContactPhone phone) {
        phones.remove(phone);
        phone.setContact(null);
    }

    public void addAddress(ContactAddress address) {
        addresses.add(address);
        address.setContact(this);
    }

    public void removeAddress(ContactAddress address) {
        addresses.remove(address);
        address.setContact(null);
    }
}
