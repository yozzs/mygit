// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   BookDaoTest.java

package junit.test;


import org.junit.Test;

import com.youzi.dao.BookDao;
import com.youzi.dao.impl.BookDaoImpl;

public class BookDaoTest
{

	public BookDaoTest()
	{
	}
	@Test
	public void testAdd()
	{
		BookDao dao = new BookDaoImpl();
		String bookname = "浮生闲情";
		String author = "陈佳煌";
		String press = "阳新一中出版社";
		double price = 38.90;
		String imguri = "book36.jpg";
		String msg1 = "秋雨丝丝洒枝头，烟缕织成愁，遥望落花满地残红，曾也枝头盈盈娉婷，装饰他人梦。如今花落簌簌，曾绚烂美好刹那芳华。看那花瓣上的珍珠，不甚清风的摆动，悄然滑落，那不舍的是离愁，尘缘已过，聚散匆匆。不需忧伤，花儿，不会因为离枝而失去芬芳；草儿，不会因为寒冬而放弃生的希望。今年花胜去年红，明年花更好，花开最美，不负这红尘人间。生命的旅途，总会有千回百转，悲喜寒凉，季节的辗转，绮丽的风景。若是懂得，这都是生活赋予的美好。";
		String msg11 = "细数走过的岁月，欢乐伴着忧伤。在时光的深处中，最美的永远艳丽多彩不褪色，那些伤痛，时间久了也就模糊不清，留下的记忆也是残缺碎片。遇到不满意时，总会拿过去的好作比较，留恋过去，讨厌现在，始不知过去也是现在，现在也会过去。行走红尘人间，做个随遇而安的草木女子，让清风拂袖，心香暖怀。生命的旅途，总会有千回百转，悲喜寒凉，季节的辗转，绮丽的风景。若是懂得，这都是生活赋予的美好。";
		String msg111 = "故作神游，忍不住躺在了油菜花里，生活中所有的烦恼都不存在了，跑上了云霄，跑到了你我顾虑不到而遥远的地方，动情地看着天空发呆，天空是如此的蓝，白云是多么的飘逸，耳畔窸窸窣窣的声响顿时都构成了大自然最动听的乐曲。淡淡的，清幽的花香让人不自觉地忘了自己，仿佛与天地同在，与日月同辉，悄然四顾，没有喧嚣，没有离愁，我们也成为了大自然最透明的一份子。醉了，天空醉了，我醉了，你也醉了，醉了尘世间的纷纷扰扰，醉了人世间一切是是非非、恩恩怨怨，醉了一世琉璃";
		String msg1111 = "人生如戏，我们上演着悲欢离合，试过欢声笑语，也试过痛哭流涕,别人可能会以为我们表演得太夸张，其实那都是我们最真实的反应,细数走过的岁月，欢乐伴着忧伤。在时光的深处中，最美的永远艳丽多彩不褪色，那些伤痛，时间久了也就模糊不清，留下的记忆也是残缺碎片。遇到不满意时，总会拿过去的好作比较，留恋过去，讨厌现在，始不知过去也是现在，现在也会过去。行走红尘人间，做个随遇而安的草木女子，让清风拂袖，心香暖怀。生命的旅途，总会有千回百转，悲喜寒凉，季节的辗转，绮丽的风景。若是懂得，这都是生活赋予的美好。";
		dao.add(bookname, author, press, price, msg111, imguri);
	}
}
