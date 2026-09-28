import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ReconhecimentoLetrasUI extends JFrame {

    private static final int LINHAS = 9;
    private static final int COLUNAS = 7;

    private final JTable gradeTreinamento;
    private final JTable gradeTeste;
    private JLabel resultado;

    // construtor da classe
    public ReconhecimentoLetrasUI() {
        super("Reconhecimento de Letras - Rede Neural Artificial");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(740, 560);
        setMinimumSize(new Dimension(700, 520));
        setLocationRelativeTo(null);

        JPanel conteudo = new JPanel(new GridLayout(1, 2, 12, 0));
        conteudo.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

        gradeTreinamento = criarGrade(true);
        gradeTeste = criarGrade(false);

        conteudo.add(criarPainelTreinamento());
        conteudo.add(criarPainelTeste());

        setContentPane(conteudo);
    }

    private JPanel criarPainelTreinamento() {
        JPanel painel = criarPainelPrincipal("Base de Treinamento");
        painel.setLayout(new BorderLayout(8, 10));

        JPanel areaGrade = new JPanel(new BorderLayout(10, 0));
        areaGrade.add(criarSeletores(), BorderLayout.WEST);
        areaGrade.add(criarPainelGrade(gradeTreinamento), BorderLayout.CENTER);

        JPanel areaInferior = new JPanel(new BorderLayout(8, 8));
        areaInferior.add(new GraficoCiclosPanel(), BorderLayout.CENTER);

        JPanel barraInferior = new JPanel(new BorderLayout());
        JLabel ciclos = new JLabel("Ciclos:   ---");
        JButton treinar = new JButton("Treinar");
        treinar.addActionListener(e -> {
            int ciclosTreinamento = 0;
            for (int i = 0; i < 7; i++) {
                ciclosTreinamento += RedeAdaline.treinar(i);
            }
            ciclos.setText("Ciclos:   " + ciclosTreinamento);
        });

        barraInferior.add(ciclos, BorderLayout.WEST);
        barraInferior.add(treinar, BorderLayout.EAST);

        areaInferior.add(barraInferior, BorderLayout.SOUTH);

        painel.add(areaGrade, BorderLayout.NORTH);
        painel.add(areaInferior, BorderLayout.CENTER);

        return painel;
    }

    private JPanel criarPainelTeste() {
        JPanel painel = criarPainelPrincipal("Teste da Rede Neural");
        painel.setLayout(new BorderLayout(8, 10));

        JLabel instrucao = new JLabel(
                "Desenhe a Letra no grid abaixo",
                SwingConstants.CENTER);
        instrucao.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 13));
        instrucao.setForeground(new Color(35, 110, 170));

        JPanel topo = new JPanel(new BorderLayout(0, 8));
        topo.add(instrucao, BorderLayout.NORTH);
        topo.add(criarPainelGrade(gradeTeste), BorderLayout.CENTER);

        JPanel resposta = new JPanel(new BorderLayout(0, 12));
        resposta.setBorder(BorderFactory.createEmptyBorder(16, 0, 10, 0));

        JLabel tituloResposta = new JLabel(
                "Resposta da Rede Neural:",
                SwingConstants.CENTER);
        tituloResposta.setFont(new Font("SansSerif", Font.BOLD, 14));
        tituloResposta.setForeground(new Color(190, 55, 55));

        resultado = new JLabel("---", SwingConstants.CENTER);
        resultado.setFont(new Font("SansSerif", Font.PLAIN, 16));

        resposta.add(tituloResposta, BorderLayout.NORTH);
        resposta.add(resultado, BorderLayout.CENTER);

        JPanel barraInferior = new JPanel(new BorderLayout());
        JButton testar = new JButton("Testar");
        testar.addActionListener(e -> {
            double[] foto = lerGradeTeste();
            String respostaTestar = RedeAdaline.testar(foto);
            resultado.setText(respostaTestar.trim());
        });
        barraInferior.add(testar, BorderLayout.EAST);

        painel.add(topo, BorderLayout.NORTH);
        painel.add(resposta, BorderLayout.CENTER);
        painel.add(barraInferior, BorderLayout.SOUTH);

        return painel;
    }

    private JPanel criarSeletores() {
        JPanel seletores = new JPanel();
        seletores.setLayout(new javax.swing.BoxLayout(seletores, javax.swing.BoxLayout.Y_AXIS));
        seletores.setBorder(BorderFactory.createEmptyBorder(16, 2, 0, 2));

        JLabel fonteLabel = new JLabel("FONTE");
        fonteLabel.setFont(new Font("SansSerif", Font.BOLD, 12));

        JComboBox<String> fonte = new JComboBox<>(
                new String[] { "1", "2", "3" });
        fonte.setMaximumSize(new Dimension(76, 25));

        JLabel letraLabel = new JLabel("LETRA");
        letraLabel.setFont(new Font("SansSerif", Font.BOLD, 12));

        JComboBox<String> letra = new JComboBox<>(
                new String[] { "A", "B", "C", "D", "E", "F", "G" });
        letra.setMaximumSize(new Dimension(76, 25));

        seletores.add(fonteLabel);
        seletores.add(fonte);
        seletores.add(javax.swing.Box.createVerticalStrut(12));
        seletores.add(letraLabel);
        seletores.add(letra);

        return seletores;
    }

    private JPanel criarPainelPrincipal(String titulo) {
        JPanel painel = new JPanel();
        painel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(titulo),
                BorderFactory.createEmptyBorder(8, 8, 8, 8)));
        return painel;
    }

    private JPanel criarPainelGrade(JTable tabela) {
        JPanel painel = new JPanel(new BorderLayout());
        painel.add(criarScrollPaneComNumeracao(tabela), BorderLayout.CENTER);
        return painel;
    }

    private JScrollPane criarScrollPaneComNumeracao(JTable tabela) {
        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setPreferredSize(new Dimension(215, 225));
        scroll.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        DefaultTableModel modeloLinhas = new DefaultTableModel(LINHAS, 1) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable numeracaoLinhas = new JTable(modeloLinhas);
        numeracaoLinhas.setRowHeight(21);
        numeracaoLinhas.setPreferredScrollableViewportSize(new Dimension(27, 189));
        numeracaoLinhas.setTableHeader(null);
        numeracaoLinhas.setEnabled(false);
        numeracaoLinhas.setShowGrid(false);
        numeracaoLinhas.setBackground(new Color(245, 245, 245));

        for (int linha = 0; linha < LINHAS; linha++) {
            numeracaoLinhas.setValueAt(Integer.toString(linha + 1), linha, 0);
        }

        DefaultTableCellRenderer renderizadorLinhas = new DefaultTableCellRenderer();
        renderizadorLinhas.setHorizontalAlignment(SwingConstants.CENTER);
        numeracaoLinhas.getColumnModel().getColumn(0).setCellRenderer(renderizadorLinhas);
        numeracaoLinhas.getColumnModel().getColumn(0).setPreferredWidth(27);
        numeracaoLinhas.getColumnModel().getColumn(0).setMinWidth(27);
        numeracaoLinhas.getColumnModel().getColumn(0).setMaxWidth(27);

        scroll.setRowHeaderView(numeracaoLinhas);
        return scroll;
    }

    private JTable criarGrade(boolean mostrarLetra) {
        String[] colunas = new String[COLUNAS];
        for (int coluna = 0; coluna < COLUNAS; coluna++) {
            colunas[coluna] = Integer.toString(coluna + 1);
        }

        String[][] dados = new String[LINHAS][COLUNAS];
        for (int linha = 0; linha < LINHAS; linha++) {
            for (int coluna = 0; coluna < COLUNAS; coluna++) {
                dados[linha][coluna] = "·";
            }
        }

        if (mostrarLetra) {
            int[][] pontosLetraA = {
                    { 0, 3 },
                    { 1, 3 },
                    { 2, 3 },
                    { 3, 2 }, { 3, 3 }, { 3, 4 },
                    { 4, 2 }, { 4, 4 },
                    { 5, 1 }, { 5, 5 },
                    { 6, 1 }, { 6, 2 }, { 6, 3 }, { 6, 4 }, { 6, 5 },
                    { 7, 1 }, { 7, 5 },
                    { 8, 1 }, { 8, 5 }
            };

            for (int[] ponto : pontosLetraA) {
                dados[ponto[0]][ponto[1]] = "#";
            }
        }

        DefaultTableModel modelo = new DefaultTableModel(dados, colunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable tabela = new JTable(modelo);
        tabela.setRowHeight(21);
        tabela.setCellSelectionEnabled(true);
        tabela.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabela.setGridColor(new Color(190, 190, 190));
        tabela.setShowGrid(true);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tabela.setFont(new Font("SansSerif", Font.PLAIN, 12));

        DefaultTableCellRenderer renderizador = new DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(
                    JTable table,
                    Object value,
                    boolean selected,
                    boolean focused,
                    int row,
                    int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(
                        table, value, selected, focused, row, column);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setForeground("#".equals(value) ? Color.BLACK : Color.GRAY);

                if (selected) {
                    label.setBackground(new Color(30, 135, 220));
                    label.setForeground(Color.WHITE);
                } else {
                    label.setBackground(Color.WHITE);
                }

                return label;
            }
        };

        for (int coluna = 0; coluna < COLUNAS; coluna++) {
            tabela.getColumnModel().getColumn(coluna).setPreferredWidth(27);
            tabela.getColumnModel().getColumn(coluna).setCellRenderer(renderizador);
        }

        tabela.setPreferredScrollableViewportSize(new Dimension(189, 189));

        if (!mostrarLetra) {
            tabela.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evento) {
                    int linha = tabela.rowAtPoint(evento.getPoint());
                    int coluna = tabela.columnAtPoint(evento.getPoint());

                    if (linha >= 0 && coluna >= 0) {
                        String atual = tabela.getValueAt(linha, coluna).toString();
                        tabela.setValueAt("#".equals(atual) ? "·" : "#", linha, coluna);
                    }
                }
            });
        }

        return tabela;
    }

    private static class GraficoCiclosPanel extends JPanel {
        GraficoCiclosPanel() {
            setPreferredSize(new Dimension(280, 145));
            setBackground(Color.WHITE);
            setBorder(BorderFactory.createEmptyBorder(4, 8, 4, 8));
        }

        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);

            Graphics2D g = (Graphics2D) graphics.create();
            g.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            int esquerda = 30;
            int topo = 8;
            int largura = Math.max(180, getWidth() - 48);
            int altura = Math.max(65, getHeight() - 38);
            int baixo = topo + altura;

            g.setColor(Color.BLACK);
            g.setStroke(new BasicStroke(1f));
            g.drawLine(esquerda, topo, esquerda, baixo);
            g.drawLine(esquerda, baixo, esquerda + largura, baixo);

            g.setColor(new Color(210, 210, 210));
            for (int i = 1; i <= 4; i++) {
                int y = topo + i * altura / 5;
                g.drawLine(esquerda, y, esquerda + largura, y);
            }

            g.setColor(Color.BLACK);
            g.setFont(new Font("SansSerif", Font.PLAIN, 10));
            g.drawString("EOM", 6, topo + altura / 2);
            g.drawString("0", esquerda - 3, baixo + 14);
            g.drawString("1", esquerda + largura / 2, baixo + 14);
            g.drawString("2", esquerda + largura - 3, baixo + 14);
            g.drawString("Ciclos", esquerda + largura / 2 - 17, baixo + 27);

            g.dispose();
        }
    }

    private double[] lerGradeTeste() {
        double[] vetor = new double[64];
        int posicao = 0;

        for (int linha = 0; linha < LINHAS; linha++) {
            for (int coluna = 0; coluna < COLUNAS; coluna++) {
                String celula = gradeTeste.getValueAt(linha, coluna).toString();

                if ("#".equals(celula)) {
                    vetor[posicao] = 1;
                } else {
                    vetor[posicao] = -1;
                }
                posicao++;
            }

        }

        vetor[63] = 1;

        return vetor;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {
            }

            new ReconhecimentoLetrasUI().setVisible(true);
        });
    }
}
