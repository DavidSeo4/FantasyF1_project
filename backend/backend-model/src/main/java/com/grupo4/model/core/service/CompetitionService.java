package com.grupo4.model.core.service;

import com.grupo4.api.core.service.ICompetitionService;
import com.grupo4.model.core.dao.CompetitionDao;
import com.grupo4.model.core.dao.UserCompetitionDao;
import com.grupo4.model.core.dao.UserDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Lazy
@Service("CompetitionService")
public class CompetitionService implements ICompetitionService {

    @Autowired
    private CompetitionDao competitionDao;

    @Autowired
    private DefaultOntimizeDaoHelper daoHelper;

    @Autowired
    private UserCompetitionService userCompetitionService;

    @Override
    public EntityResult competitionQuery(Map<String, Object> keysValues, List<String> attrMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.query(this.competitionDao, keysValues, attrMap);
    }

    @Override
    public EntityResult publicCountCompetitionQuery(Map<String, Object> keysValues, List<String> attrMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.query(this.competitionDao, keysValues, attrMap, "publicCount");
    }

    @Override
    public EntityResult competitionByIdQuery(Map<String, Object> keysValues, List<String> attrMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.query(this.competitionDao, keysValues, attrMap, "competitionById");
    }

    @Override
    public EntityResult rankingByIdQuery(Map<String, Object> keysValues, List<String> attrMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.query(this.competitionDao, keysValues, attrMap, "rankingById");
    }

    @Override
    public EntityResult rankingByUserAndIdQuery(Map<String, Object> keysValues, List<String> attrMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.query(this.competitionDao, keysValues, attrMap, "rankingByUserAndId");
    }

    @Override
    public EntityResult rankingByUserRoundIdQuery(Map<String, Object> keysValues, List<String> attrMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.query(this.competitionDao, keysValues, attrMap, "rankingByUserRoundId");
    }

    @Override
    public EntityResult availableMoneyFilterQuery(Map<String, Object> keysValues, List<String> attrMap) throws OntimizeJEERuntimeException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        keysValues.put(UserDao.ID, authentication.getName());
        return this.daoHelper.query(this.competitionDao, keysValues, attrMap,"availableMoneyFilter");
    }

    @Override
    public EntityResult competitionInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
        Map<String, Object> keyMap = new HashMap<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        keyMap.put(UserDao.ID, authentication.getName());
        EntityResult res = this.daoHelper.insert(competitionDao, attrMap);
        keyMap.put(CompetitionDao.COMP_ID, res.get(CompetitionDao.COMP_ID));
        this.userCompetitionService.userCompetitionInsert(keyMap);
        return res;
    }

    @Override
    public EntityResult competitionUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.update(competitionDao, attrMap, keyMap);
    }

    @Override
    public EntityResult competitionDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.competitionDao, keyMap);
    }

}
