// Selection Sort
#include<stdio.h>
void selectionSort(int arr[],int n)
{
	int i,j,min,temp;
	for(i=0;i<n;i++)
	{
		min=i;
		for(j=i+1;j<n;j++)
		{
			if(arr[j]<arr[min])
			min=j;
		}
		if(min!=i)
		{
			temp=arr[min];
			arr[min]=arr[i];
			arr[i]=temp;
		}
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
	int arr[]={374, 62, 142, 220, 10, 28, };
	int n=sizeof(arr)/sizeof(arr[0]);
	
	printf("original Array :\n ");
	printArr(arr,n);
	
	selectionSort(arr,n);
	printf("Sorted Array :\n ");
	printArr(arr,n);
	
	return 0;
} 
