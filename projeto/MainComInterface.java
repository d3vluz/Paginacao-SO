import algoritmos.*;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainComInterface extends JFrame {

    public MainComInterface(Map<String, Integer> faltasPagina, Map<String, Integer> temposExecucao) {
        setTitle("Comparação de Algoritmos de Falta de Página");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel painelSuperior = new JPanel();
        painelSuperior.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel labelTempoSimulacao = new JLabel("Tempo de simulação: 1,17 segundos");
        painelSuperior.add(labelTempoSimulacao);
        add(painelSuperior, BorderLayout.NORTH);

        JPanel painelGrafico = new PainelGrafico(faltasPagina, temposExecucao);
        add(painelGrafico, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        int[] paginas = {1, 3, 0, 3, 5, 6, 3, 1, 0, 5, 6, 2}; 
        int quadros = 4;

        Map<String, Integer> faltasPagina = new HashMap<>();
        Map<String, Integer> temposExecucao = new HashMap<>();

        Interface fifo = new AlgoritmoFIFO();
        Interface lru = new AlgoritmoLRU();
        Interface clock = new AlgoritmoClock();
        Interface nfu = new AlgoritmoNFU();

        long inicio, fim;

        inicio = System.currentTimeMillis();
        faltasPagina.put("Algoritmo FIFO", fifo.executar(paginas, quadros));
        fim = System.currentTimeMillis();
        temposExecucao.put("Algoritmo FIFO", (int) (fim - inicio));

        inicio = System.currentTimeMillis();
        faltasPagina.put("Algoritmo LRU", lru.executar(paginas, quadros));
        fim = System.currentTimeMillis();
        temposExecucao.put("Algoritmo LRU", (int) (fim - inicio));

        inicio = System.currentTimeMillis();
        faltasPagina.put("Algoritmo Clock", clock.executar(paginas, quadros));
        fim = System.currentTimeMillis();
        temposExecucao.put("Algoritmo Clock", (int) (fim - inicio));

        inicio = System.currentTimeMillis();
        faltasPagina.put("Algoritmo NFU", nfu.executar(paginas, quadros));
        fim = System.currentTimeMillis();
        temposExecucao.put("Algoritmo NFU", (int) (fim - inicio));

        SwingUtilities.invokeLater(() -> {
            MainComInterface gui = new MainComInterface(faltasPagina, temposExecucao);
            gui.setVisible(true);
        });
    }
}

class PainelGrafico extends JPanel {
    private final Map<String, Integer> faltasPagina;
    private final Map<String, Integer> temposExecucao;

    public PainelGrafico(Map<String, Integer> faltasPagina, Map<String, Integer> temposExecucao) {
        this.faltasPagina = faltasPagina;
        this.temposExecucao = temposExecucao;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int larguraBarra = getWidth() / (faltasPagina.size() * 2);
        int maxFaltas = faltasPagina.values().stream().max(Integer::compare).orElse(1);

        int totalLarguraBarras = larguraBarra * faltasPagina.size() + (larguraBarra / 2) * (faltasPagina.size() - 1);
        int margemEsquerda = (getWidth() - totalLarguraBarras) / 2;

        int x = margemEsquerda;
        for (Map.Entry<String, Integer> entrada : faltasPagina.entrySet()) {
            String algoritmo = entrada.getKey();
            int faltas = entrada.getValue();
            int tempoExecucao = temposExecucao.get(algoritmo);

            int alturaBarra = (int) ((double) faltas / maxFaltas * (getHeight() - 50));
            g.setColor(Color.GRAY);
            g.fillRect(x, getHeight() - alturaBarra - 30, larguraBarra, alturaBarra);

            g.setColor(Color.BLACK);
            FontMetrics fm = g.getFontMetrics();

            String textoFaltas = String.valueOf(faltas);
            int larguraTextoFaltas = fm.stringWidth(textoFaltas);
            int alturaTextoFaltas = fm.getAscent();
            int xTextoFaltas = x + (larguraBarra - larguraTextoFaltas) / 2;
            int yTextoFaltas = getHeight() - alturaBarra - 30 + (alturaBarra + alturaTextoFaltas) / 2;

            String textoTempo = "Tempo: " + tempoExecucao + " ms";
            int larguraTextoTempo = fm.stringWidth(textoTempo);
            int xTextoTempo = x + (larguraBarra - larguraTextoTempo) / 2;
            int yTextoTempo = getHeight() - alturaBarra - 40;

            String textoAlgoritmo = algoritmo;
            int larguraTextoAlgoritmo = fm.stringWidth(textoAlgoritmo);
            int xTextoAlgoritmo = x + (larguraBarra - larguraTextoAlgoritmo) / 2;
            int yTextoAlgoritmo = getHeight() - 5;

            g.drawString(textoFaltas, xTextoFaltas, yTextoFaltas);
            g.drawString(textoTempo, xTextoTempo, yTextoTempo);
            g.drawString(textoAlgoritmo, xTextoAlgoritmo, yTextoAlgoritmo);

            x += larguraBarra * 3 / 2;
        }
    }
}
