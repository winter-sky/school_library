package mainpackage.dao;

import mainpackage.model.Pupils;

public interface PupilsDAO {
    public boolean checkContainsOrNot(int pupilId);//check whether particular pupil is contained or not
    public Pupils searchPupilByName (String name);//search pupil by name
}
