package TimeSorter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String stringNumber = in.nextLine();
        int n = Integer.parseInt(stringNumber);
        List<Time> ListOfTimes = new ArrayList<>();
        for(int i = 0; i<n; i++){
            String[] stringTime = in.nextLine().split(" ");
            ListOfTimes.add(new Time(toInteger(stringTime[0]), toInteger(stringTime[1]), toInteger(stringTime[2])));
        }
        List<Time> result = Time.sort(ListOfTimes);
        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }
    }

    public static int toInteger(String string){
        return Integer.parseInt(string);
    }
}
