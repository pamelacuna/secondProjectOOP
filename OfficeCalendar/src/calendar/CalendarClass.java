package calendar;

import calendar.exceptions.UnknownAccountTypeException;

public class CalendarClass implements Calendar {
    @Override
    public void register(String accountName, String accountType) {

    }

    @Override
    public boolean isValidType(String accountType) throws UnknownAccountTypeException {
        switch (accountType.toLowerCase()) {
            case "staff":
            case "manager":
            case "guest":
                return true;
            default:
                throw new UnknownAccountTypeException();
        }
    }

}
