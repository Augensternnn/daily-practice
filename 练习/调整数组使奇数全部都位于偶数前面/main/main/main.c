#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>
//��������ʹ����ȫ����λ��ż��ǰ��
//����һ���������飬ʵ��һ������,�����������������ֵ�˳��ʹ�����������е�����λ�������ǰ�벿��,����ż��λ������ĺ�벿�֡�
int main()
{
	int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
	int s[10] = { 0 };
	int d[10] = { 0 };
	int i, counts = 0, countd = 0;
	for (i = 0; i < 10; i++)
	{
		if (arr[i] % 2)
			s[counts++] = arr[i];
		else
			d[countd++] = arr[i];
	}
	for (i = 0; i < counts; i++)
	{
		arr[i] = s[i];
	}
	for (i = 0; i < countd; i++)
	{
		arr[counts + i] = d[i];
	}

	/*
	int i = 0, j = 9;
	int tmp;
	while (arr[i++] % 2 && i < 10);
	while (arr[j--] % 2 == 0 && j >= 0);
	while (i - 1 < j + 1)
	{
	tmp = arr[i - 1];
	arr[i - 1] = arr[j + 1];
	arr[j + 1] = tmp;
	while (arr[i++] % 2);
	while (arr[j--] % 2 == 0);
	}
	*/

	for (i = 0; i < 10; i++)
	{
		printf("%d ", arr[i]);
	}
	system("pause");
	return 0;
}