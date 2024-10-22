// Insertion Sort
#include<stdio.h>

void insertionsort(int arr[],int n)
{
	int i,key,j;
	for(i=0;i<n;i++)
	{
		key=arr[i];
		j=i-1;
		 
		while(j>=0 && arr[j]>key)
		{
			arr[j+1]=arr[j];
		    j=j-1;
	    }
		arr[j+1]=key;
	}
}
void printArr(int arr[],int size)
{
	int i;
	for(i=0;i<size;i++)
	{
		printf("%d ",arr[i]);
	}
	printf("\n");
}

int main()
{
	int arr[]={20, 10, 28, 374, 62, 142, 2};
	int n=sizeof(arr)/sizeof(arr[0]);
	
	printf("original Array :\n ");
	printArr(arr,n);
	
	insertionsort(arr,n);
	printf("Sorted Array :\n ");
	printArr(arr,n);
	
	return 0;
}
