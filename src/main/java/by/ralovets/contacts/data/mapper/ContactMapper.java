package by.ralovets.contacts.data.mapper;

import by.ralovets.contacts.data.request.CreateContactDTO;
import by.ralovets.contacts.data.response.ContactAddressDTO;
import by.ralovets.contacts.data.response.ContactDTO;
import by.ralovets.contacts.data.response.ContactEmailDTO;
import by.ralovets.contacts.data.response.ContactPhoneDTO;
import by.ralovets.contacts.entity.Contact;
import by.ralovets.contacts.entity.ContactAddress;
import by.ralovets.contacts.entity.ContactEmail;
import by.ralovets.contacts.entity.ContactPhone;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ContactMapper {

    private final ContactEmailMapper emailMapper;
    private final ContactAddressMapper addressMapper;
    private final ContactPhoneMapper phoneMapper;

    public Contact toEntity(CreateContactDTO dto) {
        final ContactPhone phone = phoneMapper.toEntity(dto.getPhone());
        final ContactEmail email = emailMapper.toEntity(dto.getEmail());
        final ContactAddress address = addressMapper.toEntity(dto.getAddress());

        final Contact contact = new Contact();

        contact.setFirstName(dto.getFirstName());
        contact.setLastName(dto.getLastName());
        contact.setBirthday(dto.getBirthday());
        contact.addPhone(phone);
        contact.addEmail(email);
        contact.addAddress(address);

        return contact;
    }

    public ContactDTO toDTO(Contact contact) {
        final Set<ContactPhoneDTO> phones = contact.getPhones().stream()
                .map(phoneMapper::toDTO)
                .collect(Collectors.toSet());

        final Set<ContactEmailDTO> emails = contact.getEmails().stream()
                .map(emailMapper::toDTO)
                .collect(Collectors.toSet());

        final Set<ContactAddressDTO> addresses = contact.getAddresses().stream()
                .map(addressMapper::toDTO)
                .collect(Collectors.toSet());

        final ContactDTO dto = new ContactDTO();

        dto.setFirstName(dto.getFirstName());
        dto.setLastName(dto.getLastName());
        dto.setBirthday(dto.getBirthday());
        dto.setPhones(phones);
        dto.setEmails(emails);
        dto.setAddresses(addresses);

        return dto;
    }
}
