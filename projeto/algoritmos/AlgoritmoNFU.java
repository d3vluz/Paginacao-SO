package algoritmos;
import java.util.HashMap;
import java.util.Map;

public class AlgoritmoNFU implements Interface {
    public int executar(int[] paginas, int quadros) {
        Map<Integer, Integer> contador = new HashMap<>();
        int faltas = 0;

        for (int pagina : paginas) {
            if (!contador.containsKey(pagina)) {
                faltas++;
                if (contador.size() == quadros) {
                    int menosUsada = contador.entrySet().stream()
                        .min(Map.Entry.comparingByValue())
                        .get()
                        .getKey();
                    contador.remove(menosUsada);
                }
            }
            contador.put(pagina, contador.getOrDefault(pagina, 0) + 1);
        }
        
        return faltas;
    }
}
