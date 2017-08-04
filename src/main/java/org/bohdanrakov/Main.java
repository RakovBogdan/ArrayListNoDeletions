package org.bohdanrakov;

public class Main {

    public static void main(String[] args) {

        ArrayListNoDeletions<Integer> list = new ArrayListNoDeletions<>();
        list.add(20);
        list.add(40);
        list.add(60);
        System.out.println(list);

        try {
            list.remove(2);
        } catch (UnsupportedOperationException e) {
            System.out.println("Removal is not supproted");
        }
    }
}
