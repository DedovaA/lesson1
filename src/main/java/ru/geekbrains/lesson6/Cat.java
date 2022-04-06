package ru.geekbrains.lesson6;

class Cat extends Animal {
    private static int count = 0;

    public Cat(String name) {
        super(name);
        count++;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public void run(int length) {
        if (length <= 0) System.out.println("Дистанция должна быть больше 0.");
        else if (length <= 200) System.out.printf("Кот %s пробежал %d метров.\n", getName(), length);
        else System.out.println("Кот заленился бежать.");
    }

    @Override
    public void swim(int length) {
        System.out.println("Коты не любят плавать.");
    }

}
