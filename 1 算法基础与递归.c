1����Ǯ��׼�
���룺
//�����ڵĴ���

#include <stdio.h>

int main(){

              //����iֻ��ĸ��jֻ 

    int i, j;

    for(i=1;i<20;i++){

        for(j=1;j<34;j++){

                      if(5*i+3*j+(100-i-j)/3==100 && (100-i-j)%3 ==0 && (i+j)<100){

                                    printf("������%d,ĸ����%d,С����%d\n",i,j,100-i-j);

                      }

        }

    }

              return 0;

}

 
 

 




�㷨������
�蹫��Ϊiֻ��ĸ��jֻ�������Ϊ100-i-jֻ,���У�i>0,j>0,i+j<100,(100-i-j)%3==0��

���������г���ʽ��5*i+3*j+(100-i-j)%3==0����������������

��������㷨����������

2�����Լ��
���룺
C�ݹ����

//�����ڵĴ��� 

#include <stdio.h>

 

int gcd(int m,int n);

 

int main(){

start: 

              int m,n; 

              printf("��������������:"); 

              scanf("%d,%d",&m,&n); 

              printf("���Լ��:%d\n",gcd(m,n));

              goto start;

              return 0;

}

 

int gcd(int m,int n){ 

              if(m>n)

              return gcd(m-n,n); 

              else if(m<n)  

              return gcd(m,n-m); 

              else if(m==n)  

              return m; 

}

 

 
 

 

C�ǵݹ����

//�����ڵĴ��� 

#include <stdio.h>

int main()

{ 

start:

  int a,b,t,i,k;

 

  printf("please enter a,b:");

  scanf("%d,%d",&a,&b);

 

  if(a<b) 

  {t=a;a=b;b=t;}

  if(!(a%b))   

                printf("���Լ����%d\n",b);

  else   

      {

         for(i=1;i<b;i++)

                   if((!(a%i))&&(!(b%i)))

                              k=i;

         printf("���Լ����%d\n",k);

      }

  goto start;

return 0;

}

 
 

 

��



�㷨����
�����Լ���ķǵݹ��㷨���ȱȽ�������������Ĵ�С������С����Ϊѭ���߽磬����((a%i)==0)&&(!(b%i)==0)���� ����������㷨������������Լ��

�����Լ���ĵݹ��㷨�����֣�һ����շת���������һ����շת�������

 

շת��������裺

�ô�����ȥС����

��С����ǰ���򽻻���������

ֱ������������Ϊ�㣻

 

շת��������裺

����С��һ���������һ�������õ�һ��������

���õ�һ��������С��һ�������õڶ���������

���õڶ�����������һ���������õ�����������

 

���㷨˼���Ͽ������߲�û�б����ϵ����𣬵����ڼ�������У��������һ�����ܴ���һ�����Ƚ�С�����������Ҫ���кܶ�μ������ܴﵽһ�γ�����Ч�����Ӷ�ʹ���㷨��ʱ�临�Ӷ��˻�ΪO(N)������N��ԭ�ȵ��������нϴ��һ�������֮�£�շת�������ʱ�临�Ӷ��ȶ���O(logN)��

�ݹ���ǵݹ�Ƚϣ�

����С������Сʱ���ǵݹ��ѭ���������ܻ�С�ڵݹ���ô�������ʱ��ѡ��ǵݹ��㷨����Ч��

����С�����ܴ�ʱ���ǵݹ��㷨��ѭ����������ڵݹ���ô��������£�ѡ�õݹ��㷨����Ч��

3��쳲�����������
���룺
C�ݹ����

//�����ڵĴ��� 

#include<stdio.h>

int fib(int n){

              if(n==0 || n==1){

                            return 1;                            

              }else{

                            return fib(n-1)+fib(n-2);

              }

}

 

int main(){

start:              

              int n;

              

              printf("please input n:");

              scanf("%d",&n);

              

              printf("result:%d\n",fib(n));

              goto start;

              return 0;

 

}

 
 

 

C�ǵݹ����

//�����ڵĴ��� 

#include<stdio.h>

int main()

{

  start:

  int i,n,f1=1,f2=1,f3;

 

  printf("������n��");

  scanf("%d",&n);

 

  for(i=0;i<n-1;i++)

      {

      f3=f2+f1;

                f1=f2;  //���߲��ܵߵ�˳��

      f2=f3;

      }

  if(n<=1)

                printf("1\n");

  else

      printf("%d\n",f3);

  goto start;

  return 0;

}

 

�㷨����
쳲��������еĹ����:

0
 1
 2
 3
 4
 5
 ��
 
1
 1
 2
 3
 5
 8
 ��
 

�ǵݹ��㷨��

��n==0||n==1ʱ��f(n)=1

��n>1ʱ�������¹���ѭ����

f3=f2+f1;

f1=f2;  

f2=f3;

�ݹ��㷨��

1��     n==0||n==1:

f(n)=1;

2��n>1��

f(n)=f(n-1)+f(n-2)

�Ƚϣ�

�ǵݹ�ʱ�临�Ӷȣ� O(n)

�ݹ�ʱ�临�Ӷȣ�O(2n)

����n���󣬵ݹ�Ч�ʼ����½���

4����ŵ��
C����
//�����ڵĴ��� 

//hanoi�ݹ��㷨

#include <stdio.h>

void move(char x,char y){

   printf("%c-->%c\n",x,y);

}

 

//��n���̴�one������two�����Ƶ�three��

void hanoi(int n,char one,char two,char three){

 

  if(n==1) move(one,three);

 

  else{

                //��n-1�����Ӵ�one���ƶ���two��������three���� 

    hanoi(n-1,one,three,two);

    //���������Ӵ�one���ƶ���three�� 

    move(one,three);

    //��n-1�����Ӵ�two���ƶ���three��������one�� 

    hanoi(n-1,two,one,three);

  }

}

 

int main(){

  int m;

  printf("please input the number of diskes:");

  scanf("%d",&m);

 

  printf("The step to moving %3d diskes:\n",m);

  hanoi(m,'A','B','C');

return 0;

}

 

�㷨����
hanoi������������������⣬

���·�Ϊ������

1����n-1�����Ӵ�one���ƶ���two��������three���� 

   2�����������Ӵ�one���ƶ���three�� 

3����n-1�����Ӵ�two���ƶ���three��������one�� 

    �Դ˹���ݹ顣

 
