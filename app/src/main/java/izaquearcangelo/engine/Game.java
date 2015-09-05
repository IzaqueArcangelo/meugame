package izaquearcangelo.engine;

import android.content.Context;
import android.view.SurfaceView;

/**
 * @author Izaque
 * Classe responsável por conter toda a lógica do jogo.
 */
public class Game extends SurfaceView implements Runnable {

    boolean jogoIniciado;
    Thread renderTheread = null;

    public Game(Context context) {
        super(context);
    }

    /**
     * Todo o controle do loop do jogo é feito neste método com uma flag
     * de inicialização.
     */
    @Override
    public void run() {
        while (jogoIniciado){
            System.out.println("Jogo Iniciado."); //// FIXME: 04/09/2015 Remover este código
        }
    }

    /**
     * Este método inicia a Theread do jogo, e faz o loop começar.
     */
    public void iniciarJogo(){
        jogoIniciado = true;
        renderTheread = new Thread(this);
        renderTheread.start();
    }
}
