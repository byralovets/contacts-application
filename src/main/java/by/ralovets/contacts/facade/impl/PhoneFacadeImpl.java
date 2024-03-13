package by.ralovets.contacts.facade.impl;

import by.ralovets.contacts.data.mapper.ContactPhoneMapper;
import by.ralovets.contacts.data.request.CreatePhoneDTO;
import by.ralovets.contacts.data.request.UpdatePhoneDTO;
import by.ralovets.contacts.data.response.ContactPhoneDTO;
import by.ralovets.contacts.entity.Contact;
import by.ralovets.contacts.entity.ContactPhone;
import by.ralovets.contacts.facade.PhoneFacade;
import by.ralovets.contacts.service.ContactPhoneService;
import by.ralovets.contacts.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class PhoneFacadeImpl implements PhoneFacade {

    private final ContactPhoneService phoneService;
    private final ContactService contactService;
    private final ContactPhoneMapper phoneMapper;

    @Override
    @Transactional
    public ContactPhoneDTO createPhone(Long contactId, CreatePhoneDTO data) {
        final Contact contact = contactService.findById(contactId);
        final ContactPhone phone = phoneMapper.toEntity(data);

        contact.addPhone(phone);

        contactService.save(contact);

        return phoneMapper.toDTO(phone);
    }

    @Override
    @Transactional
    public ContactPhoneDTO updatePhoneById(Long contactId, Long phoneId, UpdatePhoneDTO data) {
        ContactPhone phone = phoneService.findByIdAndContactId(phoneId, contactId);

        phone = phoneMapper.toExistingEntity(data, phone);
        phone = phoneService.save(phone);

        return phoneMapper.toDTO(phone);
    }

    @Override
    @Transactional
    public void deletePhoneById(Long contactId, Long phoneId) {
        phoneService.deleteByIdAndContactId(phoneId, contactId);
    }
}
