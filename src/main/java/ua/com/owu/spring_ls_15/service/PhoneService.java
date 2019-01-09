package ua.com.owu.spring_ls_15.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.owu.spring_ls_15.dao.PhoneDAO;
import ua.com.owu.spring_ls_15.models.Phone;

@Service
public class PhoneService {

    @Autowired
    PhoneDAO phoneDAO;

    public void save(Phone phone){
        phoneDAO.save(phone);
    }
}
