package algoritmos;

import java.util.LinkedList;
import java.util.Queue;

public class AlgoritmoFIFO implements Interface {
    public int executar(int[] paginas, int quadros) {
        Queue<Integer> fila = new LinkedList<>();
        int faltas = 0;
        
        for (int pagina : paginas) {
            if (!fila.contains(pagina)) {
                if (fila.size() == quadros) fila.poll();
                fila.add(pagina);
                faltas++;
            }
        }
        
        return faltas;
    }
}
