package org.xsalefter.springhibernate.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.xsalefter.springhibernate.model.Supplier;

/**
 * @author xsalefter (xsalefter@gmail.com)
 */
@Repository
public interface SupplierDAO {

    public List<Supplier> selectAll();
    public Supplier getByID(Long id);
    public Supplier saveOrUpdate(Supplier supplier);
    public void delete(Supplier supplier);
}
