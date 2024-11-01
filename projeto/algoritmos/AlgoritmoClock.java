package algoritmos;

public class AlgoritmoClock implements Interface {
    @Override
    public int executar(int[] paginas, int quadros) {
        int[] memoria = new int[quadros];
        boolean[] usado = new boolean[quadros];
        int ponteiro = 0;
        int faltas = 0;

        for (int pagina : paginas) {
            boolean encontrado = false;

            for (int i = 0; i < quadros; i++) {
                if (memoria[i] == pagina) {
                    usado[i] = true;
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                while (usado[ponteiro]) {
                    usado[ponteiro] = false;
                    ponteiro = (ponteiro + 1) % quadros;
                }

                memoria[ponteiro] = pagina;
                usado[ponteiro] = true;
                ponteiro = (ponteiro + 1) % quadros;
                faltas++;
            }
        }

        return faltas;
    }
}