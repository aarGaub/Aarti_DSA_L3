package lab3.ds.q2.balancedbrackets;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedBrackets {
	
	static boolean isBalancedByStack(String str){
	
		Deque<Character> stack = new ArrayDeque<Character>();
		
		for(int i=0;i< str.length();i++) {
			
			char bracket = str.charAt(i);
			
			if(bracket=='(' || bracket=='{' || bracket=='[') {
				stack.push(bracket);
				
			}
			else if(bracket==')' || bracket=='}' || bracket==']')
			{  
				if (!stack.isEmpty()) 
				{
					char x=stack.pop();
					if((x== '{' && bracket == '}') || (x == '[' && bracket == ']')
				            || (x == '(' && bracket == ')')) 
					{
						continue;
					}
			
				}
				else 
					return false;
				
			}
			else
				continue;
			
	}
		return stack.isEmpty();
	}
	
	public static void main(String[] args) {
		
		/* {[[()[][]]]}
		  ( [ [ { } ] ] )
		  [()]{}{[()()]()}
		  (a*b)+(c*d))
		*/
		String str = "{[[()[][]]]}" ;
		System.out.println("The String is : "+str);
		
		if(isBalancedByStack(str))
			System.out.println("The entered String has Balanced Brackets");
		else
			System.out.println("The entered String do not contain Balanced Brackets");
		
	}
}
