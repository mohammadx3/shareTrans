/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Mohammad Moonis
 */
@Entity
public class TransactionPersist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
private String compName;

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public int getNoShares() {
        return NoShares;
    }

    public void setNoShares(int NoShares) {
        this.NoShares = NoShares;
    }

    
    public Date getTran_date() {
        return tran_date;
    }

    public void setTran_date(Date tran_date) {
        this.tran_date = tran_date;
    }
private int NoShares;
    @Temporal(javax.persistence.TemporalType.DATE)
private Date tran_date;
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    

public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactionPersist)) {
            return false;
        }
        TransactionPersist other = (TransactionPersist) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EJB.TransactionPersist[ id=" + id + " ]";
    }
    
}
