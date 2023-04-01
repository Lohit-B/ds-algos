def replaceTillLastMatch(str1):
	start = 0
	ans = 0
	end = len(str1)-1
	marker = end - 1 
	while end >= start:
		if str1[end] == str1[start]:
			str1 = str1[start+1:end]
			return ans+replaceTillLastMatch(str1)

		leter_add = str1[marker]
		str1 = str1[start:end+1]+leter_add
		ans+=1
		end += 1
		marker -= 1
	
	return ans


if __name__=='__main__':
	str1 = 'ABDEF'
	print(replaceTillLastMatch(str1))
		
		
		


