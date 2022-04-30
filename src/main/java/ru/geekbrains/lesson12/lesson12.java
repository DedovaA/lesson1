package ru.geekbrains.lesson12;

public class lesson12 {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) throws InterruptedException {
        method1();
        method2();

    }

    private static float[] createFloatArray(int size) {
        float[] arr = new float[size];
        for(int i=0; i< arr.length; i++) {
            arr[i]=1;
        }
        return arr;
    }

    private static void calculate(float[] arr) {
        for(int i = 0; i< arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }


    static void method1 () {
        float[] arrFull = createFloatArray(SIZE);
        long start = System.currentTimeMillis();
        calculate(arrFull);
        System.out.println(System.currentTimeMillis()-start);
    }



    static void method2 () throws InterruptedException {
        float[] arrFull = createFloatArray(SIZE);

        long start = System.currentTimeMillis();

        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];
        System.arraycopy(arrFull, 0, arr1, 0, HALF);
        System.arraycopy(arrFull, HALF, arr2, 0, HALF);

        Thread thread1 = new Thread(() -> calculate(arr1));
        Thread thread2 = new Thread(() -> calculate(arr2));

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.arraycopy(arr1, 0, arrFull, 0, HALF);
        System.arraycopy(arr2, 0, arrFull, HALF, HALF);

        System.out.println(System.currentTimeMillis()-start);
    }


}
