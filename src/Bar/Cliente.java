package Bar;
/**
 * Created by Italo Bruno on 12/05/2017.
 */

import java.util.concurrent.Semaphore;

public class Cliente extends Thread
{
    private int identificador;
    private static int numTotalClientes = 0;
    private int tempoNoBar = 0;
    private int tempoEmCasa = 0;
    public static Semaphore mutex = new Semaphore(1);
    public static Semaphore bar = new Semaphore(3);
    private static int contaCliente = 0;
    private Thread time;

    public Cliente(String nome, int tempoNoBar, int tempoEmCasa)
    {
        super(nome);
        this.tempoNoBar = tempoNoBar;
        this.tempoEmCasa = tempoEmCasa;
        Cliente.numTotalClientes++;
        identificador = Cliente.numTotalClientes;
        System.out.println(this.msgThreadCriada());
        this.setPriority(5);
        this.start();
    }

    //public int getIdentificador()
    //{
    //    return this.identificador;
    //}

    //public int getTempoNoBar()
    //{
    //    return this.tempoNoBar;
    //}
    //
    //public int getTempoEmCasa()
    //{
    //    return this.tempoEmCasa;
    //}

    @Override
    public String toString()
    {
        return "Nome do Cliente: " + this.getName() +
                "\nIdentificador: " + this.identificador +
                "\nTempo no Bar: " + this.tempoNoBar +
                "\nTempo em Casa: " + this.tempoEmCasa;
    }

    @Override
    public void run()
    {
        while (true)
        {
            System.out.println(this.msgClienteAguardando());
            //down semaphore bar
            try
            {
                bar.acquire();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            //down semaphore mutex
            try
            {
                mutex.acquire();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            //Cliente entrou no bar
            Cliente.contaCliente++;

            mutex.release();

            irBeber();

            try
            {
                mutex.acquire();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            Cliente.contaCliente--;

            if(Cliente.contaCliente == 0)
            {
                bar.release(3);
            }
            mutex.release();
            irPraCasa();
        }
    }


    public void irBeber()
    {
        System.out.println(this.msgEntrouNoBar());
        for (int i = 0; i < this.tempoNoBar; i++)
        {

            try
            {
                time.sleep(1000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(this.msgTempoRestanteNoBar(i));

        }
        System.out.println(this.msgFoiParaCasa());
    }

    public void irPraCasa()
    {
        for (int i = 0; i < this.tempoEmCasa; i++)
        {
            try
            {
                time.sleep(1000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(this.msgTempoRestanteEmCasa(i));

        }
    }

    public String msgThreadCriada()
    {
        return "Cliente " + this.getName()+
                " - ID: " + this.identificador
                + " foi instanciado";
    }

    public String msgClienteAguardando()
    {
        return "Cliente " + this.getName()+
                " - ID: " + this.identificador
                + " aguardando mesa......";
    }

    public String msgEntrouNoBar()
    {
        return "Cliente " + this.getName()+
                " - ID: " + this.identificador
                + " entrou no bar";
    }

    public String msgTempoRestanteNoBar(int i)
    {
        return "Cliente " + this.getName()+
                " - ID: " + this.identificador
                +" -- Tempo restante no bar: " + (this.tempoNoBar - i)+ " seg";
    }

    public String msgFoiParaCasa()
    {
        return "Cliente " + this.getName()+
                " - ID: " + this.identificador
                + " foi para casa";
    }

    public String msgTempoRestanteEmCasa(int i)
    {
        return "Tempo Restante em casa: " + (this.tempoEmCasa - i) + " seg -- " +
                "Cliente " + this.getName()+
                " - ID: " + this.identificador;
    }
}