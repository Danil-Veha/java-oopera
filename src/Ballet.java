public class Ballet extends MusicalSpectacle {
// также бы написал бы в этом классе так как не каждый человк Танцор
    public Ballet(String title, int duration, Director director,
                  String musicAuthor, String librettoText, String choreographer) {
        super(title, duration, director, musicAuthor, librettoText);
        getDirector().setChoreographer(choreographer);
    }

    public String getChoreographer() {
        return getDirector().getChoreographer();
    }
}
