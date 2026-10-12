class Solution {
    public int[] finalPrices(int[] prices) {
      Stack<Integer> st= new Stack<>();
     for(int i=0;i<prices.length;i++){
        while(!st.isEmpty() && prices[st.peek()] >= prices[i]){
            int index=st.pop();
            prices[index]=prices[index]-prices[i];
     }  
      st.push(i);
        }
      return prices; 
    }   
    }
