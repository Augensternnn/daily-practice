#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>

//非递归分别实现求第n个斐波那契数
int main()
{
	int n, i, a1 = 1, a2 = 1, cout;
	scanf("%d", &n);
	if (n <= 0)
	{
		n = 0;
		printf("%d\n", n);
	}
	else if (n == 1 || n == 2)
	{
		n = 1;
		printf("%d\n", n);
	}
	else
	{
		for (i = 3; i <= n; i++)
		{
			cout = a1 + a2;
			a1 = a2;
			a2 = cout;
		}
		printf("%d\n", cout);
	}
	system("pause");
	return 0;
}
