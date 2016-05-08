package biz.tugay.saqila.accessMode;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by orm4 on 03.01.2016.
 */
@Entity
public class FieldMode {
    @Id// аннотация висит на филде. Значит метадата будет строиться на основании филдов.
    private Integer id;
    private String lastName;

    // при field mode не происходит взаимодействие через get\set. Через рефлексию напрямую в филды кладуться данные
    public Integer getId() {
        System.out.println("Сюда никто не заходит при fieldMode и никто не делает метаданных на основании get-set");
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
