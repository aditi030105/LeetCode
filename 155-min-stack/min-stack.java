class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> cache = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.push(val);
        if(cache.isEmpty()){
            cache.push(val);
            return;
        }
        Integer min = cache.peek();
        if(min > val){
            cache.push(val);
        }else{
            cache.push(min);
        }
    }
    
    public void pop() {
        cache.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return cache.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */