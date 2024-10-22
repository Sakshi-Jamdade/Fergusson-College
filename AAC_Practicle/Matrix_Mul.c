#include<stdio.h>

int main()
{
	int a[3][3]={{1,1,1},{2,2,2},{3,3,3}};
	int b[3][3]={{1,1,1},{2,2,2},{3,3,3}};
	int c[3][3];
	int k;
	
	int i,j;
	
	for(i=0;i<3;i++)
	{
		for(j=0;j<3;j++)
		{
			c[i][j]=0;
			for(k=0;k<3;k++)
			{
				c[i][j] += a[i][k] * b[k][j];
			}
		}
	}
	
	printf("Result Of Multiplication : \n");
	for(i=0;i<3;i++)
	{
		for(j=0;j<3;j++)
		{
			printf(" %d ",c[i][j]);
		}
		printf("\n");
	}
	return 0;	
}
