package biz.tugay.saqila.accessMode;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by orm4 on 03.01.2016.
 */
@Entity
public class PropertyMode {
    private Integer id;
    private String lastName;
    private String firstName1;

    @Id// аннотация висит на get\set поэтому метаданные будут строится на основании get\setров
    public Integer getId() {
        System.out.println("А вот сюда мы уже зайдем! В отличие от fieldMode! И метаданные будем на основании get-set делать!");
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurName() { // В БД есть поле surName. Так и называется get\set метод. А вот на уровне объекта - называется lastName
        return lastName;
    }

    public void setSurName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName1() {
        return firstName1;
    }

    public void setFirstName1(String firstName) {
        this.firstName1 = firstName;
    }
}
