package com.tehbeard.map.schematic;

public enum BlockRotation {

	WALL_MOUNTED(0x8,1,3,2,4),
	STAIRS(0x4,3,0,2,1),
	
	BED(0xC,0,1,2,3),
	COCOA(0xC,0,1,2,3),
	HOOK(0xC,0,1,2,3),
	REPEATER(0xC,0,1,2,3),
	FENCEGATE(0xC,0,1,2,3),
	END_PORTAL(0xC,0,1,2,3),
	
	CONTAINER_PISTON(0xC,2,5,3,4),
	
	PUMPKIN(0,0,1,2,3),
	
	
	TRAPDOOR(0,0,3,1,2),	
	
	HEAD(0,2,4,3,5),
	
	QUARTZ(0,3,4),
	
	ANVIL(0xE,0,1),
	
	
	RAIL(null),
	VINES(null),
	BIG_MUSHROOM(null),
	TRACK(null),
	DOOR(null),
	SIGN_POST(null),
	
	
	;
	
	BlockRotation(int mask, int... rotations){
		this.mask = mask;
		this.rotationsArray = rotations;
	}
	
	private int[] rotationsArray;
	private int mask;
	
	private RotateFunction rotateFunc;
	
	private BlockRotation(RotateFunction rotateFunc) {
		this.rotateFunc = rotateFunc;
	}
	
	/**
	 * Rotates block data
	 * @param data
	 * @param rotations
	 * @return
	 */
	public int rotate(int data, int rotations){
		if(rotateFunc != null){
			return rotateFunc.rotate(data, rotations);
		}
		else
		{
			 int extraData = data & mask;
			 int rotate = data & ~mask;
			 int idx = getIdx(rotationsArray, rotate);
			 if(idx == -1){return data;}
			 idx = (idx + rotations) % rotationsArray.length;
			 if(idx < 0){
				 idx += rotationsArray.length;
			 }
			 return rotationsArray[idx] | extraData;
			 
		}
	}
	 
	
	private int getIdx(int[] array,int value){
		for(int i =0;i<array.length;i++){
			if(array[i] == value){
				return i;
			}
		}
		return -1;
			
	}
	
	public static void main(String[] args){
		for(int i = 0;i> -30;i--){
			System.out.println(i % 8);
		}
	}
}
