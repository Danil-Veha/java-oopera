public class Person {
    protected String name;
    protected String surname;
    protected Gender gender;
    protected String musicAuthor;
    protected String choreographer;

    public Person(String name, String surname, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }

    public Person(String name, String surname, Gender gender,
                  String musicAuthor, String choreographer) {
        this(name, surname, gender);
        this.musicAuthor = musicAuthor;
        this.choreographer = choreographer;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Gender getGender() {
        return gender;
    }

    public String getMusicAuthor() {
        return musicAuthor;
    }

    public String getChoreographer() {
        return choreographer;
    }

    public void setMusicAuthor(String musicAuthor) {
        this.musicAuthor = musicAuthor;
    }

    public void setChoreographer(String choreographer) {
        this.choreographer = choreographer;
    }
}