package ua.com.owu.spring_ls_15.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString(exclude = "contact")
@NoArgsConstructor
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String pNumber;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Contact contact;

}
