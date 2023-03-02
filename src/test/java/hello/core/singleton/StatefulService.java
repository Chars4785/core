package hello.core.singleton;

public class StatefulService {
//    private int price; // 상태를 유지하는 필드
//
//    public void order(String name, int price){
//        System.out.println("name = " + name);
//        this.price = price;
//    }
//
//    public int getPrice() {
//        return price;
//    }

    // 무상태로 개발
    public int order(String name, int price){
        System.out.println("name = " + name);
        return price;
    }
}
