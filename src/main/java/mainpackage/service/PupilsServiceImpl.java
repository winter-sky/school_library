package mainpackage.service;

import mainpackage.dao.PupilsDAO;
import mainpackage.model.Pupils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PupilsServiceImpl implements PupilsService {
    private PupilsDAO pupilsDAO;

    public void setPupilsDAO(PupilsDAO pupilsDAO) {
        this.pupilsDAO = pupilsDAO;
    }

    @Override
    @Transactional
    public boolean checkContainsOrNot(int pupilId){return this.pupilsDAO.checkContainsOrNot(pupilId);}

    @Override
    @Transactional
    public Pupils searchPupilByName (String name){return this.pupilsDAO.searchPupilByName(name);}
}
