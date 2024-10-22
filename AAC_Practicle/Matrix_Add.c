#include<stdio.h>

int main()
{
	int a[3][3]={{1,2,3},{4,5,6},{7,8,9}};
	int b[3][3]={{17,8,9},{4,15,6},{1,2,3}};
	int c[3][3];
	
	int i,j;
	
	for(i=0;i<3;i++)
	{
		for(j=0;j<3;j++)
		{
			c[i][j]=a[i][j]+b[i][j];
		}
	}
	printf("Result Of Addition: \n");
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
