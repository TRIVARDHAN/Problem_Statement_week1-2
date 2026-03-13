import java.util.*;

class FlashSale {

    HashMap<String,Integer> stock=new HashMap<>();
    Queue<Integer> waiting=new LinkedList<>();

    void addProduct(String id,int qty){
        stock.put(id,qty);
    }

    String purchase(String id,int user){

        int s=stock.get(id);

        if(s>0){
            stock.put(id,s-1);
            return "Success, remaining "+(s-1);
        }

        waiting.add(user);
        return "Added to waiting list position "+waiting.size();
    }

    public static void main(String[] args) {

        FlashSale f=new FlashSale();

        f.addProduct("IPHONE15",2);

        System.out.println(f.purchase("IPHONE15",101));
        System.out.println(f.purchase("IPHONE15",102));
        System.out.println(f.purchase("IPHONE15",103));
    }
}