import java.util.*;

class RateLimiter{

    HashMap<String,Integer> map=new HashMap<>();
    int limit=3;

    boolean check(String client){

        map.putIfAbsent(client,limit);

        int tokens=map.get(client);

        if(tokens>0){
            map.put(client,tokens-1);
            return true;
        }

        return false;
    }

    public static void main(String[] args){

        RateLimiter r=new RateLimiter();

        System.out.println(r.check("client1"));
        System.out.println(r.check("client1"));
        System.out.println(r.check("client1"));
        System.out.println(r.check("client1"));
    }
}