package ua.com.owu.spring_ls_15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ua.com.owu.spring_ls_15.editors.PhoneEditor;
import ua.com.owu.spring_ls_15.models.Contact;
import ua.com.owu.spring_ls_15.models.Phone;
import ua.com.owu.spring_ls_15.service.ContactService;
import ua.com.owu.spring_ls_15.service.PhoneService;

import java.beans.PropertyEditor;

@Controller
public class MainController {

    @Autowired
    private ContactService contactService;
    @Autowired
    private PhoneService phoneService;

    @GetMapping("/")
    public String home(Model model){

        model.addAttribute("contacts", contactService.findAll());


        return "home";
    }
    
    @PostMapping("/saveContact")    
    public String saveContact(Contact contact, @RequestParam("phone") String p){
        contactService.save(contact);

        Phone phone = new Phone();
        phone.setPNumber(p);
        phone.setContact(contact);

        phoneService.save(phone);

        return "home";
    }


    //перехоплюємо обєкт
    @Autowired
    PhoneEditor phoneEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        System.out.println("binder");

        //встановлюєм що має бути на виході і куди посилатись для того щоб привести до відповідного типу
        binder.registerCustomEditor(Phone.class, phoneEditor);
    }



    @GetMapping("/details-{id}")    
    public String detailsOfContact(@PathVariable("id") int id, Model model){
        Contact one = contactService.findOne(id);
        model.addAttribute("contact", one);
        return "details";
    }
    
    @PostMapping("/updateContact")    
    public String updateContact(Contact contact){
        contactService.save(contact);
        return "redirect:/";
    }
}
