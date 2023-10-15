package edu.square.utils.DBUtils.hibernate;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;

public class CriteriaQueryUtil {

    public static <T> CriteriaQuery<T> getCriteriaQuery(Session session, Class<T> queryClass) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        return criteriaBuilder.createQuery(queryClass);
    }

    public static <T> CriteriaQuery<T> getCriteriaQueryOfAll(Session session, Class<T> queryClass) {
        CriteriaQuery<T> criteriaQuery = getCriteriaQuery(session, queryClass);
        Root<T> root = criteriaQuery.from(queryClass);
        return criteriaQuery.select(root);
    }


}
