// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   ImageServlet.java

package com.youzi.web.conctroller;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ImageServlet extends HttpServlet {

	public static final int WIDTH = 140;
	public static final int HEIGTH = 30;

	public ImageServlet() {
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BufferedImage image = new BufferedImage(140, 30, 1);
		Graphics g = image.getGraphics();
		setBackGround(g);
		setBorder(g);
		drawRandomLine(g);
		String random = drawRandomNum((Graphics2D) g);
		request.getSession().setAttribute("imagecheckcode", random);
		response.setContentType("image/jpeg");
		response.setDateHeader("expries", -1L);
		response.setHeader("Cache-control", "no");
		response.setHeader("pragma", "no cache");
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

	private void setBackGround(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 140, 30);
	}

	private void setBorder(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(1, 1, 138, 28);
	}

	private void drawRandomLine(Graphics g) {
		g.setColor(Color.GREEN);
		for (int i = 0; i < 5; i++) {
			int xStart = (new Random()).nextInt(140);
			int yStart = (new Random()).nextInt(30);
			int xEnd = (new Random()).nextInt(140);
			int yEnd = (new Random()).nextInt(30);
			g.drawLine(xStart, yStart, xEnd, yEnd);
		}

	}

	private String drawRandomNum(Graphics2D g) {
		g.setColor(Color.RED);
		g.setFont(new Font("ËÎÌו", 1, 25));
		char ch1 = 'a';
		char ch2 = 'A';
		int x = 10;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			int d = (new Random()).nextInt() % 30;
			int degree = 10 + d;
			int temp = (new Random()).nextInt(26);
			boolean flag = (new Random()).nextBoolean();
			char a = '\0';
			if (flag)
				a = (char) (ch1 + temp);
			else
				a = (char) (ch2 + temp);
			String str = (new StringBuilder(String.valueOf(a))).toString();
			sb.append(str);
			g.rotate(((double) degree * 3.1415926535897931D) / 180D, x, 25D);
			g.drawString(str, x, 22);
			g.rotate(((double) (-degree) * 3.1415926535897931D) / 180D, x, 25D);
			x += 30;
		}

		return sb.toString();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
