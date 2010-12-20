package org.xsalefter.springhibernate.service;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.xsalefter.springhibernate.dao.SupplierDAO;
import org.xsalefter.springhibernate.model.Supplier;

/**
 * @author xsalefter (xsalefter@gmail.com)
 */
@Named
public class SupplierServiceImpl implements SupplierService {

    @Inject private SupplierDAO supplierDAO;

    @Override
    public List<Supplier> selectAll() {
        return this.supplierDAO.selectAll();
    }

    @Override
    public Supplier getByID(Long id) {
        return this.supplierDAO.getByID(id);
    }

    @Override
    public Supplier saveOrUpdate(Supplier supplier) {
        return this.supplierDAO.saveOrUpdate(supplier);
    }

    @Override
    public void delete(Supplier supplier) {
        this.supplierDAO.delete(supplier);
    }

}
