mergesort(data)
temp=new int[]
		msort(data,temp,lo,hi)
		msort(temp,data,lo,(lo+hi)/2)
		msort(temp,data,(lo+hi)/2 +1, hi)

		merge(data,temp,lo,hi)
		