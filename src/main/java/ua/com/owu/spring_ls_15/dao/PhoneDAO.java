package ua.com.owu.spring_ls_15.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.owu.spring_ls_15.models.Phone;

public interface PhoneDAO extends JpaRepository<Phone, Integer> {
}
