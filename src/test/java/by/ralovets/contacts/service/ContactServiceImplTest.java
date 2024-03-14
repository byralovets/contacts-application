package by.ralovets.contacts.service;

import by.ralovets.contacts.entity.Contact;
import by.ralovets.contacts.repository.ContactRepository;
import by.ralovets.contacts.service.impl.ContactServiceImpl;
import by.ralovets.contacts.util.entity.BrokenContactTestBuilder;
import by.ralovets.contacts.util.entity.ContactTestBuilder;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ContactServiceImplTest {

    @InjectMocks
    private ContactServiceImpl contactService;

    @Mock
    private ContactRepository contactRepository;

    @Nested
    class SaveTest {

        @Test
        @DisplayName("Test should throw DataIntegrityViolationException because NOT NULL constraint failed")
        void testShouldThrowDataIntegrityViolationException() {
            final Contact contact = BrokenContactTestBuilder.brokenContact().build();
            final String expectedMessage = "Some error message about NOT NULL constraints failed";

            doThrow(new DataIntegrityViolationException(expectedMessage))
                    .when(contactRepository)
                    .save(contact);

            final DataIntegrityViolationException exception = assertThrows(
                    DataIntegrityViolationException.class,
                    () -> contactService.save(contact)
            );

            final String actualMessage = exception.getMessage();

            assertThat(actualMessage).isEqualTo(expectedMessage);
        }

        @Test
        @DisplayName("Test should return expected response")
        void testShouldReturnExpectedResponse() {
            final Contact expected = ContactTestBuilder.contact().build();

            doReturn(expected)
                    .when(contactRepository)
                    .save(expected);

            final Contact actual = contactService.save(expected);

            assertThat(actual).isEqualTo(expected);
        }
    }

    @Nested
    class FindByIdTest {

        @Test
        @DisplayName("Test should throw EntityNotFoundException with expected message")
        void testShouldThrowEntityNotFoundException() {
            final Long contactId = 1L;
            final String expectedMessage = ContactServiceImpl.CONTACT_NOT_FOUND_MESSAGE.formatted(contactId);

            doThrow(new EntityNotFoundException(expectedMessage))
                    .when(contactRepository)
                    .findById(contactId);

            final EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> contactService.findById(contactId));
            final String actualMessage = exception.getMessage();

            assertThat(actualMessage).isEqualTo(expectedMessage);
        }

        @Test
        @DisplayName("Test should return expected response")
        void testShouldReturnExpectedResponse() {
            final Contact expected = ContactTestBuilder.contact().build();

            doReturn(Optional.of(expected))
                    .when(contactRepository)
                    .findById(expected.getId());

            final Contact actual = contactService.findById(expected.getId());

            assertThat(actual).isEqualTo(expected);
        }
    }

    @Nested
    class FindPageTest {

        @Test
        @DisplayName("Test should return a page of size 1 that contains expected value")
        void testShouldReturnListOfSizeOne() {
            final Contact contact = ContactTestBuilder.contact().build();
            final Page<Contact> page = new PageImpl<>(List.of(contact));
            final Pageable pageable = PageRequest.of(0, 5);

            doReturn(page)
                    .when(contactRepository)
                    .findAll(pageable);

            final Page<Contact> actual = contactService.findPage(pageable);

            assertThat(actual).hasSize(1)
                    .contains(contact);
        }

        @Test
        @DisplayName("Test should return an empty page")
        void testShouldReturnEmptyList() {
            final Pageable pageable = PageRequest.of(2, 5);

            doReturn(Page.empty())
                    .when(contactRepository)
                    .findAll(pageable);

            final Page<Contact> actual = contactService.findPage(pageable);

            assertThat(actual).isEmpty();
        }
    }

    @Nested
    class DeleteByIdTest {

        @Test
        @DisplayName("Test should complete successfully for any provided id (both existing and no)")
        void testShouldCompleteForExistingEntity() {
            final Long contactId = 1L;

            doNothing().when(contactRepository)
                    .deleteById(contactId);

            contactService.deleteById(contactId);

            verify(contactRepository, times(1)).deleteById(contactId);
        }
    }
}
