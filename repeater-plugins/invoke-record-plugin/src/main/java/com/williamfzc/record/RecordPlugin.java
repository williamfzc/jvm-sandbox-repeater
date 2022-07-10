package com.williamfzc.record;

import com.alibaba.jvm.sandbox.api.event.Event;
import com.alibaba.jvm.sandbox.repeater.plugin.api.InvocationProcessor;
import com.alibaba.jvm.sandbox.repeater.plugin.core.impl.AbstractInvokePluginAdapter;
import com.alibaba.jvm.sandbox.repeater.plugin.core.model.EnhanceModel;
import com.alibaba.jvm.sandbox.repeater.plugin.domain.InvokeType;
import com.alibaba.jvm.sandbox.repeater.plugin.spi.InvokePlugin;
import com.google.common.collect.Lists;
import org.kohsuke.MetaInfServices;

import java.util.List;

@MetaInfServices(InvokePlugin.class)
public class RecordPlugin extends AbstractInvokePluginAdapter {
    @Override
    protected List<EnhanceModel> getEnhanceModels() {

        EnhanceModel enhanceModel = EnhanceModel
                .builder()
                .classPattern("*")
                .methodPatterns(EnhanceModel.MethodPattern.transform("*service*"))
                .watchTypes(Event.Type.BEFORE, Event.Type.RETURN, Event.Type.THROWS)
                .build();

        return Lists.newArrayList(enhanceModel);
    }

    @Override
    protected InvocationProcessor getInvocationProcessor() {
        return new RecordInvocationProcessor(getType());
    }

    @Override
    public InvokeType getType() {
        return InvokeType.RECORD;
    }

    @Override
    public String identity() {
        return "record";
    }

    @Override
    public boolean isEntrance() {
        return false;
    }
}
