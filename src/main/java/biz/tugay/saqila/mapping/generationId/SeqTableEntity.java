package biz.tugay.saqila.mapping.generationId;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by orm4 on 08.01.2016.
 */

/**
 * Реализации конкретной не будет, потому что sequence не создается на текущем SQL-сервере.
 *
 * Создадим SEQUENCE.
 * CREATE SEQUENCE APP_USERS_SEQ START WITH 1 INCREMENT BY 1 NOCACHE NOCYCLE;
 */
@Entity
@Table(name = "SEQ_TABLE", schema = "hibernatetest")
public class SeqTableEntity implements Serializable {
    @Id
    @Column(name = "SEQ_TABLE_PK")
    @SequenceGenerator(name = "appUsersSeq", sequenceName = "APP_USERS_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appUsersSeq")
    private Long appUsersPk;

    private String userName;

    public Long getAppUsersPk() {
        return appUsersPk;
    }

    public void setAppUsersPk(Long appUsersPk) {
        this.appUsersPk = appUsersPk;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}