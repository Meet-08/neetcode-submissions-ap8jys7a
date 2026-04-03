class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> res = new Stack<>();

        for(int a : asteroids){
            while(!res.isEmpty() && a < 0 && res.peek() > 0){
                int diff = a + res.peek();

                if(diff < 0){
                   res.pop();
                }else if(diff > 0){
                    a = 0;
                }else{
                    a = 0;
                    res.pop();
                }
            }

            if(a != 0) res.push(a);
        }

        return res.stream()
                    .mapToInt(i -> i)
                    .toArray();
    }
}