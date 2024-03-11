package by.ralovets.contacts.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "contact_phones", schema = "contacts_schema")
@Getter
@Setter
public class ContactPhone {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_phones_id_seq")
    @SequenceGenerator(name = "contact_phones_id_seq", sequenceName = "contact_phones_id_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "\"primary\"", nullable = false, length = 64)
    private String primary;

    @Column(name = "phone", nullable = false, length = 64)
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contact_id")
    private Contact contact;
}
