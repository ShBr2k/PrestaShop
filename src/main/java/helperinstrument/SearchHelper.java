package main.java.helperinstrument;

import main.java.data.SearchElements;
import main.java.pages.header.HeaderFull;
import main.java.pages.searchresult.SearchResultPage;

public class SearchHelper {
    private SearchResultPage searchResultPage;

    public SearchHelper() {
        initSearchResultPage();
    }

    public SearchHelper initSearchResultPage() {
        searchResultPage = new HeaderFull()
                .clearSearchField()
                .sendKeysToSearchField(SearchElements.SEARCHING_PRODUCT)
                .searchButtonClick();
        return this;
    }

    public SearchResultPage getSearchResultPage() {
        return searchResultPage;
    }
}
