package ru.geekbrains.lesson6;

class Dog extends Animal {
    private static int count = 0;

    public Dog(String name) {
        super(name);
        count++;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public void run(int length) {
        if (length <= 0) System.out.println("Дистанция должна быть больше 0.");
        else if (length <= 500) System.out.printf("Пёс %s пробежал %d метров.\n", getName(), length);
        else System.out.println("Пёс заленился бежать.");
    }

    @Override
    public void swim(int length) {
        if (length <= 0) System.out.println("Дистанция должна быть больше 0.");
        else if (length <= 10) System.out.printf("Пёс %s проплыл %d метров.\n", getName(), length);
        else System.out.println("Собаки так далеко не плавают.");
    }
}
