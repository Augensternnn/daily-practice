#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

  //��ӡ100~200֮�������
int main()
{
	int i, n, k, m = 0;
	for (i = 101; i <= 200; i = i + 2)
	{
		k = sqrt((float)i);
		for (n = 2; n <= k; n++)
		{
			if (i % n == 0)
				break;
		}
		if (n >= k + 1)
		{
			printf("%d  ", i);
			m = m + 1;
		}
		if (m % 10 == 0)
			printf("\n");
	}

	system("pause");
	return 0;
}
