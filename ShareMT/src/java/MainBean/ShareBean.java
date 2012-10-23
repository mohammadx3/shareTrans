/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MainBean;

import EJB.TransactionHandlerLocal;
import EJB.TransactionPersist;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Mohammad Moonis
 */
@Named(value = "shareBean")
@SessionScoped
public class ShareBean implements Serializable {
    @EJB
    private TransactionHandlerLocal transactionHandler;
    private String compName;
    private double price;
    private int no_shares;
    
    
    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public int getNo_shares() {
        return no_shares;
    }

    public String view_shares(){
        return "view_shares";
    }
    public void setNo_shares(int no_shares) {
        this.no_shares = no_shares;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws NotBoundException, MalformedURLException, RemoteException {
        this.price = retrievePrice();
    }
    

    //    @EJB
//    private share_ejbLocal share_ejb;
//
    public String buy(){
        return "Buy";
    }
public String view_trans(){
    return "view_trans";
}
public String index(){
    return "index.xhtml";
}
    public String sell(){
        return "Sell";
    }
    
public String sellPrice(){
return "sellpage2";
}
    public String viewPrice(){
    return "buy_wind";
}
    
private int sell_NoShares;
    public int getSell_NoShares() {
        return sell_NoShares;
    }

    public void setSell_NoShares(int sell_NoShares) {
        this.sell_NoShares = sell_NoShares;
    }

    
public double retrievePrice() throws MalformedURLException, RemoteException, NotBoundException   {
     return transactionHandler.price(compName);   
}    
    
public List<TransactionPersist> getTransactions(){
    return transactionHandler.list();
}    
public List<TransactionPersist> getViews(){
    return transactionHandler.view(compName);
}
public List<TransactionPersist> pshares(){
    return transactionHandler.sumPrice(compName);
}
public double assetval() throws MalformedURLException, RemoteException, NotBoundException{
    double m = (sumSh()*retrievePrice());
    return m;
}
public String assetPage(){
    return "assetPage";
}
public  int sumSh(){
    return transactionHandler.sumOfSh(compName);
}

public List<TransactionPersist> sumOfShares(){
    return transactionHandler.totalshares(compName);
} 


public String sell_submit() throws RemoteException, NotBoundException, MalformedURLException{
    if(sumSh()>0){
    TransactionPersist tp = new TransactionPersist();
        tp.setCompName(compName);
        tp.setNoShares(-no_shares);
        tp.setPrice(retrievePrice());
        tp.setTran_date(new Date());
       transactionHandler.addShare(tp);
   return "result_sell";
    }
    else 
        return "Abort";
}



public String buy_submit() throws RemoteException, NotBoundException, MalformedURLException{

       TransactionPersist tp = new TransactionPersist();
        tp.setCompName(compName);
        tp.setNoShares(no_shares);
        tp.setPrice(retrievePrice());
        tp.setTran_date(new Date());
       transactionHandler.addShare(tp);

   return "result";
}
    public String delete(TransactionPersist tp)
    {
        transactionHandler.delete(tp);
        return "view_trans";
    }
    
    
    public ShareBean() {
    }

}

    
    
    
    
