import java.util.*;

class MultiCache{

    HashMap<String,String> L1=new HashMap<>();
    HashMap<String,String> L2=new HashMap<>();

    String get(String id){

        if(L1.containsKey(id))
            return "L1 HIT";

        if(L2.containsKey(id)){
            L1.put(id,L2.get(id));
            return "L2 HIT -> promoted";
        }

        L2.put(id,"VideoData");
        return "DB HIT";
    }

    public static void main(String[] args){

        MultiCache c=new MultiCache();

        System.out.println(c.get("video1"));
        System.out.println(c.get("video1"));
    }
}