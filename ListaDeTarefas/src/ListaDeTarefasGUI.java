import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ListaDeTarefasGUI extends JFrame {
    private ArrayList<String> tarefas;
    private DefaultListModel<String> tarefasListModel;
    private JList<String> tarefasList;
    private JTextField tarefaField;

    public ListaDeTarefasGUI() {
        tarefas = new ArrayList<>();
        tarefasListModel = new DefaultListModel<>();

        setTitle("Aplicativo de Lista de Tarefas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        getContentPane().add(panel);

        JLabel label = new JLabel("Tarefa:");
        panel.add(label);

        tarefaField = new JTextField(20);
        panel.add(tarefaField);

        JButton adicionarButton = new JButton("Adicionar");
        panel.add(adicionarButton);

        JButton removerButton = new JButton("Remover");
        panel.add(removerButton);

        tarefasList = new JList<>(tarefasListModel);
        JScrollPane scrollPane = new JScrollPane(tarefasList);
        panel.add(scrollPane);

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarTarefa();
            }
        });

        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerTarefa();
            }
        });

        // Inicializa a lista de tarefas com algumas tarefas de exemplo
        tarefas.add("Tarefa 1");
        tarefas.add("Tarefa 2");
        for (String tarefa : tarefas) {
            tarefasListModel.addElement(tarefa);
        }
    }

    private void adicionarTarefa() {
        String tarefa = tarefaField.getText();
        if (!tarefa.isEmpty()) {
            tarefas.add(tarefa);
            tarefasListModel.addElement(tarefa);
            tarefaField.setText("");
        }
    }

    private void removerTarefa() {
        int selectedIndex = tarefasList.getSelectedIndex();
        if (selectedIndex >= 0) {
            tarefas.remove(selectedIndex);
            tarefasListModel.remove(selectedIndex);
        }
    }
}


