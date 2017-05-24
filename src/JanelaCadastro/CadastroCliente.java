package JanelaCadastro;

import Bar.Cliente;

import javax.swing.JOptionPane;

public class CadastroCliente
{
    public CadastroCliente()
    {
        String term = "Digite a quantidade de Clientes(Entre 1 e 10):";
        term = JOptionPane.showInputDialog(null,term,"Digite: ",3);
        int quantidade = 0;
        try
        {
            quantidade = Integer.parseInt(term);
        }
        catch (NumberFormatException nfe)
        {
            JOptionPane.showMessageDialog(null, "Operação Cancelada!", "Operação Cancelada", 2);
        }
        //while(quantidade>10 || quantidade <0)
        //{
        //    term = JOptionPane.showInputDialog(null,term,"Digite: ",3);
        //}
        //quantidade = Integer.parseInt(term);
        boolean ter = true;
        while(ter)
        {
            try
            {
                for (int i = 0; i < quantidade; i++)
                {
                    String nome = "Nome do " + (i + 1) + "ª Cliente";
                    nome = JOptionPane.showInputDialog(null, nome, "Digite:", 3);

                    String str1 = "Tempo no Bar: ";
                    str1 = JOptionPane.showInputDialog(null, str1, "Digite:", 3);
                    int tempoNoBar = Integer.parseInt(str1);

                    String str2;
                    str2 = "Tempo em Casa:\n";
                    str2 = JOptionPane.showInputDialog(null, str2, "Digite:", 3);
                    int tempoEmCasa = Integer.parseInt(str2);

                    Cliente clienteNovo = new Cliente(nome,tempoNoBar,tempoEmCasa);
                    String dadosCliente = clienteNovo.toString();
                    JOptionPane.showMessageDialog(null, dadosCliente,
                            "Cliente Cadastrado", 1);
                }
            }catch (NumberFormatException nfe)
            {
                JOptionPane.showMessageDialog(null, "Dados Invalidos!\nDigite Novamente!", "Erro", 2);
            }
            ter = false;
        }
    }
}

