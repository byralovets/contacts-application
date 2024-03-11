package by.ralovets.contacts.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "contact_addresses", schema = "contacts_schema")
@Getter
@Setter
public class ContactAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_addresses_id_seq")
    @SequenceGenerator(name = "contact_addresses_id_seq", sequenceName = "contact_addresses_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "city", nullable = false, length = 64)
    private String city;

    @Column(name = "street", nullable = false, length = 64)
    private String street;

    @Column(name = "post_code", nullable = false, length = 64)
    private String postCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id")
    private Contact contact;
}
