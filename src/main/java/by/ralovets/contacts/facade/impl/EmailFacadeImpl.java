package by.ralovets.contacts.facade.impl;

import by.ralovets.contacts.data.mapper.ContactEmailMapper;
import by.ralovets.contacts.data.request.CreateEmailDTO;
import by.ralovets.contacts.data.request.UpdateEmailDTO;
import by.ralovets.contacts.data.response.ContactEmailDTO;
import by.ralovets.contacts.entity.Contact;
import by.ralovets.contacts.entity.ContactEmail;
import by.ralovets.contacts.facade.EmailFacade;
import by.ralovets.contacts.service.ContactEmailService;
import by.ralovets.contacts.service.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class EmailFacadeImpl implements EmailFacade {

    private final ContactEmailService emailService;
    private final ContactService contactService;
    private final ContactEmailMapper emailMapper;

    @Override
    @Transactional
    public ContactEmailDTO createEmail(Long contactId, CreateEmailDTO data) {
        final Contact contact = contactService.findById(contactId);
        final ContactEmail email = emailMapper.toEntity(data);

        contact.addEmail(email);

        contactService.save(contact);

        return emailMapper.toDTO(email);
    }

    @Override
    @Transactional
    public ContactEmailDTO updateEmailById(Long contactId, Long emailId, UpdateEmailDTO data) {
        ContactEmail email = emailService.findByIdAndContactId(emailId, contactId);

        email = emailMapper.toExistingEntity(data, email);
        email = emailService.save(email);

        return emailMapper.toDTO(email);
    }

    @Override
    @Transactional
    public void deleteEmailById(Long contactId, Long emailId) {
        emailService.deleteByIdAndContactId(emailId, contactId);
    }
}
