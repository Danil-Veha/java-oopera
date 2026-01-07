import java.util.ArrayList;

public class MusicalShow extends Show {
    protected Person musicAuthor;
    protected String librettoText;

    public MusicalShow(String title, int duration, Director director,
                       ArrayList<Actor> actors, Person musicAuthor, String librettoText) {
        super(title, director,actors, duration);
        this.musicAuthor = musicAuthor;
        this.librettoText = librettoText;
    }

    public void printLibretto() {
        System.out.println("Либретто спектакля '" + title + "':");
        if (librettoText != null && !librettoText.isEmpty()) {
            System.out.println(librettoText);
        } else {
            System.out.println("(текст либретто отсутствует)");
        }
    }

    public Person getMusicAuthor() {
        return musicAuthor;
    }

    public String getLibrettoText() {
        return librettoText;
    }

    public void setMusicAuthor(Person musicAuthor) {
        this.musicAuthor = musicAuthor;
    }

    public void setLibrettoText(String librettoText) {
        this.librettoText = librettoText;
    }

}