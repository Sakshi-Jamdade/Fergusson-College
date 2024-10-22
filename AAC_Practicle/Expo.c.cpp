#include <stdio.h>

long long power(long long x, int n) 
{
    long long result = 1;
    while (n > 0) 
	{
        if (n % 2 == 1) 
		{
            result *= x;  // Multiply result by x when n is odd
        }
        x *= x;  // Square the base
        n /= 2;  // Divide n by 2
    }
    return result;
}

int main() 
{
    long long x = 2;
    int n = 10;
    printf("%lld^%d = %lld\n", x, n, power(x, n));
    return 0;
}
