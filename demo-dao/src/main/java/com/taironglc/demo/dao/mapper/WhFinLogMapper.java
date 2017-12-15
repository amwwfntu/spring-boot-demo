package com.taironglc.demo.dao.mapper;

import com.taironglc.demo.dao.model.WhFinLog;
import org.springframework.stereotype.Repository;

@Repository
public interface WhFinLogMapper {

    WhFinLog selectById(Long id);

    int save(WhFinLog log);
}
