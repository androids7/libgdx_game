package as.mke.bwlb;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;

public class MyGdxGame implements ApplicationListener
{
	Texture texture;
	SpriteBatch batch;
	
	/*******/
	/**/Image star;
	/**/float time;

	Thread TD_Logic;
	
	AStart astart;
	@Override
	public void create()
	{
		texture = new Texture(Gdx.files.internal("res-sd/GameMain_BG.jpg"));
		batch = new SpriteBatch();
		astart=new AStart(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/3,
		10,20,new Texture(Gdx.files.internal("particle/bomb.png")));
		
		TD_Logic=new Thread()
		{
			public void run()
			{
				while(true)
				{
					
					/*
					***随机加速度的星星
					t=s/v
					时间=路程/速度
					
					
					这里星星速度=10px/秒
					*/
					
					
					//如果星星加速度不为0
					if(astart.getSpeedx()>0)
					{
					/*
					int astart_vx=
					int astart_xs=astart.getSpeedx()*
					*/
					//设置星星移动的距离
					astart.setX(astart.getX()+astart.getSpeedx());
					astart.setSpeedx(astart.getSpeedx()-1);
						/*
					try
						{
							sleep(1000);
						}
						catch (InterruptedException e)
						{}
						
						*/
					}
					
					else
					{
						astart.setX(Gdx.graphics.getWidth()/2);
						astart.setSpeedx(10);
					}
					
					try
					{
						sleep(200);
					}
					catch (InterruptedException e)
					{}
				}
			}
		};
		
		
		TD_Logic.start();
		
		
		/**/star = new Image(new Texture(Gdx.files.internal("particle/bomb.png")));
		
	}

	@Override
	public void render()
	{        
	    Gdx.gl.glClearColor(1, 1, 1, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		/***********************
		 一颗星星曲线运动
		 *************************/
		/**/time += Gdx.graphics.getDeltaTime();
		/**/star.setX(MoveWay.getXByTime(time));
		/**/star.setY(MoveWay.getY(star.getX(),time));
		/**/if(time>=MoveWay.T)time = 0;
		
		batch.begin();
		batch.draw(texture, 0 , 0, 
				   Gdx.graphics.getWidth() , Gdx.graphics.getHeight() );
				  
        batch.draw(astart.getTexture(),astart.getX(),astart.getY(),60,60);
		
		/**/star.draw(batch,1);
				   
		
		batch.end();
	}

	@Override
	public void dispose()
	{
	}

	@Override
	public void resize(int width, int height)
	{
	}

	@Override
	public void pause()
	{
	}

	@Override
	public void resume()
	{
	}
}
