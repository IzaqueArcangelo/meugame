package izaquearcangelo.engine;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * @author Izaque
 * Classe responsável por conter toda a lógica do jogo.
 */
public class Game extends SurfaceView implements Runnable {

    private boolean jogoIniciado;
    private Thread renderTheread = null;
    private SurfaceHolder surfaceHolder;
    private Paint paint;
    private Canvas canvas;

    /**
     * Construtor principal responsável por iniciar os objetos que serão utilizados para manipular a tela.
     */
    public Game(Context context) {
        super(context);
        canvas = new Canvas();
        paint = new Paint(); // Desenha elementos na tela.
        surfaceHolder = getHolder(); // Manipula a tela, verifica se está "pronta".
    }

    /**
     * Todo o controle do loop do jogo é feito neste método com uma flag de inicialização.
     */
    @Override
    public void run() {
        while (jogoIniciado){
            //Verifica se a tela está pronta.
            if(!surfaceHolder.getSurface().isValid())
                continue;
                //Bloqueia a tela para desenhar
                canvas = surfaceHolder.lockCanvas();

                circulo(canvas);

                // atualiza e libera tela.
                System.out.println("Jogo Iniciado."); //// FIXME: 04/09/2015 Remover este código
                surfaceHolder.unlockCanvasAndPost(canvas);
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

    public void pausarJogo(){
        jogoIniciado = false;
        renderTheread = null;
    }

    private void circulo(Canvas canvas){
        paint.setColor(Color.GREEN);
        canvas.drawRect(200, 200, 400, 400, paint);
    }
}
