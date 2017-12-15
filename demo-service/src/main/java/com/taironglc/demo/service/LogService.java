package com.taironglc.demo.service;

import com.taironglc.demo.dao.model.WhFinLog;
import com.taironglc.demo.common.exception.DemoBusinessException;

public interface LogService {

    WhFinLog selectById(Long id) throws DemoBusinessException;
}
