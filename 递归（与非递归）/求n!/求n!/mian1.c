#define _CRT_SECURE_NO_WARNINGS 1
#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>

//递归分别实现求n!
int mul(int n)
{
	if (n == 0 || n == 1)
		return 1;
	else
		return n * mul(n - 1);
}

int main1()
{
	int n;
	scanf("%d", &n);
	printf("%d\n", mul(n));
	system("pause");
	return 0;
}
