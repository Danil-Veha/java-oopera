public class Ballet extends MusicalSpectacle {
    private String choreographer;

    public Ballet(String title, int duration, Director director,
                  String musicAuthor, String librettoText, String choreographer) {
        super(title, duration, director, musicAuthor, librettoText);
        this.choreographer = choreographer;
    }

    public String getChoreographer() { return choreographer; }
}
