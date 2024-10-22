#include <stdio.h>

void magicSquare(int n)
{
    int temp[n][n];
    int c = n / 2;
    int r = 0;

    // Initializing the matrix to zero
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            temp[i][j] = 0;
        }
    }

    // Filling the magic square
    for (int i = 1; i <= n * n; i++)
    {
        temp[r][c] = i;
        int nr = ((n + r) - 1) % n;
        int nc = ((n + c) - 1) % n;

        if (temp[nr][nc] != 0)
        {
            r = (r + 1) % n;
        }
        else
        {
            r = nr;
            c = nc;
        }
    }

    // Printing the magic square
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            printf("%d ", temp[i][j]);
        }
        printf("\n");
    }
}

int main()
{
    int n;
    scanf("%d", &n);
    if (n % 2 != 0)
    {
        magicSquare(n);
    }
    return 0;
}

