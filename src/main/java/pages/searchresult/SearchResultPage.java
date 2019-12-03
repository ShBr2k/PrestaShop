package main.java.pages.searchresult;

import main.java.pages.common.ParentPage;
import main.java.pages.search.Products;

public class SearchResultPage extends ParentPage {

    private Products products;
    /**
     * Default constructor
     */
    public SearchResultPage() {
        super();
        products = new Products();
    }

    public Products getProducts(){
        return products;
    }

}
