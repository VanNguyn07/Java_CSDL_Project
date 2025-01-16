package Model;

public class SearchModel {
    private String textFieldOfSearch;

    public SearchModel(String area){
        this.textFieldOfSearch = area;
    }

    public String getTextFieldOfSearch() {
        return textFieldOfSearch;
    }

    public void setTextFieldOfSearch(String textFieldOfSearch) {
        this.textFieldOfSearch = textFieldOfSearch;
    }
}
