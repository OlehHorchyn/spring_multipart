package ua.com.owu.spring_ls_15.editors;

import org.springframework.stereotype.Component;
import ua.com.owu.spring_ls_15.models.Phone;

import java.beans.PropertyEditorSupport;

//вказуємо що це BEAN
@Component
public class PhoneEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Phone phone = new Phone();
        phone.setPNumber(text);
        setValue(phone);
    }
}
