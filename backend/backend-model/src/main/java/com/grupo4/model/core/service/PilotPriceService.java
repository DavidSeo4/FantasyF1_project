package com.grupo4.model.core.service;

import com.grupo4.api.core.service.IPilotPriceService;
import com.grupo4.model.core.dao.PilotPriceDao;
import com.grupo4.model.core.dao.RaceDao;
import com.grupo4.model.core.dao.ResultDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Lazy
@Service("PilotPriceService")
public class PilotPriceService implements IPilotPriceService {

    @Autowired
    private PilotPriceDao pilotPriceDao;

    @Autowired
    private ResultService resultService;

    @Autowired
    private DefaultOntimizeDaoHelper daoHelper;


    @Override
    public EntityResult pilotPriceQuery(Map<String, Object> keysValues, List<String> attributes) throws OntimizeJEERuntimeException {
        return this.daoHelper.query(this.pilotPriceDao, keysValues, attributes);
    }

    @Override
    public EntityResult pilotPriceInsert(Map<String, Object> attributes) throws OntimizeJEERuntimeException {
        return this.daoHelper.insert(this.pilotPriceDao, attributes);
    }

    @Override
    public EntityResult pilotPriceUpdate(Map<String, Object> attributes, Map<String, Object> KeyValues) throws OntimizeJEERuntimeException {
        return null;
    }

    @Override
    public EntityResult pilotPriceDelete(Map<String, Object> keyValues) throws OntimizeJEERuntimeException {
        return null;
    }

    @Override
    public EntityResult listNamePriceQuery(Map<String, Object> keysValues, List<String> attributes) throws OntimizeJEERuntimeException {
        return this.daoHelper.query(this.pilotPriceDao, keysValues, attributes, "listNamePrice");
    }

}
