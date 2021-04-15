# 1. Greedy Algorithm

## 1.1) 그리디 알고리즘이란?



 **탐욕 알고리즘**이라고도 불리며  최적화 문제를 해결하는 알고리즘으로 가능한 해들 중에서 가장 좋은 해를 찾는 알고리즘이다. 그래서 단순하지만 현재상황에서만큼은 알맞은 문제 해결 방법이다.

 최종적으로 봤을 때 최고의 선택이 아닐 수 있지만 현재 상황에서 지금 당장 좋은 것을 고르는 방법이다.  이러한 선택을 **근시안적인 선택**이라고 말하기도 한다.  

## 1.2) Job Scheduling

 가장 적은 개수의 ```기계```를 사용하여 ```Task```간의 충돌이 발생하지 않도록 모든 작업을 기계에 할당하는 알고리즘이다.
 ![KakaoTalk_20210415_132511618](https://user-images.githubusercontent.com/80522538/114818795-5a283700-9df7-11eb-99b2-046a6a5055c5.jpg)

### Job Scheduling 알고리즘 설계과정

  1. Task를 ```시작 시간```을 기준으로 ```오름차순```으로 정렬
  2. 순서대로 업무를 수행할 수 있는 기계가 있으면 기계에 배정
  3. 없으면 새로운 기계에 배정
  4. 들어간 Task는 List에서 제거



### 문제 요소

 - 작업의 수 (입력의 크기)
 - 각 작업의 시작 시간과 종료 시간 (작업의 길이 = 종료시간 - 시작시간)



# 2. 알고리즘 구현코드 

## 2.1) 알고리즘 코드(방법1)

#### 2.1.1) 세부 코드(방법1)



**1. 시작시간 오름차순으로 정렬**

 ```java
 Arrays.sort(L, (a,b) -> {
          if (a[0] != b[0]) return a[0] - b[0];
          else return a[1] - b[1];
        });
 ```



**2. Task를 기계에 배정**

 ```java
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



**3.기계에 번호를 할당하고 업무 배정** 

 ```java
 while (i < n) {
            int machineNum = Operating(L[i][0]);
            list[machineNum].add(new Job());
            list[machineNum].get(list[machineNum].size()-1).start = L[i][0];
            list[machineNum].get(list[machineNum].size()-1).finished = L[i][1];
            i++;
        }
    }
 ```



#### 2.1.2) 전체 코드(방법1)

```java
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



#### 2.1.3) 출력결과 (방법1)

![캡처](https://user-images.githubusercontent.com/75067408/114834643-b7c67e80-9e0b-11eb-8bed-24d8a0ca6459.JPG)



## 2.2) 알고리즘 코드(방법2)

#### 2.2.1) 세부 코드(방법2)

**1. 배열 초기화 및 배열정렬**

```java
public static void main(String[] args) {

    int L[][] = {
            {7, 8}, {3, 7}, {1, 5}, {5, 9}, {0, 2}, {6, 8}, {1, 6}
    };
    Arrays.sort(L, (a1, a2) -> {
        if (a1[0] == a2[0]) {
            return a1[1] - a2[1];
        } else {
            return a1[0] - a2[0];
        }
    });
```



**2. 일거리들을 각 기계에 배정하여 출력**

```java
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
```



### 2.2.2) 전체코드(방법2) 

```java
//2021.04.10 오름차순 정렬코드 작성, 출력
//2021.04.12 while문 미완성 출력 이상하게 나옴...우선순위큐로 다시 짜야 할 듯
//2021.04.13 수정 필요할 듯 하다.
//2021.04.14 정답이 맞는지는 모르겠으나 출력은 잘 된다.

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
        
        System.out.println("이다.\n이제 기계에 나눠서 일을 시키면\n");
        int M=1;
        int currentend = 0;
        for(int j = 0;  j<L.length; j++){
            currentend = 0;
            for(int i = 0; i<L.length;i++){
                if (currentend <= L[i][0]) {
                    System.out.println("기계" + M +"이  {"+ L[i][0]+" "+ L[i][1] + "} 작업을 수행한다.");
                    currentend = L[i][1];
                    L[i][0] = -1;
                    L[i][1] = -1;
                }
            }
        }
    }
}
```



### 2.2.3) 출력결과(방법2)



![캡처](https://user-images.githubusercontent.com/75067408/114834885-f6f4cf80-9e0b-11eb-8f93-60a4543bf9dd.JPG)



## 3. 알고리즘 구현결과

 ![컴알작업](https://user-images.githubusercontent.com/80522538/114829508-21438e80-9e06-11eb-8231-33a005ddbf2d.jpg)



## 4. 시간복잡도 알고리즘 성능비교

 - **```n개```의 Task를 정렬하는데 걸리는 시간**

   - **```O(nlogn)``` </br>**

 - **Task n개가 돌아가는 시간**

   - **```O(mn)```**

   **-> 시간 복잡도는 ```O(nlogn) + O(mn)```이다.(m이 변수이므로 이대로 놔둔다.) **

  
