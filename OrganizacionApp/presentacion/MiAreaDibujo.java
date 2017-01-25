package presentacion;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;

public class MiAreaDibujo extends JLabel{
	
	private ArrayList<ObjetoGrafico> objetosGraficos = new ArrayList<ObjetoGrafico>();

	public MiAreaDibujo(){
		
	}
	
	void addObjetoGrafico(ObjetoGrafico objg) {
		objetosGraficos.add(objg);
	}
	
	void removeObjetosGraficos(){
		objetosGraficos.clear();
		
	}
	
	public ObjetoGrafico getUltimoObjetoGrafico(){
		return objetosGraficos.get(objetosGraficos.size()-1);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		
		for (int i = 0; i < objetosGraficos.size(); i++) {
			
			ObjetoGrafico objg = objetosGraficos.get(i);
			
			if (objg instanceof ImagenGrafico){
				g.drawImage(((ImagenGrafico)objg).getImagen(), objg.getX(), objg.getY(), null);
			}
			
			else if (objg instanceof RectanguloGrafico){
				g.setColor(((RectanguloGrafico)objg).getColor());
				int w = ((RectanguloGrafico)objg).getX1() - objg.getX();
				int h = ((RectanguloGrafico)objg).getY1() - objg.getY();
				g.drawRect(objg.getX(),objg.getY(),w,h);
			}
			
			else if (objg instanceof LineaGrafico){
				g.setColor(((LineaGrafico)objg).getColor());
				//int w = ((RectanguloGrafico)objg).getX1() - objg.getX();
				//int h = ((RectanguloGrafico)objg).getY1() - objg.getY();
				g.drawLine(objg.getX(),objg.getY(),((LineaGrafico)objg).getX1(),((LineaGrafico)objg).getY1());
				//g.drawLine(x1, y1, x2, y2);
				//g.drawRect(x, y, width, height);
			}
			
			else { //Es un objeto de tipo TextoGrafico
				g.setColor(((TextoGrafico)objg).getColor());
				g.drawString(((TextoGrafico)objg).getTexto(),objg.getX(),objg.getY());
				}

		} 
	}
}

