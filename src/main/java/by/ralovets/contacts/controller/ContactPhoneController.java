package by.ralovets.contacts.controller;

import by.ralovets.contacts.data.request.CreatePhoneDTO;
import by.ralovets.contacts.data.request.UpdatePhoneDTO;
import by.ralovets.contacts.data.response.ContactPhoneDTO;
import by.ralovets.contacts.facade.PhoneFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/contacts/{contactId}/phones")
@RequiredArgsConstructor
public class ContactPhoneController {

    private final PhoneFacade phoneFacade;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContactPhoneDTO create(@RequestBody @Valid CreatePhoneDTO data, @PathVariable Long contactId) {
        return phoneFacade.createPhone(contactId, data);
    }

    @PutMapping("/{phoneId}")
    public ContactPhoneDTO update(@PathVariable Long contactId,
                                  @PathVariable Long phoneId,
                                  @RequestBody @Valid UpdatePhoneDTO data) {
        return phoneFacade.updatePhoneById(contactId, phoneId, data);
    }

    @DeleteMapping("/{phoneId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long contactId, @PathVariable Long phoneId) {
        phoneFacade.deletePhoneById(contactId, phoneId);
    }
}
