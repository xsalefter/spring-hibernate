package org.xsalefter.springhibernate.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xsalefter (xsalefter@gmail.com)
 */
@Service
public interface ApplicationLogService {

    @Transactional
    public List selectAll();

    @Transactional
    public List selectAllWithDTO();
}
