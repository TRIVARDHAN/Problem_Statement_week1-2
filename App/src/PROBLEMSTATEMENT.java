import java.util.*;

class UsernameChecker {

    HashMap<String,Integer> users = new HashMap<>();
    HashMap<String,Integer> attempts = new HashMap<>();

    boolean checkAvailability(String username){
        attempts.put(username,attempts.getOrDefault(username,0)+1);
        return !users.containsKey(username);
    }

    void register(String username,int id){
        users.put(username,id);
    }

    List<String> suggest(String username){
        List<String> list = new ArrayList<>();

        for(int i=1;i<=3;i++){
            String s=username+i;
            if(!users.containsKey(s))
                list.add(s);
        }

        return list;
    }

    String mostAttempted(){
        return Collections.max(attempts.entrySet(),
                Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {

        UsernameChecker u=new UsernameChecker();

        u.register("john_doe",1);

        System.out.println("john_doe available? "+u.checkAvailability("john_doe"));
        System.out.println("jane_smith available? "+u.checkAvailability("jane_smith"));

        System.out.println("Suggestions: "+u.suggest("john_doe"));
    }
}