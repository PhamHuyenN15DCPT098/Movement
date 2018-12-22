/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movement;

import java.awt.Color;
import java.awt.Graphics;
/**
 *
 * @author USER
 */
public class Bullet extends Character{
    @Override
    public void render(Graphics g) {
		g.setColor(this.color);
		g.drawRect((int)this.getPosition().getX(), (int) this.getPosition().getZ(), 20, 20);
		System.out.println(this.orientation);
	}
}
