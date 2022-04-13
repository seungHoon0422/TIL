# CPU Scheduling

  
## CPU Scheduler

운영체제 안에서 CPU 스케줄링을 하는 코드가 있는 부분. Ready 상태의 프로세스 중 누구한테 CPU를 줄지 결정한다.

## Dispatcher

CPU를 누구한테 줄지 결정됐으면 실제로 그 프로세스에 CPU를 넘겨주는 역할을 하는 운영체제 커널 코드
(현재 돌아가고 있는 프로세스의 context를 저장하고 새로 CPU를 넘겨줄 프로세스의 context를 가져온다.)







## Scheduling Criteria (스케줄링 척도)

- 시스템 입장(CPU 하나로 최대한 일을 많이 시키면 좋은 것)

  - CPU Utilization (CPU 이용률) : 전체 시간 중에서 CPU가 놀지 않고 일한 시간의 비율

  - Throughput (처리율) : 단위 시간당 CPU의 처리량을 의미, 시간당 몇 개의 작업을 처리하는가

- 프로세스 입장(CPU를 빨리 얻어서 빨리 끝나면 좋은 것)

  - Turnaround time (반환시간, 소요시간) : 작업이 레디큐에 들어가서 다쓰고 나오는데까지 걸리는 시간, 짧아야 좋음

  - Waiting time (대기시간) : CPU가 서비스를 받기 위해 Ready Queue에서 얼마나 기다렸는가를 의미

  - Response time (응답시간) : 가장 처음 CPU를 잡게 되는 시간


## Preemptive vs Non-Preemptive


- Preemptive (선점)

    - CPU가 어느 프로세스를 실행하고 있는데(실행중인 프로세스가 종료되지도 않고, IO를 만난것도 아닌 상황) 실행중인 프로세스를 강제로 쫓아내고 새로운 것이 들어갈 수 있는 스케줄링 방식( 응급실이라고 생각하면 이해하기 편하다!)

    - ex) SRTF, RR



- Non Preemptive (비선점)

  - 프로세스가 종료되거나, IO를 만나기 전에는 실행 프로세스의 변경을 허용하지 않는 방식( 은행 )

  - ex) FCFS, SJF, Priority




### List
  - [FIFO, FCFS(First Come First Servced)](#fifo-fcfsfirst-come-first-servced)
  - [SJF(Shortest Job First)](#sjf-srtf)
  - [SRTF(Shortest Remaining Time First)](#srtfshortest-remaining-time-first)
  - [Round Robin(RR)](#round-robinrr)
  - [Priority](#priority)
  - [Multilevel Queue](#multilevel-queue)
  - [Multilevel Feedback Queue](#multilevel-feedback-queue)


## FIFO, FCFS(First Come First Servced)

**작동 방식**
- 먼저 들어온 프로세스를 먼저 실행


가장 간단한 스케쥴링 정책이다. 프로세서를 먼저 요청한 프로세스에게 할당하는 방식이다. 비선점인 데다 실행 순서에 대한 정책이 없어 스케쥴러 큐에 들어온 순서대로 프로세스를 실행한다. 

실행시간이 오래걸리는 프로세스가 앞에 있는 경우에 뒤에있는 프로세스들은 모두 기다리고 있어야하는 문제 발생

**특징**
- Convoy Effect (호위효과) : 왕 뒤에 시중들이 따라다님. 다른 프로세스들이 시중들같이 따라다님
- Nonpreemptive scheduling : 앞의 프로세스가 끝나야 뒤 프로세스가 진행

<br>

## SJF, SRTF

- 작동 방식
  - **실행시간이 짧은 프로세스를 먼저 실행**

- Bust Time : 실제 프로세스가 실행되어 CPU를 사용하는 시간


- SJF(Shortest Job First)
> CPU의 Burst Time이 짧은 프로세스에게 프로세서를 우선 할당하는 정책이다. 중요한 것은 Burst Time을 이용한다는 점으로, 프로세스의 전반적인 실행시간이 아니라 실제로 프로세서를 이용하는 시간이 가장 짧은 프로세스부터 실행하여 효율을 높인 정책이다. 만약 스케쥴링 대상의 프로세스들이 모두 같은 Burst Time을 갖고 있다면 FCFS(First-Come-First-Served) 정책을 따른다.


-  SRTF(Shortest Remaining Time First) 
  > SJF에 선점 정책을 도입한 것이라 이해한다.
  > 잦은 프로세스 잔여 실행시간을 계산(clock cycle마다 측정)해야 하고 이에 따른 컨텍스트 전환이 발생하면 그로 인한 오버헤드가 증가할 수 밖에 없다. 따라서 현실적으로 구현 및 사용이 어려운 정책이다.


**특징**
  - 대기시간을 줄여야한다는 관점에서는 SJF이 가장 좋다.
  - optimal
  - Not realistic; prediction may be needed. 비현실적임. 예측을 해야 함


<br>

## Round Robin(RR)

**작동 방식**
- clock cycle마다 다른 프로세스 실행


**특징**
- Preemptive Scheduling : 선점 스케쥴링의 대표, clock cycle마다 실행하는 프로세스를 번경시킨다.
- clock cycle을 짧게하여 모든 프로세스가 공평하게 cpu를 사용하면 좋지만, 프로세스를 변경하는 과정(실행중인 프로세스의 데이터를 저장하고, 새로운 프로세스 정보를 읽어오는 과정)에서 발생하는 오버헤드를 무시할 수 없다.

<br>

## Priority

**작동 방식**
- 우선순위가 높은 프로세스 실행
  

**특징**
- 우선순위 스케쥴링은 간단하다. 각각의 프로세스에 우선순위가 있고 이 우선순위를 판별하여 우선순위가 더 높다고 판단되는 프로세스가 가장 먼저 프로세서를 할당받는다. 

- 프로세스 우선순위는 커널이 결정하거나 커널 외부에서 결정하기도 하며, 우선순위를 나타내는 값이 작은 수를 지향하는지 큰 수를 지향하는 지는 운영체제에 따라 다르다.

- 이런 우선순위 스케쥴링의 가장 큰 문제점은 **기아 현상**이다. **SJF(Shortest Job First)**에도 공통적인 문제로서 우선순위가 상대적으로 낮은 프로세스가 계속해서 실행되지 못하는 현상이다.

이를 해결하는 기법은 **에이징(Aging) 기법**으로, 일정 시간이 지나면 기아 상태에 빠질 것으로 예상되는 프로세스의 우선순위를 높이는 기법이다.





<br>

## Multilevel Queue

**작동 방식**
- 


**특징**
- 


<br>

## Multilevel Feedback Queue

**작동 방식**
- 


**특징**
- 





