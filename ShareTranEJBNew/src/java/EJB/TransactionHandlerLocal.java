/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import javax.ejb.Local;

/**
 *
 * @author Mohammad Moonis
 */
@Local
public interface TransactionHandlerLocal {

    public double price(java.lang.String comp_Name) throws java.rmi.RemoteException, java.rmi.NotBoundException, java.net.MalformedURLException, uk.ac.susx.inf.ianw.shareManagement.UnknownCompanyException;

    public void delete(EJB.TransactionPersist Transaction);

    public java.util.List<EJB.TransactionPersist> list();

    public void addShare(EJB.TransactionPersist transaction);

    public java.util.List<EJB.TransactionPersist> view(java.lang.String comp_name);

    public java.util.List<EJB.TransactionPersist> totalshares(java.lang.String comp_name);


    public int sumOfSh(java.lang.String comp_name);

    public java.util.List<EJB.TransactionPersist> sumPrice(java.lang.String comp_name);
    
}
