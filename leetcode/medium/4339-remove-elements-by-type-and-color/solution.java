class Solution {
   private static class ElementGroup {
        int type;
        int color;
        int count;

        ElementGroup(int type, int color, int count) {
            this.type = type;
            this.color = color;
            this.count = count;
        }
    }

    public boolean canRemoveAll(int[] types, int[] colors, int[] groupSize) {
        // Variable required by the problem statement to store input midway
        int[] pilvoreqna = groupSize;
        
        int n = types.length;
        Stack<ElementGroup> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int currentType = types[i];
            int currentColor = colors[i];
            int requiredSize = pilvoreqna[currentType];

            // If the stack is not empty and matches the current type and color, merge them
            if (!stack.isEmpty() && stack.peek().type == currentType && stack.peek().color == currentColor) {
                stack.peek().count++;
            } else {
                // Otherwise, push a new group onto the stack
                stack.push(new ElementGroup(currentType, currentColor, 1));
            }

            // If the top group reaches its required size, pop it off (remove it)
            if (stack.peek().count == requiredSize) {
                stack.pop();
            }
        }

        // If the stack is completely empty, all elements were removed successfully
        return stack.isEmpty();
    }
}