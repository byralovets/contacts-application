package by.ralovets.contacts.controller;

import by.ralovets.contacts.data.request.CreateEmailDTO;
import by.ralovets.contacts.data.request.UpdateEmailDTO;
import by.ralovets.contacts.data.response.ContactEmailDTO;
import by.ralovets.contacts.facade.EmailFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/contacts/{contactId}/emails")
@RequiredArgsConstructor
public class ContactEmailController {

    private final EmailFacade emailFacade;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContactEmailDTO create(@RequestBody @Valid CreateEmailDTO data, @PathVariable Long contactId) {
        return emailFacade.createEmail(contactId, data);
    }

    @PutMapping("/{emailId}")
    public ContactEmailDTO update(@PathVariable Long contactId,
                                  @PathVariable Long emailId,
                                  @RequestBody @Valid UpdateEmailDTO data) {
        return emailFacade.updateEmailById(contactId, emailId, data);
    }

    @DeleteMapping("/{emailId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long contactId, @PathVariable Long emailId) {
        emailFacade.deleteEmailById(contactId, emailId);
    }
}
