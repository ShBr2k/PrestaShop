package main.java.pages.common;

import main.java.pages.header.Header;
import main.java.pages.header.HeaderFull;

public class ParentPage {

    public Header initHeader () {
        return new Header();
    }

    public HeaderFull initHeaderFull () {
        return new HeaderFull();
    }
}
