# JobScheduling

```java
import java.util.Arrays;

public class JobScheduling {
    public static void main(String[] args) {

        int L[][] = {
                {7, 8}, {3, 7}, {1, 5}, {5, 9}, {0, 2}, {6, 8}, {1, 6}
                //{시작시간,종료시간}
        };

        //이차원배열을 오름차순으로 정렬하는 코드
        Arrays.sort(L, (a1, a2) -> { //정렬이 목적이 아니기 때문에 Arrays 함수를 이용..
            if (a1[0] == a2[0]) {
                return a1[1] - a2[1]; //같은 시작시간일 경우 종료시간도 오름차순
            } else {
                return a1[0] - a2[0]; //시작시간 순 정렬
            }
        });

        System.out.println("주어진 작업들을 정렬 후 출력\n---------------");


        System.out.println("정렬된 일거리들은");
        for (int i = 0; i < L.length; i++) { //
            System.out.println("{" +L[i][0] + " " + L[i][1]+ "}" );
        }
        System.out.println("이다.\n이제 기계에 나눠서 일을 시키면\n");

        int M=1; // 기계 넘버

        int currentend = 0; //현재의 작업 종료시간을 처음에 0으로 설정해준다.

        for(int j = 0;  j<L.length; j++){
            currentend = 0; // 기계2에서 시작하는 남아있는 다음 작업의 시작시간이랑 비교할 수 있게 초기화 해준다.

            for(int i = 0; i<L.length;i++){

                if (currentend <= L[i][0]) {
                    System.out.println("기계" + M +"이  {"+ L[i][0]+" "+ L[i][1] + "} 작업을 수행한다.");
                    currentend = L[i][1];
                    L[i][0] = -1;// 이미 다른 기계가 맡은 일처리는 제거해버린다.
                    L[i][1] = -1;

                }
            }

            M++; //다른기계에 일을 준다. -> 기계넘버 올려서 다음 기계가 하게끔 한다.
        }


    }

}
```







## 출력결과

![캡처](C:\Users\Choi\Desktop\INU\2-1\컴퓨터알고리즘-김동훈\6주차\JobScheduling\캡처.JPG)