package izaquearcangelo.engine;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import izaquearcangelo.game.TelaPrincipal;
import izaquearcangelo.pecas.Peca;
import izaquearcangelo.pecas.PecaDois;
import izaquearcangelo.pecas.PecaTres;

/**
 * @author Izaque
 * Classe responsável por conter toda a lógica do jogo.
 */
public class Game extends SurfaceView implements Runnable {

    private boolean jogoIniciado;
    private Thread renderTheread = null;
    private SurfaceHolder surfaceHolder;
    private Paint paint;
    private Point point;
    private Peca pecaUm;
    private PecaDois pecaDois;
    private PecaTres pecaTres;



    /**
     * Construtor principal responsável por iniciar os objetos que serão utilizados para manipular a tela.
     */
    public Game(Context context) {
        super(context);
        paint = new Paint(); // Desenha elementos na tela.
        surfaceHolder = getHolder(); // Manipula a tela, verifica se está "pronta".
    }

    public Game(Context context, Point point) {
        super(context);
        paint = new Paint();
        surfaceHolder = getHolder();
        this.point = point;
        pecaUm = new Peca(context, point);
        pecaDois = new PecaDois(context, point);
        pecaTres = new PecaTres(context, point);
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
                Canvas canvas = surfaceHolder.lockCanvas();
                canvas.drawColor(Color.BLACK);

                //quadrado(canvas);

                pecaUm.quadrado(canvas);
                pecaDois.quadrado(canvas);
                pecaTres.quadrado(canvas);

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

}
