package ua.com.owu.spring_ls_15.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.owu.spring_ls_15.dao.ContactDAO;
import ua.com.owu.spring_ls_15.models.Contact;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactDAO contactDAO;

    //crud

    public void save(String name, String email){
        if (name != null && email != null) {
            Contact contact = new Contact();
            contact.setName(name);
            contact.setEmail(email);
            contactDAO.save(contact);
        }
    }

    public void save(Contact contact){
        if (contact != null){
            contactDAO.save(contact);
        }
    }

    public void update(int id, String newName, String newEmail){
        Contact contact = contactDAO.findById(id).get();
        contact.setName(newName);
        contact.setEmail(newEmail);

        //викликаємо наш метод
        save(contact);
    }

    public void remove(int id){
        if (id > 0){
            Contact one = contactDAO.getOne(id);
            contactDAO.delete(one);
        }
    }

    public Contact findOne(int id){
        return contactDAO.getOne(id);
    }

    public List<Contact> findAll(){
        return contactDAO.findAll();
    }

    public Contact findAllByEmail(String email){
        return contactDAO.findAllByEmail(email);
    }

    public List<Contact> findAllWithName(String name){
        return contactDAO.customQueryFindByName(name);
    }


}
