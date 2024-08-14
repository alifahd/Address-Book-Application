package org.example.restservice;

import org.example.AddressBook;
import org.example.AddressBookRepository;
import org.example.BuddyInfo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressBookController {
    private AddressBookRepository repo;
    @GetMapping("/book")
    public String getBuddies(@RequestParam(value = "id", defaultValue = "0") String id, Model model) {
        AddressBook book = repo.findById(Long.parseLong(id));
        model.addAttribute("buddyInfoList", book.getBuddyInfoList());
        return "buddyInfoList";
    }
}
