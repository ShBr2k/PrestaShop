package main.java.pages.search;

import main.java.pages.common.PagePath;
import main.java.pages.common.ParentPage;


/**
 * 
 */
public class SearchPage extends ParentPage {
    //instants
    private Categories categories;
    private Description description;
    private SortBy sortBy;
    private PagePath pagePath;
    /**
     * Default constructor
     */
    public SearchPage() {
    }

    //geters
    public Categories getCategories() {
        categories = new Categories();
        return categories;
    }

    public Description getDescription(){
        description = new Description();
        return description;
    }

    public PagePath getPagePath(){
        pagePath = new PagePath();
        return pagePath;
    }

    public SortBy getSortBy(){
        sortBy = new SortBy();
        return sortBy;
    }
}