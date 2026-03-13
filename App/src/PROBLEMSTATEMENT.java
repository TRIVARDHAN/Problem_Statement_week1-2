import java.util.*;

class TwoSum{

    static void find(int[] arr,int target){

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int x:arr){

            int c=target-x;

            if(map.containsKey(c))
                System.out.println(c+" + "+x+" = "+target);

            map.put(x,1);
        }
    }

    public static void main(String[] args){

        int[] t={500,300,200};

        find(t,500);
    }
}