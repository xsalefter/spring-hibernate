package org.xsalefter.springhibernate.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.xsalefter.springhibernate.utils.ApplicationLogDTO;

/**
 * @author xsalefter (xsalefter@gmail.com)
 */
@Repository
public interface ApplicationLogDAO {
    public List selectAll();
    public List<ApplicationLogDTO> selectAllWithDTO();
}
