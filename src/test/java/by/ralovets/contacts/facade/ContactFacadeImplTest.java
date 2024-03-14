package by.ralovets.contacts.facade;

import by.ralovets.contacts.data.mapper.ContactMapper;
import by.ralovets.contacts.data.request.CreateContactDTO;
import by.ralovets.contacts.data.request.UpdateContactDTO;
import by.ralovets.contacts.data.response.ContactDTO;
import by.ralovets.contacts.entity.Contact;
import by.ralovets.contacts.facade.impl.ContactFacadeImpl;
import by.ralovets.contacts.service.ContactService;
import by.ralovets.contacts.util.dto.request.CreateContactDtoTestBuilder;
import by.ralovets.contacts.util.dto.request.UpdateContactDtoTestBuilder;
import by.ralovets.contacts.util.dto.response.ContactDtoTestBuilder;
import by.ralovets.contacts.util.dto.response.UpdatedContactDtoTestBuilder;
import by.ralovets.contacts.util.entity.ContactTestBuilder;
import by.ralovets.contacts.util.entity.DetachedContactBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ContactFacadeImplTest {

    @InjectMocks
    private ContactFacadeImpl contactFacade;

    @Mock
    private ContactService contactService;

    @Mock
    private ContactMapper contactMapper;

    @Nested
    class CreateContactTest {

        @Test
        @DisplayName("Test should return expected response")
        void testShouldReturnExpectedResponse() {
            final Contact detachedContact = DetachedContactBuilder.detachedContact().build();
            final CreateContactDTO request = CreateContactDtoTestBuilder.contact().build();
            final Contact persistedContact = ContactTestBuilder.contact().build();
            final ContactDTO expected = ContactDtoTestBuilder.contactDto().build();

            doReturn(detachedContact)
                    .when(contactMapper)
                    .toEntity(request);

            doReturn(persistedContact)
                    .when(contactService)
                    .save(detachedContact);

            doReturn(expected)
                    .when(contactMapper)
                    .toDTO(persistedContact);

            final ContactDTO actual = contactFacade.createContact(request);

            assertThat(actual).isEqualTo(expected);
        }
    }

    @Nested
    class FindContactsTest {

        @Test
        @DisplayName("Test should return a page of size 1 that contains expected value")
        void testShouldReturnListOfSizeOne() {
            final Contact contact = ContactTestBuilder.contact().build();
            final Page<Contact> page = new PageImpl<>(List.of(contact));
            final Pageable pageable = PageRequest.of(0, 5);
            final ContactDTO expected = ContactDtoTestBuilder.contactDto().build();

            doReturn(page)
                    .when(contactService)
                    .findPage(pageable);

            doReturn(expected)
                    .when(contactMapper)
                    .toDTO(contact);

            final Page<ContactDTO> actual = contactFacade.findContacts(pageable.getPageNumber(), pageable.getPageSize());

            assertThat(actual).hasSize(1)
                    .contains(expected);
        }

        @Test
        @DisplayName("Test should return an empty page")
        void testShouldReturnEmptyList() {
            final Pageable pageable = PageRequest.of(2, 5);

            doReturn(Page.empty())
                    .when(contactService)
                    .findPage(pageable);

            final Page<ContactDTO> actual = contactFacade.findContacts(pageable.getPageNumber(), pageable.getPageSize());

            assertThat(actual).isEmpty();
        }
    }

    @Nested
    class FindContactByIdTest {

        @Test
        @DisplayName("Test should return expected response")
        void testShouldReturnExpectedResponse() {
            final Contact persistedContact = ContactTestBuilder.contact().build();
            final ContactDTO expected = ContactDtoTestBuilder.contactDto().build();

            doReturn(persistedContact)
                    .when(contactService)
                    .findById(persistedContact.getId());

            doReturn(expected)
                    .when(contactMapper)
                    .toDTO(persistedContact);

            final ContactDTO actual = contactFacade.findContactById(expected.getId());

            assertThat(actual).isEqualTo(expected);
        }
    }

    @Nested
    class UpdateContactByIdTest {

        @Test
        @DisplayName("Test should return expected response")
        void testShouldReturnExpectedResponse() {
            final Contact persistedContact = ContactTestBuilder.contact().build();
            final UpdateContactDTO request = UpdateContactDtoTestBuilder.updateContactDto().build();
            final ContactDTO expected = UpdatedContactDtoTestBuilder.contactDto().build();

            doReturn(persistedContact)
                    .when(contactService)
                    .findById(persistedContact.getId());

            doReturn(persistedContact)
                    .when(contactMapper)
                    .toExistingEntity(request, persistedContact);

            doReturn(persistedContact)
                    .when(contactService)
                    .save(persistedContact);

            doReturn(expected)
                    .when(contactMapper)
                    .toDTO(persistedContact);

            final ContactDTO actual = contactFacade.updateContactById(persistedContact.getId(), request);

            assertThat(actual).isEqualTo(expected);
        }
    }

    @Nested
    class DeleteContactByIdTest {

        @Test
        @DisplayName("Test should complete successfully for any provided id (both existing and no)")
        void testShouldCompleteForExistingEntity() {
            final Long contactId = 1L;

            doNothing().when(contactService)
                    .deleteById(contactId);

            contactFacade.deleteContactById(contactId);

            verify(contactService, times(1)).deleteById(contactId);
        }
    }
}
