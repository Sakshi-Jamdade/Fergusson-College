#include<stdio.h>

void Factorial(int num)
{
	int i,fact=1;
	for(i=1;i<=num;i++)
	{
		fact *= i;
	}
	printf("Factorial of %d is %d",num,fact);
}

void perfect(int num)
{
	int i,sum=0;
	for(i=1;i<=num;i++)
	{
		if(num%i == 0)
		{
			sum += i;
		//	printf("Is Perfect %d ",sum);
		}
	}
	if(sum==num)
	{
		printf("Is Perfect %d ",sum);
	}
	else
	{
		printf("Is Not Perfect");
	}
}

void Fibonaccie(int num)
{
 	int a=0,b=1,c,i;
 	for(i=0;i<num;i++)
 	{
 		printf("%2d",a);
	 	c=a+b;
	 	a=b;
	 	b=c;
    }
	printf("\n");
}

void Palindrome(int num)
{
	int rem,temp=0,a=num;
	while(num != 0)
	{
		rem= num % 10;
			printf("\n %d ",rem);
		temp=temp*10 + rem;
			printf("\n %d ",temp);
		num =num/10;
			printf("\n %d ",num);
	}
	if(temp==a)
	{
		printf("\n Is Palindrome %d ",temp);
	}
	else
	{
		printf("\n Is Not Palindrome");
	}
}

main()
{
	int num=616;
//	Factorial(num);
//	printf("\n");
//	perfect(num);
//		printf("\n");
//	Fibonaccie(num);
//	printf("\n");
	Palindrome(num);
}
