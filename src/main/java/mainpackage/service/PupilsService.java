package mainpackage.service;

import mainpackage.model.Pupils;

public interface PupilsService {
    public boolean checkContainsOrNot(int pupilId);
    public Pupils searchPupilByName (String string);
}
