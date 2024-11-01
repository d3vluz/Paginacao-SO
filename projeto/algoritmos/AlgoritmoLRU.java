package algoritmos;
import java.util.ArrayList;
import java.util.List;

public class AlgoritmoLRU implements Interface {
    public int executar(int[] paginas, int quadros) {
        List<Integer> lista = new ArrayList<>();
        int faltas = 0;
        
        for (int pagina : paginas) {
            if (!lista.contains(pagina)) {
                if (lista.size() == quadros) lista.remove(0);
                lista.add(pagina);
                faltas++;
            } else {
                lista.remove((Integer) pagina);
                lista.add(pagina);
            }
        }
        
        return faltas;
    }
}
