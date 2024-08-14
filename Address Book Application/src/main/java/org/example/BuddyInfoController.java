package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BuddyInfoController {
    AddressBook book = new AddressBook();
    @GetMapping("/buddyInfo")
    public String buddyInfoForm(Model model) {
        model.addAttribute("buddyInfo", new BuddyInfo());
        return "buddyInfo";
    }

    @PostMapping("/buddyInfo")
    public String buddyInfoSubmit(@ModelAttribute BuddyInfo buddyInfo, Model model) {
        model.addAttribute("buddyInfo", buddyInfo);
        book.addBuddy(buddyInfo);
        model.addAttribute("book", book);
        return "result";
    }

}
