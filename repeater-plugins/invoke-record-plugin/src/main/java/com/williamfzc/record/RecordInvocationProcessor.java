package com.williamfzc.record;

import com.alibaba.jvm.sandbox.api.event.BeforeEvent;
import com.alibaba.jvm.sandbox.api.event.Event;
import com.alibaba.jvm.sandbox.repeater.plugin.core.impl.api.DefaultInvocationProcessor;
import com.alibaba.jvm.sandbox.repeater.plugin.domain.Identity;
import com.alibaba.jvm.sandbox.repeater.plugin.domain.InvokeType;

public class RecordInvocationProcessor extends DefaultInvocationProcessor {
    public RecordInvocationProcessor(InvokeType type) {
        super(type);
    }

    @Override
    public Identity assembleIdentity(BeforeEvent event) {
        System.out.println("assemble identity: " + event.toString());
        return super.assembleIdentity(event);
    }

    @Override
    public Object[] assembleRequest(BeforeEvent event) {
        System.out.println("assemble request: " + event.toString());
        return super.assembleRequest(event);
    }

    @Override
    public Object assembleResponse(Event event) {
        System.out.println("assemble resp: " + event.toString());
        return super.assembleResponse(event);
    }
}
