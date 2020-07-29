package com.feiyu.command;

public abstract class Command {
	/**
	 * 执行命令
	 */
    public abstract void doit(); //exec run
    /**
     * ctrl+z命令（回退）
     */
    public abstract void undo();
}
