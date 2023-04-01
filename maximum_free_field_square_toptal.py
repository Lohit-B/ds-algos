
def findMaxFreeSquare(fields, n, m):
	max_size = 0
	for i in range(0,n):max_size = max(max_size, fields[i][0])	
	for i in range(0,m):max_size = max(max_size, fields[0][i])	
 
	for i in range(1, n):
		for j in range(1,m):
			if fields[i][j] == 0: continue
			fields[i][j] = 1+min(fields[i-1][j], fields[i][j-1], fields[i-1][j-1])
			max_size = max_size(fields[i][j], max_size)

if __name__=='__main__':
	fields = [[1,1,1],[1,1,1],[1,1,1]]
	return findMaxFreeSquare(fields, len(fields), len(fields[0]))
	
