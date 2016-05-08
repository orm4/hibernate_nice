package biz.tugay.saqila.mapping.enumMap;

import javax.persistence.*;

/**
 * Created by orm4 on 06.01.2016.
 */

@Entity
@Table(name = "enum", schema = "hibernatetest")
public class EnumMapping {

    @Id
    private Integer id;

    @Column(name = "c_stringEnum")
    @Enumerated(EnumType.STRING)
    private StrinEnum stringEnum;

    @Column(name = "c_intEnum")
    @Enumerated(EnumType.ORDINAL)
    private InEnum intEnum;

    @Lob
    @Column(name = "blobText")
    @Basic(fetch = FetchType.LAZY) //todo а что такое fetchType FetchType.EAGER ?
    private byte[] blobText;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StrinEnum getStringEnum() {
        return stringEnum;
    }

    public void setStringEnum(StrinEnum stringEnum) {
        this.stringEnum = stringEnum;
    }

    public InEnum getIntEnum() {
        return intEnum;
    }

    public void setIntEnum(InEnum intEnum) {
        this.intEnum = intEnum;
    }

    public byte[] getBlobText() {
        return blobText;
    }

    public void setBlobText(byte[] blobText) {
        this.blobText = blobText;
    }
}
