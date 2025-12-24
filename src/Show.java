import java.util.ArrayList;

public class Show {
    private String title;
    private int duration;
    private Director director;
    private ArrayList<Actor> actors;

    public Show(String title, int duration, Director director) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.actors = new ArrayList<>();
    }

    public void printDirectorInfo() {
        System.out.println("Режиссёр: " + director.getName() + " " + director.getSurname());
    }

    public void printActorsList() {
        System.out.println("Актёры спектакля '" + title + "':");
        for (Actor actor : actors) {
            System.out.println("- " + actor.getName() + " " + actor.getSurname() +
                    " (рост: " + actor.getHeight() + " см)");
        }
    }

    public boolean addActor(Actor newActor) {
        if (newActor == null) {
            System.out.println("Ошибка: пытаемся добавить null-актёра!");
            return false;
        }

        for (Actor actor : actors) {
            if (actors.contains(newActor)) {
                System.out.println("Актёр уже существует!");
                return false;
            }
            actors.add(newActor);
            return true;
        }

        actors.add(newActor);
        System.out.println("Актёр " + newActor.getName() + " " +
                newActor.getSurname() + " успешно добавлен!");
        return true;
    }

    public boolean replaceActor(String oldActorSurname, Actor newActor) {
        if (oldActorSurname == null || oldActorSurname.isEmpty() || newActor == null) {
            System.out.println("Ошибка: некорректные входные данные!");
            return false;
        }

        for (int i = 0; i < actors.size(); i++) {
            Actor actor = actors.get(i);
            if (actor.getSurname().equalsIgnoreCase(oldActorSurname)) {
                Actor oldActor = actors.get(i);
                actors.set(i, newActor);
                System.out.println("Актёр " + oldActor.getName() + " " + oldActorSurname +
                        " заменён на " + newActor.getName() + " " + newActor.getSurname());
                return true;
            }
        }
        System.out.println("Актёр с фамилией '" + oldActorSurname + "' не найден.");
        return false;
    }

    public String getTitle() {
        return title;
    }
    public int getDuration() {
        return duration;
    }
    public Director getDirector() {
        return director;
    }
    public ArrayList<Actor> getActors() {
        return actors;
    }
}