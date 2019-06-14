#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>

//编写一个函数 reverse_string(char * string)（递归实现） 
//实现：将参数字符串中的字符反向排列。要求：不能使用C函数库中的字符串操作函数
void reverse_string(char * string)
{
	if ('\0' != *(++string))
		reverse_string(string);
	printf("%c", *(string - 1));
}

int main()
{
	char str[] = "abcdef";
	reverse_string(str);

	system("pause");
	return 0;
}