import java.util.Arrays;
import java.util.PriorityQueue;

public class JobScheduling {


    public static void main(String[] args) {

        int L [][] = {
                {7,8},{3,7},{1,5},{5,9},{0,2},{6,8},{1,6}
        };
        Arrays.sort(L, (o1, o2) -> Integer.compare(o1[0], o2[0])); //Arrays 함수를 이용한 이차원배열을 정렬하는 코드
        System.out.println("정렬 후 출력\n----------------------------------------------");
        for(int i = 0; i< L.length;i++) {
            System.out.println(L[i][0]+ " "+ L[i][1]);
        }




        System.out.println("필요한 기계 대수는\n----------------------------------------------");





    }

}
