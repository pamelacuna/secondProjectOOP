package calendar;

import calendar.exceptions.ExistentAccountException;
import calendar.exceptions.UnknownAccountTypeException;

public interface Calendar {
    void register(String accountName, String accountType);

    boolean isValidType(String accountType) throws UnknownAccountTypeException, ExistentAccountException;


}
