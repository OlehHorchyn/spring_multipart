package ua.com.owu.spring_ls_15.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.owu.spring_ls_15.models.Contact;

import java.util.List;

public interface ContactDAO extends JpaRepository<Contact, Integer> {

    //1
    Contact findAllByEmail(String email); ///springboot автоматично робить query

    //2
    @Query("select c from Contact c where c.name= :xxx")
    List<Contact> customQueryFindByName(@Param("xxx") String name);
}
