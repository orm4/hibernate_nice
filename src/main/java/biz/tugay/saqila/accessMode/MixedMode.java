package biz.tugay.saqila.accessMode;

import javax.persistence.*;

/**
 * Created by orm4 on 03.01.2016.
 */
@Entity
@Access(AccessType.FIELD)// задаем мод для всей сущности(мод по умолчанию)
public class MixedMode {
    @Id // размещаем @ID - помня о том, что это важно и именно он определеяет какой тип мода используется
    private Integer id;

    private String firstName; // этот филд будет использовать мод по умолчанию

    @Transient // этой аннотацией скажем, что при построение JPA сущности был пропущен default-mode
    private String lastName;

    @Access(AccessType.PROPERTY) // скажем, что будем использовать Property mode.
    public String getSurName() {
        return lastName;
    }

    public void setSurName(String lastName) {
        this.lastName = lastName;
    }

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
}
