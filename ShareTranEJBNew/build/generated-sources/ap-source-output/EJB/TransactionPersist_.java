package EJB;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-04-19T20:14:31")
@StaticMetamodel(TransactionPersist.class)
public class TransactionPersist_ { 

    public static volatile SingularAttribute<TransactionPersist, Long> id;
    public static volatile SingularAttribute<TransactionPersist, Double> price;
    public static volatile SingularAttribute<TransactionPersist, Date> tran_date;
    public static volatile SingularAttribute<TransactionPersist, String> compName;
    public static volatile SingularAttribute<TransactionPersist, Integer> NoShares;

}