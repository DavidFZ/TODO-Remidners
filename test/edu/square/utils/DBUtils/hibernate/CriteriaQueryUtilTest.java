package edu.square.utils.DBUtils.hibernate;

import jakarta.persistence.criteria.CriteriaQuery;
import org.apache.poi.ss.formula.functions.T;
import org.hibernate.Session;
import org.junit.Test;

import static org.junit.Assert.*;

public class CriteriaQueryUtilTest {

    @Test
    public void getCriteriaQuery() {
        Session session = SessionFactoryUtil.getSession();
        Class<T> queryClass = T.class;
        CriteriaQuery<T> criteriaQuery = CriteriaQueryUtil.getCriteriaQuery(session,queryClass);
        assertNotNull(criteriaQuery);
    }

    @Test
    public void getCriteriaQueryOfAll() {


    }
}