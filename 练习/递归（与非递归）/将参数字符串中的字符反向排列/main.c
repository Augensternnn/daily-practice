#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include <stdlib.h>

//��дһ������ reverse_string(char * string)���ݹ�ʵ�֣� 
//ʵ�֣��������ַ����е��ַ��������С�Ҫ�󣺲���ʹ��C�������е��ַ�����������
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