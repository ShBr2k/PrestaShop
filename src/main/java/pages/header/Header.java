package main.java.pages.header;

/**
 * Class pages.Header that contains instance of LogCont class
 */
public class Header {

    private LogCont logCont;

    /**
     * Default constructor
     * creats new LogCont.
     */
    public Header() {
        logCont = new LogCont();
    }

    /**
     * getter to LogCont
     * @return logCont
     */
    public LogCont getLogCont() {
        return logCont;
    }
}