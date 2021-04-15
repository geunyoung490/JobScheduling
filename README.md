# Greedy Algorithm
 단순하지만 가장 강력한 문제 해결 방법
 현재 상황에서 지금 당장 좋은 것만 고르는 방법
 
## Job Scheduling
 가장 적은 개수의 ```기계```를 사용하여 ```Task```간의 충돌이 발생하지 않도록 모든 작업을 기계에 할당
 
#### 알고리즘
 1. Task를 ```시작 시간을 기준```으로 ```오름차순```으로 정렬
 2. 순서대로 업무를 수행할 수 있는 기계가 있으면 기계에 배정
 3. 없으면 새로운 기계에 배정
 4. 들어간 Task는 List에서 제거

#### 문제요소
 - 작업의 수 (입력의 크기)
 - 각 작업의 시작 시간과 종료 시간 (작업의 길이 = 종료시간 - 시작시간)

---
### 알고리즘 코드
 1. 시작시간 오름차순으로 정렬
 ```
 Arrays.sort(L, (a,b) -> {
          if (a[0] != b[0]) return a[0] - b[0];
          else return a[1] - b[1];
        });
 ```
 
 2. Task를 기계에 배정
 ```
 if(M>0){
            for( i=0;i<M;i++){
                if(list[i].size()>0 && list[i].get(list[i].size()-1).finished<=start){
                    return i;
                }
            }
            M++;
            return i;
        }
        else{
            M++;
            return 0;
        }
    }
``` 
    
가장 이른 시작 시간을 가진 Task를 수행 시간이 중복되지 않게 수행 할 기계를 찾아서 배정</br>
수행 할 기계가 있으면 그 기계에 배정</br>
없으면 새로운 기계에 Task를 배정</br>
![KakaoTalk_20210413_160425218](https://user-images.githubusercontent.com/80522538/114818389-ae7ee700-9df6-11eb-8bca-a79b49fc3818.jpg)

    
3. 기계에 번호를 할당하고 업무 배정 
 ```
 while (i < n) {
            int machineNum = Operating(L[i][0]);
            list[machineNum].add(new Job());
            list[machineNum].get(list[machineNum].size()-1).start = L[i][0];
            list[machineNum].get(list[machineNum].size()-1).finished = L[i][1];
            i++;
        }
    }
 ```

---
### 전체 코드
```
import java.util.*;

class Job{
    int start;
    int finished;
}
public class JobScheduling {
    public static int L[][] = {{7,8},{3,7},{1,5},{5,9},{0,2},{6,8},{1,6}};
    public static ArrayList<Job>[] list = new ArrayList[5];
    public static int M=0;// 기계 수
    public static int Operating(int start){
        int i =0;
       
        if(M>0){
            for( i=0;i<M;i++){
               
                if(list[i].size()>0 && list[i].get(list[i].size()-1).finished<=start){
                    return i;
                }
            }   
            M++;
            return i;
        }
        else{
            M++;
            return 0;
        }
    }
    public static void Scheduling(int n) {
        for(int j =0; j<5 ;j++){
            list[j] = new ArrayList<Job>();
        }

        int i = 0;
        while (i < n) {
            int machineNum = Operating(L[i][0]);
            list[machineNum].add(new Job());
            list[machineNum].get(list[machineNum].size()-1).start = L[i][0];
            list[machineNum].get(list[machineNum].size()-1).finished = L[i][1];
            i++;
        }
    }

    public static void main(String[] arg){
        int n = 7;
        Arrays.sort(L, (a,b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            else return a[1] - b[1];
        });
        Scheduling(n);
        System.out.println("작업의 수: "+n);
        System.out.println("기계의 수: "+M);

        for(int i =0;i<M;i++){
            if(list[i].size()!=0)
            {
                System.out.println("기계번호: "+i);
                for(int j =0;j<list[i].size();j++){
                    System.out.print("["+list[i].get(j).start+", "+list[i].get(j).finished+"]  ");
                }
                System.out.println();
            }
        }
    }
}
```

#### 실행 결과
![KakaoTalk_20210413_160425138](https://user-images.githubusercontent.com/80522538/114818357-a4f57f00-9df6-11eb-9ac9-873241696d41.jpg)
![job결과](https://user-images.githubusercontent.com/80522538/114818363-a6bf4280-9df6-11eb-8bfe-fb0a7ed5041d.PNG)



#### 성능 비교
 - ```n개```의 Task를 정렬하는데 걸리는 시간 
    - ```O(nlogn)``` </br>
 - Task n개가 돌아가는 시간
    - ```O(mn)```

 -> 시간 복잡도는 ```O(nlogn) + O(mn)```이다.(m이 변수이므로 이대로 놔둔다.) 

  

