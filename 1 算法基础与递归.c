1、百钱买白鸡
代码：
//王晓腾的代码

#include <stdio.h>

int main(){

              //公鸡i只，母鸡j只 

    int i, j;

    for(i=1;i<20;i++){

        for(j=1;j<34;j++){

                      if(5*i+3*j+(100-i-j)/3==100 && (100-i-j)%3 ==0 && (i+j)<100){

                                    printf("公鸡：%d,母鸡：%d,小鸡：%d\n",i,j,100-i-j);

                      }

        }

    }

              return 0;

}

 
 

 




算法分析：
设公鸡为i只，母鸡j只，则雏鸡为100-i-j只,其中（i>0,j>0,i+j<100,(100-i-j)%3==0）

根据题意列出等式：5*i+3*j+(100-i-j)%3==0，结合上面的条件，

利用穷举算法即可求出结果

2、最大公约数
代码：
C递归代码

//王晓腾的代码 

#include <stdio.h>

 

int gcd(int m,int n);

 

int main(){

start: 

              int m,n; 

              printf("请输入两个整数:"); 

              scanf("%d,%d",&m,&n); 

              printf("最大公约数:%d\n",gcd(m,n));

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

 

 
 

 

C非递归代码

//王晓腾的代码 

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

                printf("最大公约数：%d\n",b);

  else   

      {

         for(i=1;i<b;i++)

                   if((!(a%i))&&(!(b%i)))

                              k=i;

         printf("最大公约数：%d\n",k);

      }

  goto start;

return 0;

}

 
 

 

：



算法分析
求最大公约数的非递归算法，先比较输入的两个数的大小，将较小的作为循环边界，根据((a%i)==0)&&(!(b%i)==0)条件 ，利用穷举算法，即可求得最大公约数

求最大公约数的递归算法有两种，一种是辗转相减法，另一种是辗转相除法。

 

辗转相减法步骤：

用大数减去小数；

若小数在前，则交换这两个；

直到两数相减结果为零；

 

辗转相除法步骤：

先用小的一个数除大的一个数，得第一个余数；

再用第一个余数除小的一个数，得第二个余数；

又用第二个余数除第一个余数，得第三个余数；

 

从算法思想上看，两者并没有本质上的区别，但是在计算过程中，如果遇到一个数很大，另一个数比较小的情况，可能要进行很多次减法才能达到一次除法的效果，从而使得算法的时间复杂度退化为O(N)，其中N是原先的两个数中较大的一个。相比之下，辗转相除法的时间复杂度稳定于O(logN)。

递归与非递归比较：

当较小的数很小时，非递归的循环次数可能会小于递归调用次数，此时，选择非递归算法更高效。

当较小的数很大时，非递归算法的循环次数会大于递归调用次数，此事，选用递归算法更高效。

3、斐波那契级数列
代码：
C递归代码

//王晓腾的代码 

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

 
 

 

C非递归代码

//王晓腾的代码 

#include<stdio.h>

int main()

{

  start:

  int i,n,f1=1,f2=1,f3;

 

  printf("请输入n：");

  scanf("%d",&n);

 

  for(i=0;i<n-1;i++)

      {

      f3=f2+f1;

                f1=f2;  //二者不能颠倒顺序

      f2=f3;

      }

  if(n<=1)

                printf("1\n");

  else

      printf("%d\n",f3);

  goto start;

  return 0;

}

 

算法分析
斐波那契数列的规则表:

0
 1
 2
 3
 4
 5
 …
 
1
 1
 2
 3
 5
 8
 …
 

非递归算法：

当n==0||n==1时：f(n)=1

当n>1时，按如下规则循环：

f3=f2+f1;

f1=f2;  

f2=f3;

递归算法：

1、     n==0||n==1:

f(n)=1;

2、n>1：

f(n)=f(n-1)+f(n-2)

比较：

非递归时间复杂度： O(n)

递归时间复杂度：O(2n)

随着n增大，递归效率急剧下降。

4、汉诺塔
C代码
//王晓腾的代码 

//hanoi递归算法

#include <stdio.h>

void move(char x,char y){

   printf("%c-->%c\n",x,y);

}

 

//将n个盘从one座借助two座，移到three座

void hanoi(int n,char one,char two,char three){

 

  if(n==1) move(one,three);

 

  else{

                //将n-1个盘子从one座移动到two座，借助three座， 

    hanoi(n-1,one,three,two);

    //将最大的盘子从one座移动到three座 

    move(one,three);

    //将n-1个盘子从two座移动到three座，借助one座 

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

 

算法分析
hanoi的问题解决讲求整体理解，

大致分为三步：

1、将n-1个盘子从one座移动到two座，借助three座， 

   2、将最大的盘子从one座移动到three座 

3、将n-1个盘子从two座移动到three座，借助one座 

    以此规则递归。

 
