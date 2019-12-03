package main.java.pages.header;

/**
 * Parent class for classes LogUserInfo and UncloggedUserInfo
 */
public class LogUserInformation {
    public LogUserInformation() {

    }

    public LogUserInfo getLogUserInfo() {
        return new LogUserInfo();
    }

    public UnlogUserInfo getUnloggedUserInfo() {
        return new UnlogUserInfo();
    }
}

