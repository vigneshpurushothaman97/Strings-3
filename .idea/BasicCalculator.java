class BasicCalculator {
    public int calculate(String s) {
        if(s==null || s.length()==0)
            return 0;
        int lastsign = '+';
        s = s.trim();
        int num = 0;
        int result = 0;
        Stack<Integer> st = new Stack();
        for(int i =0; i<s.length();i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }
            if(c!= ' ' && (!Character.isDigit(c) || i== s.length()-1))
            {
                if(lastsign=='+')
                    st.push(num);
                else if(lastsign=='-')
                    st.push(-num);
                else if(lastsign == '*')
                    st.push(st.pop()*num);
                else
                    st.push(st.pop()/num);
                lastsign = c;
                num=0;
            }
        }
        System.out.println(st);
        while(!st.isEmpty())
        {
            result+=st.pop();
        }
        return result;
    }
}

//Time complexity is O(n)
//Space complexity is O(n)