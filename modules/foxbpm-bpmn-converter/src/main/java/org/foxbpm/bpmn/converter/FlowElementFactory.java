/**
 * Copyright 1996-2014 FoxBPM ORG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * @author yangguangftlp
 */
package org.foxbpm.bpmn.converter;

import org.dom4j.Element;
import org.foxbpm.model.FlowElement;

/**
 * FlowElment节点工厂
 * 
 * @author yangguangftlp
 * @date 2014年10月16日
 */
public interface FlowElementFactory {
	
	/**
	 * 创建FlowElement
	 * 
	 * @return 返回流程元素实例
	 */
	FlowElement cretateFlowElement();
	/**
	 * 创建XMLElement
	 * 
	 * @return 返回xml元素实例
	 */
	Element cretateXMLElement();
}
