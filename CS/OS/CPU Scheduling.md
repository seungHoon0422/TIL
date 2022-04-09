# CPU Scheduling


## Preemptive vs Non-Preemptive

---

- Preemptive (선점)
  CPU가 어느 프로세스를 실행하고 있는데(실행중인 프로세스가 종료되지도 않고, IO를 만난것도 아닌 상황) 실행중인 프로세스를 강제로 쫓아내고 새로운 것이 들어갈 수 있는 스케줄링 방식( 응급실이라고 생각하면 이해하기 편하다!)

- Non Preemptive (비선점)
 프로세스가 종료되거나, IO를 만나기 전에는 실행 프로세스의 변경을 허용하지 않는 방식( 은행 )



list
  - [Preemptive vs Non-Preemptive](#fifo-fcfsfirst-come-first-servced)
  - [FIFO, FCFS(First Come First Servced)](#-fifo-fcfsfirst-come-first-servced)
  - [SJF(Shortest Job First)](#-sjfshortest-job-first)
  - [SRTF(Shortest Remaining Time First)](#-srtfshortest-remaining-time-first)
  - [Round Robin(RR)](#-round-robinrr)
  - [Priority](#-priority)
  - [Multilevel Queue](#-multilevel-queue)
  - [Multilevel Feedback Queue](#-multilevel-feedback-queue)


## FIFO, FCFS(First Come First Servced)
---

- 작동 방식
  - **먼저 들어온 프로세스를 먼저 실행**

- 실행시간이 오래걸리는 프로세스가 앞에 있는 경우에 뒤에있는 프로세스들은 모두 기다리고 있어야하는 문제 발생

- 특징
  - Convoy Effect (호위효과) : 왕 뒤에 시중들이 따라다님. 다른 프로세스들이 시중들같이 따라다님
  - Nonpreemptive scheduling : 앞의 프로세스가 끝나야 뒤 프로세스가 진행


## SJF(Shortest Job First)

- 동작 방식
  - **실행시간이 짧은 프로세스를 먼저 실행**

- 특징
  - 대기시간을 줄여야한다는 관점에서는 SJF이 가장 좋다.
  - Provably optimal
  - Not realistic; prediction may be needed. 비현실적임. 예측을 해야 함
## SRTF(Shortest Remaining Time First)





## Round Robin(RR)





## Priority





## Multilevel Queue




## Multilevel Feedback Queue






