package biz.tugay.saqila.mapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by orm4 on 03.01.2016.
 */
@Entity(name = "map") // название entity в контексте JPA. Например для JPQL
@Table(name = "m_mapping", schema = "hibernatetest") // name - название таблице в БД. schema - название схемы в БД
public class ColumnMapping {

    @Id
    private Integer id;

    @Column(columnDefinition = "Имя человека") // задаем описание колонки.
    private String firstName;

    @Column(name = "c_lastName") // задаём имя колонки.
    private String lastName;

    @Column(name = "c_age", insertable = false) // задаем, что колонка не будет вставляться. По дефолту на уровне БД 999
    private Integer age;

    @Column(name = "c_telephonNumber", updatable = false) // задаем, что колонка не будет обновляться.
    private String telephonNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTelephonNumber() {
        return telephonNumber;
    }

    public void setTelephonNumber(String telephonNumber) {
        this.telephonNumber = telephonNumber;
    }
}
