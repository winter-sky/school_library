package mainpackage.dao;

import mainpackage.model.Pupils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PupilsDAOImpl implements PupilsDAO {

    private static final Logger logger = LoggerFactory.getLogger(PupilsDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public boolean checkContainsOrNot(int pupilId){
        Session session = this.sessionFactory.getCurrentSession();
        List<Pupils> pupilsList = session.createCriteria(Pupils.class).list();

        Query query = session.createQuery("from Pupils where pupil_id=:pupilId");

        query.setParameter("pupilId", pupilId);

        Pupils pupil = (Pupils) query.uniqueResult();

        return pupilsList.contains(pupil);
    }
}
