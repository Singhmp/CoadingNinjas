
public class MinimumCountSquare {
	public static int minCount(int n) {
		// recursion concept;
		if(n<=3) {
			return n;
		}
		int ans=n;
		for(int x=1;x<=n;x++) {
			int temp=x*x;
			if(temp>n) 
			break;
			else
			ans=Math.min(ans, 1+minCount(n-temp));
		
			}
		return ans;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(minCount(6));
System.out.println(minCountDp(6));
	}
//Dynamic programming Apporache;
	
public static int minCountDp(int n)
{
	int a[]=new int[n+1];
	a[0]=0;
	a[1]=1;
	a[2]=2;
	a[3]=3;
	for(int i=4;i<=n;i++) {
		a[i]=i;
	
	for(int x=1;x<=i;x++) {	
	
	
	int temp=x*x;
	if(temp>i)
	
		break;
		else
			a[i]=Math.min(a[i], 1+a[i-temp]);
	
	}
	}
	return a[n];
}
	}
	

