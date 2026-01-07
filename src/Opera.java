import java.util.ArrayList;

public class Opera extends MusicalShow {
    protected int choirSize;

    public Opera(String title, int duration, Director director,
                 ArrayList<Actor> actors, Person musicAuthor, String librettoText,
                 int choirSize) {
        super(title, duration, director, actors, musicAuthor, librettoText);
        this.choirSize = choirSize;
    }

    public int getChoirSize() {
        return choirSize;
    }

    public void setChoirSize(int choirSize) {
        this.choirSize = choirSize;
    }

}