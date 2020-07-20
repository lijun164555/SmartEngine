package com.alibaba.smart.framework.engine.smart;

import java.util.Map;

import javax.xml.namespace.QName;

import com.alibaba.smart.framework.engine.common.util.MapUtil;
import com.alibaba.smart.framework.engine.constant.ExtensionElementsConstant;
import com.alibaba.smart.framework.engine.constant.SmartBase;
import com.alibaba.smart.framework.engine.model.assembly.ExtensionDecorator;
import com.alibaba.smart.framework.engine.model.assembly.ExtensionElements;

import lombok.Data;

/**
 * @author ettear
 * Created by ettear on 06/08/2017.
 */
@Data
public class Value  implements ExtensionDecorator {
    public final static QName type = new QName(SmartBase.SMART_NS, "value");

    private String name;
    private String value;

    @Override
    public String getType() {
        return ExtensionElementsConstant.PROPERTIES;
    }

    @Override
    public void decorate(ExtensionElements extensionElements) {

        Map map =  (Map)extensionElements.getDecorationMap().get(getType());

        if(null == map){
            map = MapUtil.newHashMap();
            extensionElements.getDecorationMap().put(this.getType(),map);
        }

         map.put(this.getName(),this.getValue());

    }
}
