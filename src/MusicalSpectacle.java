public class MusicalSpectacle extends Show {
    protected String musicAuthor;
    protected String librettoText;

    public MusicalSpectacle(String title, int duration, Person director,
                            String musicAuthor, String librettoText) {
        super(title, duration, director);

        if (musicAuthor == null && director != null && director.getMusicAuthor() != null) {
            this.musicAuthor = director.getMusicAuthor();
        } else {
            this.musicAuthor = musicAuthor;
        }

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

    public String getMusicAuthor() {
        return musicAuthor;
    }

    public String getLibrettoText() {
        return librettoText;
    }

    public void setMusicAuthor(String musicAuthor) {
        this.musicAuthor = musicAuthor;
    }

    public void setLibrettoText(String librettoText) {
        this.librettoText = librettoText;
    }

}