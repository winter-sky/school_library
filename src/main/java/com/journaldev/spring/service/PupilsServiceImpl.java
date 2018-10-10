package com.journaldev.spring.service;

import com.journaldev.spring.dao.PersonDAO;
import com.journaldev.spring.dao.PupilsDAO;
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
}