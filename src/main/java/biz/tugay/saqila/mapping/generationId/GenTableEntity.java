package biz.tugay.saqila.mapping.generationId;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by orm4 on 08.01.2016.
 */

@Entity
@Table(name = "GEN_TABLE", schema = "hibernatetest")
public class GenTableEntity implements Serializable {
    @Id
    @Column(name = "GEN_TABLE_PK")
    @TableGenerator(name = "appSeqStore", table = "APP_SEQ_STORE", pkColumnName = "APP_SEQ_NAME", pkColumnValue = "GEN_TABLE.GEN_TABLE_PK", valueColumnName = "APP_SEQ_VALUE", initialValue = 1, allocationSize = 60)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "appSeqStore")
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