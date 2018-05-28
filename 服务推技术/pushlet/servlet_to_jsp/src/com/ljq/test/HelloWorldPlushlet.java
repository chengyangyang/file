package com.ljq.test;

import java.io.Serializable;

import nl.justobjects.pushlet.core.Event;
import nl.justobjects.pushlet.core.EventPullSource;

@SuppressWarnings("serial")
public class HelloWorldPlushlet extends EventPullSource implements Serializable {
	private int c = 0; 
    /**
     * 设置休眠时间
     */
    @Override
    protected long getSleepTime() {
        return 1000;
    }

    /**
     * 创建事件
     * 
     * 业务部分写在pullEvent()方法中，这个方法会被定时调用。
     */
    @Override
    protected Event pullEvent() {
        Event event = Event.createDataEvent("/linjiqin/hw");
        
        event.setField("hw", c++);
        return event;
    }

}
