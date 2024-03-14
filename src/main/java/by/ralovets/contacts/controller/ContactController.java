package by.ralovets.contacts.controller;

import by.ralovets.contacts.data.request.CreateContactDTO;
import by.ralovets.contacts.data.request.UpdateContactDTO;
import by.ralovets.contacts.data.response.ContactDTO;
import by.ralovets.contacts.facade.ContactFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactFacade contactFacade;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContactDTO create(@RequestBody @Valid CreateContactDTO data) {
        return contactFacade.createContact(data);
    }

    @GetMapping
    public Page<ContactDTO> read(@RequestParam Integer page, @RequestParam Integer size) {
        return contactFacade.findContacts(page, size);
    }

    @GetMapping("/{id}")
    public ContactDTO read(@PathVariable Long id) {
        return contactFacade.findContactById(id);
    }

    @PutMapping("/{id}")
    public ContactDTO update(@PathVariable Long id, @RequestBody @Valid UpdateContactDTO data) {
        return contactFacade.updateContactById(id, data);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        contactFacade.deleteContactById(id);
    }
}
