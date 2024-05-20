package calendar.exceptions;

public class ExistentAccountException extends Exception {
    private String accountName;

    public ExistentAccountException(String accountName) {
        super();
        this.accountName = accountName;
    }
    public String getAccountName() {
        return accountName;
    }
}
