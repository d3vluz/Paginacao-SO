import algoritmos.*;

public class Main {
    public static void main(String[] args) {
        int[] paginas = {1, 3, 0, 3, 5, 6, 3, 1, 0, 5, 6, 2}; 
        int quadros = 4;

        Interface fifo = new AlgoritmoFIFO();
        Interface lru = new AlgoritmoLRU();
        Interface clock = new AlgoritmoClock();
        Interface nfu = new AlgoritmoNFU();

        int faltasFIFO = fifo.executar(paginas, quadros);
        int faltasLRU = lru.executar(paginas, quadros);
        int faltasClock = clock.executar(paginas, quadros);
        int faltasNFU = nfu.executar(paginas, quadros);

        System.out.println("--------------------------------------");
        System.out.println("(#) FIFO --> " + faltasFIFO + " Faltas de páginas\n");
        System.out.println("(#) LRU --> " + faltasLRU + " Faltas de páginas\n");
        System.out.println("(#) Clock --> " + faltasClock + " Faltas de páginas\n");
        System.out.println("(#) NFU --> " + faltasNFU + " Faltas de páginas");
        System.out.println("-------------------------------------");
    }
}
