package biz.tugay.saqila.mapping.generationId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by orm4 on 08.01.2016.
 */

@Entity
public class IdentityTableEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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