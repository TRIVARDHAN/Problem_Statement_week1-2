class Parking{

    String[] table=new String[10];

    int hash(String plate){
        return Math.abs(plate.hashCode())%table.length;
    }

    int park(String plate){

        int i=hash(plate);

        while(table[i]!=null)
            i=(i+1)%table.length;

        table[i]=plate;
        return i;
    }

    public static void main(String[] args){

        Parking p=new Parking();

        System.out.println("Spot "+p.park("ABC123"));
        System.out.println("Spot "+p.park("XYZ999"));
    }
}