class Solution {
    
    record Pair(
        int pos,
        int speed
    ) {
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        Pair[] pair = new Pair[n];

        for(int i = 0; i < n; i++){
            pair[i] = new Pair(position[i], speed[i]);
        }

        Arrays.sort(pair, (a, b) -> Integer.compare(b.pos, a.pos));

        Stack<Double> stack = new Stack<>();

        for(var p : pair){
            stack.push((double)(target - p.pos) / p.speed);

            if(stack.size() >= 2 && 
            stack.peek() <= stack.get(stack.size() - 2)){
                stack.pop();
            }
        }

        return stack.size();
    }
}
