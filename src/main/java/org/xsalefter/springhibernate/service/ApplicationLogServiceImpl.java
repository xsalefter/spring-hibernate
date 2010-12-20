package org.xsalefter.springhibernate.service;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.xsalefter.springhibernate.dao.ApplicationLogDAO;

/**
 * @author xsalefter (xsalefter@gmail.com)
 */
@Named
public class ApplicationLogServiceImpl implements ApplicationLogService {

    @Inject private ApplicationLogDAO applicationLogDAO;

    @Override
    public List selectAll() {
        return this.applicationLogDAO.selectAll();
    }

    @Override
    public List selectAllWithDTO() {
        return this.applicationLogDAO.selectAllWithDTO();
    }

}
