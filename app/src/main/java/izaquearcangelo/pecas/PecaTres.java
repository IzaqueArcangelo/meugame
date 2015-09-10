package izaquearcangelo.pecas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;


public class PecaTres extends View {

    private Point point;
    private Paint paint;

    public PecaTres(Context context) {
        super(context);
    }

    public PecaTres(Context contex, Point point){
        super(contex);
        this.point = point;
        paint = new Paint();
    }

    public void quadrado(Canvas canvas) {
        paint.setColor(Color.MAGENTA);
        Rect quadrado = new Rect();
        int largura = point.x;
        int altura = point.y;
        //quadrado.set(largura/2, altura/2, (largura/2-200)+400, (altura/2-200)+400);
        quadrado.set(largura/3+240, altura/2-100, (largura/3+240)+200, (altura/2-100)+200);
        canvas.drawRect(quadrado, paint);
    }
}
