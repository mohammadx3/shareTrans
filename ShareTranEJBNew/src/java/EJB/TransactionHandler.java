/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import com.google.common.primitives.Ints;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uk.ac.susx.inf.ianw.shareManagement.ShareBroker;
import uk.ac.susx.inf.ianw.shareManagement.UnknownCompanyException;

/**
 *
 * @author Mohammad Moonis
 */
@Stateless
public class TransactionHandler implements TransactionHandlerLocal {
    @PersistenceContext(unitName = "ShareTranEJBNewPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    @Override
public void addShare(TransactionPersist transaction)
{
    persist(transaction);
}
    @Override
public List<TransactionPersist> list(){
    Query q = em.createQuery("SELECT tp FROM TransactionPersist as tp Order by tp.compName");
        return  q.getResultList();
    }
    @Override
    public List<TransactionPersist> view(String comp_name){
       //Query p = em.createQuery("SELECT tp FROM TransactionPersist tp WHERE tp.compName='"+comp_name+"' Order By tp.no_shares"); 
     Query p = em.createQuery("SELECT SUM(S.NoShares) FROM TransactionPersist S WHERE S.compName='"+comp_name+"'"); 
     return p.getResultList();
    }
    @Override
    public int sumOfSh(String comp_name){
        Query p = em.createQuery("SELECT SUM(S.NoShares) FROM TransactionPersist S WHERE S.compName='"+comp_name+"'"); 
        int k = Integer.parseInt(p.getSingleResult().toString());
        return k;
    }
    @Override
   public List<TransactionPersist> sumPrice(String comp_name){
  Query p = em.createQuery("SELECT SUM(S.PRICE) FROM TransactionPersist S WHERE S.compName='"+comp_name+"'"); 
     return p.getResultList();
    }
   
    
//    @Override
//   public int sum(String comp_name){
//       Query p = em.createQuery("SELECT SUM(S.NoShares) FROM TransactionPersist S WHERE S.compName='"+comp_name+"'"); 
//      int k = p.getFirstResult();
//       return k;
//       
//   } 
//    public static int[] toIntArray(List<Integer> view) {
//  int[] result = new int[view.size()];
//  for (int x : view) result.add(x); // assume no nulls
//  return result;
//} 
    @Override
    public List<TransactionPersist> totalshares(String comp_name){
       //Query p = em.createQuery("SELECT tp FROM TransactionPersist tp WHERE tp.compName='"+comp_name+"' Order By tp.no_shares"); 
     Query p = em.createQuery("SELECT SUM(S.NoShares) FROM TransactionPersist S WHERE S.compName='"+comp_name+"'"); 
            return p.getResultList();
    }
    @Override
public void delete(TransactionPersist Transaction)
{
    Transaction = em.merge(Transaction);
    em.remove(Transaction);
}
    @Override
public double price(String comp_Name) throws RemoteException, NotBoundException, MalformedURLException, UnknownCompanyException
{
    ShareBroker sb = (ShareBroker) Naming.lookup("rmi://localhost:40090/ShareBroker");
    return sb.getPrice(comp_Name);
}


  
  
    
}
