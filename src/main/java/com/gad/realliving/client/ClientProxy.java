
package com.gad.realliving.client;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;

import com.gad.realliving.RealLiving;
import com.gad.realliving.common.CommonProxy;

public class ClientProxy extends CommonProxy{

	public ClientProxy(){
	}

	public void setup(FMLCommonSetupEvent event){
		super.setup(event);
	}

	public void setup(final FMLClientSetupEvent event){
		// 
	}

}