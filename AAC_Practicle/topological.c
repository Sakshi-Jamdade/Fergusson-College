#include <stdio.h>
#include <stdlib.h>

#define MAX 100

int adj[MAX][MAX], visited[MAX], stack[MAX];
int top = -1, V;

void addEdge(int start, int end) 
{
    adj[start][end] = 1;
}

void topologicalSortUtil(int v) 
{
    visited[v] = 1;
    int i;
    
    for (i = 0; i < V; i++)
	{
        if (adj[v][i] && !visited[i]) 
		{
            topologicalSortUtil(i);
        }
    }
    
    stack[++top] = v;
}

void topologicalSort() 
{
    int i;
    for (i = 0; i < V; i++) 
	{
        if (!visited[i]) 
		{
            topologicalSortUtil(i);
        }
    }
    
    while (top != -1) 
	{
        printf("%d ", stack[top--]);
    }
}

int main() {
    V = 6;
    
    addEdge(5, 2);
    addEdge(5, 0);
    addEdge(4, 0);
    addEdge(4, 1);
    addEdge(2, 3);
    addEdge(3, 1);
    
    printf("Topological sort of the graph:\n");
    topologicalSort();
    
    return 0;
}

