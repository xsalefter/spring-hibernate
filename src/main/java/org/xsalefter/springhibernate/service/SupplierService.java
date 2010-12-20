package org.xsalefter.springhibernate.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xsalefter.springhibernate.model.Supplier;

/**
 * @author xsalefter (xsalefter@gmail.com)
 */
@Service
public interface SupplierService {
    @Transactional public List<Supplier> selectAll();
    @Transactional public Supplier getByID(Long id);
    @Transactional public Supplier saveOrUpdate(Supplier supplier);
    @Transactional public void delete(Supplier supplier);
}
