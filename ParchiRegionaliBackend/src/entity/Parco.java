/**
 * This file was generated by the JPA Modeler
 */
package entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author albert
 */
@Entity
public class Parco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    private String nomeParco;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeParco() {
        return this.nomeParco;
    }

    public void setNomeParco(String nomeParco) {
        this.nomeParco = nomeParco;
    }

}