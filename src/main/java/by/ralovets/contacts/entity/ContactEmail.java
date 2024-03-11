package by.ralovets.contacts.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "contact_emails", schema = "contacts_schema")
@Getter
@Setter
public class ContactEmail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_emails_id_seq")
    @SequenceGenerator(name = "contact_emails_id_seq", sequenceName = "contact_emails_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "email", nullable = false, unique = true, length = 64)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id")
    private Contact contact;
}
