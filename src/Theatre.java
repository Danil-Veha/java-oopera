import java.util.ArrayList;

public class Theatre {
    public static void main(String[] args) {
        System.out.println("=== ТЕАТР: ПРОВЕРКА АРХИТЕКТУРЫ ===\n");

        // Пример 1: Обычный актер
        Actor actor1 = new Actor("Иван", "Иванов", Gender.MALE, 180.5);
        System.out.println("1. Обычный актер: " + actor1);

        // Пример 2: Актер-композитор
        Actor actor2 = new Actor("Сергей", "Рахманинов", Gender.MALE, 175.0);
        System.out.println("2. Актер-композитор: " + actor2);

        // Пример 3: Обычный режиссер
        Director director1 = new Director("Петр", "Режиссеров", Gender.MALE, 15);
        System.out.println("3. Обычный режиссер: " + director1);

        // Пример 4: Режиссер-хореограф
        Director director2 = new Director("Мариус", "Петипа", Gender.MALE, 25);
        System.out.println("4. Режиссер-хореограф: " + director2);

        // Пример 5: Режиссер-композитор-хореограф
        Director director3 = new Director("Леонид", "Мультиталантов", Gender.MALE, 30);
        System.out.println("5. Режиссер-композитор-хореограф: " + director3);

        System.out.println("\n=== СОЗДАНИЕ СПЕКТАКЛЕЙ ===");

        // Обычный спектакль - создаем пустой список актеров
        ArrayList<Actor> regularShowActors = new ArrayList<>();
        Show regularShow = new Show("Горе от ума", director1, regularShowActors, 120);
        regularShow.addActor(actor1);
        System.out.println("Обычный спектакль создан: " + regularShow.getTitle());

        // Создаем списки актеров для музыкальных спектаклей
        ArrayList<Actor> operaActors = new ArrayList<>();
        operaActors.add(actor1);
        operaActors.add(actor2);

        // Создаем Person для композиторов и хореографов
        Person composerVerdi = new Person("Джузеппе", "Верди", Gender.MALE);
        Person composerTchaikovsky = new Person("Пётр", "Чайковский", Gender.MALE);
        Person choreographerPetipa = new Person("Мариус", "Петипа", Gender.MALE);

        // Опера
        Opera opera = new Opera("Травиата", 150, director1,
                operaActors, composerVerdi, "Либретто оперы...", 30);
        System.out.println("\nОпера создана: " + opera.getTitle());
        System.out.println("Композитор: " + opera.getMusicAuthor());
        System.out.println("Размер хора: " + opera.getChoirSize());

        // Балет
        ArrayList<Actor> balletActors = new ArrayList<>();
        balletActors.add(actor1);
        balletActors.add(actor2);

        Ballet ballet = new Ballet("Лебединое озеро", 135, director2,
                balletActors, composerTchaikovsky, "Либретто балета...", choreographerPetipa);
        System.out.println("\nБалет создан: " + ballet.getTitle());
        System.out.println("Композитор: " + ballet.getMusicAuthor());
        System.out.println("Хореограф: " + ballet.getChoreographer());

        // Балет с режиссером-композитором-хореографом
        ArrayList<Actor> ballet2Actors = new ArrayList<>();
        ballet2Actors.add(actor1);

        Ballet ballet2 = new Ballet("Щелкунчик", 120, director3,
                ballet2Actors, null, "Либретто...", null);
        System.out.println("\nБалет2 создан: " + ballet2.getTitle());
        System.out.println("Композитор: " + ballet2.getMusicAuthor());
        System.out.println("Хореограф: " + ballet2.getChoreographer());

        System.out.println("\n=== ПРОВЕРКА МЕТОДОВ ===");

        // Проверка equals для актеров
        Actor actorA = new Actor("Иван", "Иванов", Gender.MALE, 180.0);
        Actor actorB = new Actor("Иван", "Иванов", Gender.MALE, 180.0);
        Actor actorC = new Actor("Иван", "Иванов", Gender.MALE, 175.0);
        Actor actorD = new Actor("Алексей", "Иванов", Gender.MALE, 178.0); // Однофамилец

        System.out.println("\n1. Проверка equals():");
        System.out.println("   actorA.equals(actorB): " + actorA.equals(actorB));
        System.out.println("   actorA.equals(actorC): " + actorA.equals(actorC));

        // Проверка добавления дубликата
        System.out.println("\n2. Проверка добавления дубликата:");
        ArrayList<Actor> testActors = new ArrayList<>();
        Show testShow = new Show("Тестовый спектакль", director1, testActors, 100);
        System.out.println("   Добавили actorA: " + testShow.addActor(actorA));
        System.out.println("   Попытка добавить actorB (дубликат): " + testShow.addActor(actorB));
        System.out.println("   Всего актеров в тестовом спектакле: " + testShow.getActors().size());

        // Проверка однофамильцев
        System.out.println("\n3. Проверка однофамильцев:");
        ArrayList<Actor> sameSurnameActors = new ArrayList<>();
        Show showWithSameSurname = new Show("Спектакль с однофамильцами", director1, sameSurnameActors, 90);
        showWithSameSurname.addActor(actorA);
        showWithSameSurname.addActor(actorC);
        showWithSameSurname.addActor(actorD);

        System.out.println("   Есть однофамильцы: " + showWithSameSurname.hasActorsWithSameSurname());

        System.out.println("\n4. Детальная информация об однофамильцах:");
        java.util.Map<String, java.util.List<Person>> sameSurname = showWithSameSurname.getActorsWithSameSurname();
        if (!sameSurname.isEmpty()) {
            System.out.println("   Найдены однофамильцы:");
            for (java.util.Map.Entry<String, java.util.List<Person>> entry : sameSurname.entrySet()) {
                System.out.println("   Фамилия: " + entry.getKey());
                for (Person actor : entry.getValue()) {
                    System.out.println("     - " + actor.getName() + " " +
                            actor.getSurname() +
                            (actor instanceof Actor ? " (рост: " + ((Actor)actor).getHeight() + ")" : ""));
                }
            }
        }

        // Проверка замены актера
        System.out.println("\n5. Проверка замены актера:");
        Actor newActor = new Actor("Новый", "Актер", Gender.MALE, 190.0);
        showWithSameSurname.addActor(newActor);
        System.out.println("   Актеры до замены:");
        showWithSameSurname.printActorsList();

        boolean replaced = showWithSameSurname.replaceActor(
                "Иванов", new Actor("Замена", "Актер", Gender.FEMALE, 170.0));
        System.out.println("   Замена актера Иванова: " + (replaced ? "успешно" : "не найден"));
        System.out.println("   Актеры после замены:");
        showWithSameSurname.printActorsList();

        // Проверка метода printLibretto()
        System.out.println("\n6. Проверка печати либретто:");
        opera.printLibretto();

        // Проверка метода printActorsList()
        System.out.println("\n7. Список актеров в опере:");
        opera.printActorsList();

        // Проверка метода printDirectorInfo()
        System.out.println("\n8. Информация о режиссере:");
        ballet.printDirectorInfo();

    }
}