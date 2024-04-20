package ru.kpfu.itis.gnt.okno.exceptions;

public class DataAccessException extends ApplicationException {

    public DataAccessException(String action, Long dataId, Long authId) {
        super("You don't have enough rights for this action.", "action=" + action, "dataId=" + dataId, "authId=" + authId);
    }
}
