import java.util.*;

class Analytics {

    HashMap<String,Integer> views=new HashMap<>();
    HashMap<String,Set<String>> visitors=new HashMap<>();
    HashMap<String,Integer> source=new HashMap<>();

    void event(String url,String user,String src){

        views.put(url,views.getOrDefault(url,0)+1);

        visitors.putIfAbsent(url,new HashSet<>());
        visitors.get(url).add(user);

        source.put(src,source.getOrDefault(src,0)+1);
    }

    void show(){

        System.out.println("Views "+views);
        System.out.println("Unique "+visitors);
        System.out.println("Sources "+source);
    }

    public static void main(String[] args){

        Analytics a=new Analytics();

        a.event("/news","user1","google");
        a.event("/news","user2","facebook");
        a.event("/sports","user1","direct");

        a.show();
    }
}