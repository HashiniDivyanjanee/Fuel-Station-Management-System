package Swing;

public class DataSearch {

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isStory() {
        return story;
    }

    public void setStory(boolean story) {
        this.story = story;
    }
    
    private String text;
    private boolean story;

    public DataSearch(String text, boolean story) {
        this.text = text;
        this.story = story;
    }

    public DataSearch() {
    }
    
    
}
