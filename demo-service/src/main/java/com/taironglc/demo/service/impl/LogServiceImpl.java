package com.taironglc.demo.service.impl;

import com.taironglc.demo.common.exception.DemoBusinessException;
import com.taironglc.demo.dao.mapper.WhFinLogMapper;
import com.taironglc.demo.dao.model.WhFinLog;
import com.taironglc.demo.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService{

    @Autowired
    WhFinLogMapper whFinLogMapper;

    @Override
    public WhFinLog selectById(Long id) throws DemoBusinessException {
       /* if(true){
            throw new DemoBusinessException(DemoBusinessExceptionCode.RPC_ERROR);
        }*/
        return whFinLogMapper.selectById(id);
    }
}
