package org.nik.datastructure;

public class DataStructureMain {

    public static void main(String[] args) {

        LinkedList<String> linkedList = new LinkedList<String>();
        System.out.println(linkedList.add("Nikhlanshu"));
        System.out.println(linkedList.add("Siya"));
        System.out.println(linkedList.add("Sarojini"));
        System.out.println(linkedList.add("NikhlanshuSiya"));
        System.out.println(linkedList.add("ABC"));
        linkedList.display();
        System.out.println(linkedList.getSize());//5
        System.out.println(linkedList.remove("Nikhlanshu"));
        linkedList.display();//4
        System.out.println(linkedList.getSize());//4
        System.out.println(linkedList.remove("ABC"));//3
        linkedList.display();//3
        System.out.println(linkedList.getSize());//3
        System.out.println(linkedList.remove("Sarojini"));//2
        linkedList.display();//2
        System.out.println(linkedList.getSize());//2
        System.out.println(linkedList.remove("abc"));//false
        linkedList.display();//2
        System.out.println(linkedList.getSize());//2
    }
}
