package org.xsalefter.springhibernate.dao;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.xsalefter.springhibernate.utils.ApplicationLogDTO;

/**
 * @author xsalefter (xsalefter@gmail.com)
 */
@Named
public class ApplicationLogDAOImpl implements ApplicationLogDAO {

    @Inject private SessionFactory sessionFactory;

    @Override
    public List selectAll() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createSQLQuery("select * from application_log").list();
    }

    @Override
    public List<ApplicationLogDTO> selectAllWithDTO() {
        final StringBuffer sb = new StringBuffer().
            append("select log.application_log_id as id, ").
            append("log.log_code as code, log.message as message ").
            append("from application_log as log");

        Session session = this.sessionFactory.getCurrentSession();

        return session.createSQLQuery(sb.toString()).
            setResultTransformer(Transformers.aliasToBean(ApplicationLogDTO.class)).
            list();
    }

}
