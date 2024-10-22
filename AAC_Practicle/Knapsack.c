#include <stdio.h>

void fractionalKnapsack(int value[], int weight[], int n, int W)
{
    float ratio[n];
    
    // Calculate value-to-weight ratio for each item
    for (int i = 0; i < n; i++) {
        ratio[i] = (float)value[i] / weight[i];
    }

    float totalValue = 0.0; // To store the total value of the knapsack
    int currentWeight = 0;  // To track the current weight of the knapsack
    
    // Greedy approach: Take items with highest value-to-weight ratio first
    for (int i = 0; i < n; i++)
	{
        if (currentWeight + weight[i] <= W) 
		{
            currentWeight += weight[i];
            totalValue += value[i];
        } 
		else 
		{
            // If only part of the item can fit
            int remainingWeight = W - currentWeight;
            totalValue += value[i] * ((float)remainingWeight / weight[i]);
            break; // Knapsack is full
        }
    }

    // Output the result
    printf("Maximum value in Knapsack = %.2f\n", totalValue);
}

int main() {
    // Example input: value and weight arrays
    int value[] = {60, 100, 120};  // Values of the items
    int weight[] = {10, 20, 30};   // Weights of the items
    int n = 3;  // Number of items
    int W = 50; // Capacity of the knapsack

    // Call the function to solve the problem
    fractionalKnapsack(value, weight, n, W);

    return 0;
}

