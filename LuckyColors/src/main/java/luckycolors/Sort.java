package luckycolors;

import java.util.HashMap;
import java.util.Random;

public class Sort {

    private Random random = new Random();
    private HashMap<String, Integer> map;
    private Stack<String>[] viales;
    private String[] colors;

    @SuppressWarnings("unchecked")
    public Sort(int numViales, String[] colors) {
        this.viales = new Stack[numViales];
        this.colors = colors;
        this.map = new HashMap<>();
        for (int i = 0; i < numViales; i++) {
            viales[i] = new Stack<>();
        }
    }

    public void fillVials() {
        for (int i = 0; i < viales.length; i++) {
            if (i == viales.length - 1) {
                break;
            }
            
            while (!viales[i].isFull()) {
                String var = colors[random.nextInt(colors.length)];

                if (!map.containsKey(var)) {
                    map.put(var, 1);
                } else if (map.get(var) >= 4) {
                    continue;
                } else {
                    map.put(var, map.get(var) + 1);
                }
                viales[i].push(var);
            }
        }
    }
    
    public Stack<String>[] retrieve() {
        return viales;
    }

}
