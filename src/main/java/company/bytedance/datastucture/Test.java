package company.bytedance.datastucture;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("aa");
        list.add("bb");
        list.push("sdkhf");
        list.addFirst("skhdfk");
        list.addLast("aaasaddsa");
        list.offer("skfhdsk");

        list.forEach(System.out::println);
    }
    
    
}
