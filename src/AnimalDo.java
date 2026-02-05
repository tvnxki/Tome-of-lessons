abstract class Animal {
    private static int totalCount = 0;
    private static int catsCount = 0;
    private static int dogsCount = 0;

    protected String name;

    public Animal(String name) {
        this.name = name;
        totalCount++;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public static int getTotalCount() {
        return totalCount;
    }

    public static int getCatsCount() {
        return catsCount;
    }

    public static int getDogsCount() {
        return dogsCount;
    }

    protected static void incrCatsCount() {
        catsCount++;
    }

    protected static void incrDogsCount() {
        dogsCount++;
    }

    public String getName() {
        return name;
    }
}

class Bowl {
    private int foodAmount; // текущее количество еды
    private final int capacity; // вместимость миски

    public Bowl(int capacity) {
        this.capacity = capacity;
        this.foodAmount = 0; // начинаем с пустой миски
    }


    public void addFood(int amount) {
        if (amount <= 0) {
            System.out.println("Нельзя добавить отрицательное количество еды");
            return;
        }

        if (foodAmount + amount > capacity) {
            System.out.println("Миска переполнена, Ее максимум: " + (capacity - foodAmount) + " еды");
            foodAmount = capacity;
        } else {
            foodAmount += amount;
        }
        System.out.println("В миску добавлено " + amount + " еды. Теперь в миске: " + foodAmount + " из " + capacity);
    }

    boolean takeFood(int amount) {
        if (amount <= 0) {
            System.out.println("Нельзя взять отрицательное количество еды!");
            return false;
        }

        if (amount > foodAmount) {
            System.out.println("В миске недостаточно еды, Нужно: " + amount + ", есть: " + foodAmount);
            return false;
        }

        foodAmount -= amount;
        System.out.println("Из миски взято " + amount + " еды. Осталось: " + foodAmount);
        return true;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public int getCapacity() {
        return capacity;
    }

    public void printInfo() {
        System.out.println("Миска: " + foodAmount + "/" + capacity + " еды");
    }
}

class Cat extends Animal {
    private static final int MAX_RUN_DISTANCE = 200;
    private final int appetite;
    private boolean isFull;

    public Cat(String name) {
        this(name, 10);
    }

    public Cat(String name, int appetite) {
        super(name);
        if (appetite < 0) {
            this.appetite = 10;
        } else {
            this.appetite = appetite;
        }
        this.isFull = false;
        incrCatsCount(); // Увеличиваем счетчик котов
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(name + " пробежал: " + distance + "м");
        } else {
            System.out.println(name + " не смог пробежать " + distance + "м, его максимум: " + MAX_RUN_DISTANCE + "м");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + "  к сожалению не научился плавать");
    }

    public void eat(Bowl bowl) {
        if (isFull) {
            System.out.print(name + " сытый, не голоден");
            return;
        }
        System.out.println(name + " подошел к миске");
        System.out.println("Аппетит " + name + ": " + appetite + " еды");

        if (bowl.takeFood(appetite)) {

            isFull = true;
            System.out.println(name + " поел и теперь сыт");
        } else {

            System.out.println(name + " не смог поесть и остался голодным");
        }
    }

    public boolean isFull() {
        return isFull;
    }

    public int getAppetite() {
        return appetite;
    }

    public void printSatiety() {
        String status = isFull ? "сыт" : "голоден";
        System.out.println(name + " - " + status + " (аппетит: " + appetite + ")");
    }
}

class Dog extends Animal {
    private static final int MAX_RUN_DISTANCE = 500;
    private static final int MAX_SWIM_DISTANCE = 10;

    public Dog(String name) {
        super(name);
        incrDogsCount();
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(name + " пробежал: " + distance + "м");
        } else {
            System.out.println(name + " не смог пробежать " + distance + "м, его максимум: " + MAX_RUN_DISTANCE + "м");
        }
    }

    public void swim(int distance) {
        if (distance <= MAX_SWIM_DISTANCE) {
            System.out.println(name + " проплыл: " + distance + "м");
        } else {
            System.out.println(name + " не смог проплыть, " + distance + "м, его максимум: " + MAX_SWIM_DISTANCE + "м");
        }
    }
}

public class AnimalDo {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Шарик");
        Dog dog2 = new Dog("Рекс");
        Cat cat1 = new Cat("Барсик");
        Cat cat2 = new Cat("Борис");

        System.out.println("\nБег животных:");
        dog1.run(250);
        dog2.run(501);
        cat1.run(150);
        cat2.run(201);

        System.out.println("\nПлавание:");
        dog1.swim(5);
        dog2.swim(11);
        cat1.swim(1);
        cat2.swim(1);
        System.out.println("\nСтатистика:");
        System.out.println("Всего животных: " + Animal.getTotalCount());
        System.out.println("Котов: " + Animal.getCatsCount());
        System.out.println("Собак: " + Animal.getDogsCount());

        Bowl bowl = new Bowl(50);
        bowl.printInfo();

        System.out.println("\nДобавляем еду в миску:");
        bowl.addFood(30);
        bowl.addFood(25);
        bowl.addFood(10);
        bowl.printInfo();

        Cat[] cats = {
                new Cat("Барон", 15),
                new Cat("Вася", 8),
                new Cat("Буся", 12),
                new Cat("Шура", 20),
                new Cat("Кеша")
        };

        System.out.println("\nКормим всех котов из одной миски:");
        bowl.printInfo();

        for (Cat cat : cats) {
            System.out.println("\n");
            cat.eat(bowl);
            bowl.printInfo();
        }

        System.out.println("\nСостояние котов:");
        for (Cat cat : cats) {
            cat.printSatiety();
        }
        bowl.printInfo();

        System.out.println("\nКормление уже сытых котов:");
        cats[0].eat(bowl);

        Bowl smallBowl = new Bowl(5);
        smallBowl.addFood(3);

        Cat hungryCat = new Cat("Голодный", 5);
        System.out.println("\nПопытка съесть больше, чем есть в миске:");
        hungryCat.eat(smallBowl);
        smallBowl.printInfo();

        System.out.println("\nДобавление отрицательное количество еды:");
        smallBowl.addFood(-5);

        System.out.println("\nСоздаем миску с нулевой вместимостью:");
        Bowl zeroBowl = new Bowl(0);
        zeroBowl.addFood(10);
    }
}





