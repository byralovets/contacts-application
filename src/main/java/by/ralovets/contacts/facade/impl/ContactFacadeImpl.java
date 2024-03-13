package by.ralovets.contacts.facade.impl;

import by.ralovets.contacts.data.mapper.ContactMapper;
import by.ralovets.contacts.data.request.CreateContactDTO;
import by.ralovets.contacts.data.request.UpdateContactDTO;
import by.ralovets.contacts.data.response.ContactDTO;
import by.ralovets.contacts.entity.Contact;
import by.ralovets.contacts.facade.ContactFacade;
import by.ralovets.contacts.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ContactFacadeImpl implements ContactFacade {

    private final ContactService contactService;
    private final ContactMapper contactMapper;

    @Override
    @Transactional
    public ContactDTO createContact(CreateContactDTO data) {
        final Contact contact = contactMapper.toEntity(data);
        final Contact persistedContact = contactService.save(contact);

        return contactMapper.toDTO(persistedContact);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<ContactDTO> findContacts(Integer page, Integer size) {
        final Pageable pageable = PageRequest.of(page, size);

        return contactService.findPage(pageable)
                .map(contactMapper::toDTO);
    }

    @Override
    @Transactional(readOnly = true)
    public ContactDTO findContactById(Long id) {
        final Contact contact = contactService.findById(id);

        return contactMapper.toDTO(contact);
    }

    @Override
    @Transactional
    public ContactDTO updateContactById(Long id, UpdateContactDTO data) {
        Contact contact = contactService.findById(id);

        contact = contactMapper.toExistingEntity(data, contact);
        contact = contactService.save(contact);

        return contactMapper.toDTO(contact);
    }

    @Override
    @Transactional
    public void deleteContactById(Long id) {
        contactService.deleteById(id);
    }
}
