package com.grupo4.model.core.dao;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Lazy
@Repository(value ="PilotDao")
@ConfigurationFile(
        configurationFile = "dao/PilotDao.xml",
        configurationFilePlaceholder = "dao/placeholders.properties")
public class PilotDao extends OntimizeJdbcDaoSupport {
    public static final String PIL_ID = "PIL_ID";
    public static final String PIL_DRIVER_ID = "PIL_DRIVER_ID";
    public static final String PIL_NUMBER = "PIL_NUMBER";
    public static final String PIL_NAME = "PIL_NAME";
    public static final String PIL_SURNAME = "PIL_SURNAME";
    public static final String PIL_PRICE = "PIL_PRICE";
    public static final String PIL_NATIONALITY = "PIL_NATIONALITY";
    public static final String PIL_BIRTHDAY = "PIL_BIRTHDAY";
    public static final String PIL_URL = "PIL_URL";


}
