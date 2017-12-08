package as.mke.bwlb;

public class MoveWay
{
	//曲线系数
	private static float 
	c1X = 300,
	c1Y = 300,
	c1R = 200,
	c2X = 450,
	c2Y = 300,
	c2R = 50,
	c3X = 600,
	c3Y = 300;
	
	//效果总时间
	public static float T = 3;
	
	//切换曲线时间
	private static float changeCTime = (float)((Math.PI*c1R)/(Math.PI*c2R+2*Math.PI*c1R)*T);
	
	//获取对应函数值
	public static float getY(float x,float time)
	{
		if(time>=0&&time<=T)
		{
			if(time<changeCTime)
			{
				return (float)Math.sqrt(c1R*c1R-(x-c1X)*(x-c1X))+c1Y;
			}
			else if(time>T-changeCTime)
			{
				return (float)Math.sqrt(c1R*c1R-(x-c3X)*(x-c3X))+c3Y;
			}
			else
			{
				return (float)-Math.sqrt(c2R*c2R-(x-c2X)*(x-c2X))+c2Y;
			}
		}
		return 0;
	}
	
	//计算x变化量
	public static float getXByTime(float time)
	{
		if(time>=0&&time<=T)
		{
			if(time<changeCTime)
			{
				return c1X-(float)Math.cos(time/changeCTime*Math.PI)*c1R;
			}
			else if(time>T-changeCTime)
			{
				return c3X+(float)Math.cos((T-time)/changeCTime*Math.PI)*c1R;
			}
			else
			{
				return c2X+(float)Math.cos((time-changeCTime)/(T-2*changeCTime)*Math.PI)*c2R;
			}
		}
		return 0;
	}
}
