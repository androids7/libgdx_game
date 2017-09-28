package as.mke.bwlb;
import com.badlogic.gdx.graphics.*;

public class AStart
{
	private int x;
	private int y;
	private int speedx;
	private int speedy;
	private boolean isLife;
	private Texture texture;
	
	long livetime;
	
	public AStart(int x,int y,int speedx,int speedy,Texture texture)
	{
		this.x=x;
		this.y=y;
		this.speedx=speedx;
		this.speedx=speedy;
		
		this.texture=texture;
	}

	public void setSpeedx(int speedx)
	{
		this.speedx = speedx;
	}

	public int getSpeedx()
	{
		return speedx;
	}

	public void setTexture(Texture texture)
	{
		this.texture = texture;
	}

	public Texture getTexture()
	{
		return texture;
	}

	public void setIsLife(boolean isLife)
	{
		this.isLife = isLife;
	}

	public boolean isLife()
	{
		return isLife;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getX()
	{
		return x;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public int getY()
	{
		return y;
	}

	public void setSpeedy(int speedy)
	{
		this.speedy = speedy;
	}

	public int getSpeedy()
	{
		return speedy;
	}

	
	
}
