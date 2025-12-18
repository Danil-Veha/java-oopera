public class MusicalSpectacle extends Spectacle {
    private String musicAuthor;
    private String librettoText;

    public MusicalSpectacle(String title, int duration, Director director,
                            String musicAuthor, String librettoText) {
        super(title, duration, director);
        this.musicAuthor = musicAuthor;
        this.librettoText = librettoText;
    }

    public void printLibretto() {
        System.out.println("Либретто спектакля '" + getTitle() + "':");
        System.out.println(librettoText);
    }

    public String getMusicAuthor() { return musicAuthor; }
    public String getLibrettoText() { return librettoText; }
}