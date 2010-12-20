package org.xsalefter.springhibernate.dao;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.xsalefter.springhibernate.model.Supplier;

/**
 * @author xsalefter (xsalefter@gmail.com)
 */
@Named
public class SupplierDAOImpl implements SupplierDAO {

    @Inject private SessionFactory sessionFactory;

    @Override
    public List<Supplier> selectAll() {
        final StringBuffer sb = new StringBuffer().append("from Supplier");
        Session session = this.sessionFactory.getCurrentSession();
        session.enableFilter("supplierToGoodReceptionsWhereOfficialAmountBetween").
            setParameter("officialAmountFrom", 0).
            setParameter("officialAmountUntil", 2000);
        List<Supplier> data = session.createQuery(sb.toString()).list();
        return data;
    }

    @Override
    public Supplier getByID(Long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Supplier supplier = (Supplier) session.get(Supplier.class, id);
        return supplier;
    }

    @Override
    public Supplier saveOrUpdate(Supplier supplier) {
        Session session = this.sessionFactory.getCurrentSession();
        return (Supplier) session.merge(supplier);
    }

    @Override
    public void delete(Supplier supplier) {
        this.sessionFactory.getCurrentSession().delete(supplier);
    }
}
