public class MusicalSpectacle extends Show {
    protected String librettoText;
// Я бы добавил MusicAuthor сюда так как не каждый человек Композитор
    public MusicalSpectacle(String title, int duration, Director director,
                            String musicAuthor, String librettoText) {
        super(title, duration, director);
        getDirector().setMusicAuthor(musicAuthor);
        this.librettoText = librettoText;
    }

    public void printLibretto() {
        System.out.println("Либретто спектакля '" + getTitle() + "':");
        System.out.println(librettoText);
    }

    public String getMusicAuthor() {
        return getDirector().getMusicAuthor();
    }

    public String getLibrettoText() {
        return librettoText;
    }
}