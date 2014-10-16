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
package org.foxbpm.bpmn.converter.parser;

import java.util.ArrayList;
import java.util.Iterator;

import org.dom4j.Element;
import org.dom4j.Node;
import org.foxbpm.bpmn.converter.BpmnXMLConverter;
import org.foxbpm.model.BpmnModel;
import org.foxbpm.model.DataVariable;
import org.foxbpm.model.Process;
;

/**
 * 
 * 常量类
 * 
 * @author yangguangftlp
 * @date 2014年10月15日
 */
public class ProcessParser extends BpmnParser {
	@SuppressWarnings("rawtypes")
	@Override
	public void parse(Element element, BpmnModel model) throws Exception {
		Process process = new Process();
		process.setId(element.attributeValue(ATTRIBUTE_ID));
		process.setName(element.attributeValue(ATTRIBUTE_NAME));
		process.setCategory(element.attributeValue(ATTRIBUTE_CATEGORY));
		process.setSubject(element.attributeValue(ATTRIBUTE_SUBJECT));
		process.setKey(element.attributeValue(ATTRIBUTE_KEY));
		// 扩展元素
		Element elem = null;
		String name = null;
		for (Iterator iterator = element.elements().iterator(); iterator.hasNext();) {
			elem = (Element) iterator.next();
			name = elem.getName();
			if (ELEMENT_EXTENSIONS.equalsIgnoreCase(name)) {
				parseExtElements(process, elem);
			}
			if (ELEMENT_DOCUMENTATION.equalsIgnoreCase(name)) {
				process.setDocumentation(elem.getText());
			} else if (null != BpmnXMLConverter.getConverter(name)) {
				BpmnXMLConverter.getConverter(name).convertXMLToMode(elem, model);
			}
		}
	}
	
	@SuppressWarnings("rawtypes")
	private void parseExtElements(Process process, Element element) {
		String parentNodeName = element.getName();
		String nodeName = null;
		String expression = null;
		Element elem = null;
		for (Iterator iterator = element.elements().iterator(); iterator.hasNext();) {
			elem = (Element) iterator.next();
			nodeName = elem.getName();
			if (ELEMENT_FORMURI.equalsIgnoreCase(nodeName) 
					|| ELEMENT_FORMURIVIEW.equalsIgnoreCase(nodeName)
			        || ELEMENT_DATAVARIABLE.equalsIgnoreCase(nodeName)
			        || ELEMENT_TASKSUBJECT.equalsIgnoreCase(nodeName)) {
				parseExtElements(process, element);
			}
			if (ELEMENT_EXPRESSION.equalsIgnoreCase(nodeName)) {
				// 表达式解析
				expression = parseExpression(elem);
				// 处理数据变量
				if (ELEMENT_DATAVARIABLE.equalsIgnoreCase(parentNodeName)) {
					
					if (null == process.getDataVariables()) {
						process.setDataVariables(new ArrayList<DataVariable>());
					}
					DataVariable dataVariable = new DataVariable();
					dataVariable.setId(element.attributeValue(ATTRIBUTE_ID));
					dataVariable.setBizType(element.attributeValue(ATTRIBUTE_BIZTYPE));
					dataVariable.setDataType(element.attributeValue(ATTRIBUTE_DATATYPE));
					dataVariable.setFieldName(element.attributeValue(ATTRIBUTE_FIELDNAME));
					dataVariable.setExpression(expression);
					process.getDataVariables().add(dataVariable);
					
				} else if (ELEMENT_FORMURI.equalsIgnoreCase(parentNodeName)) {
					process.setFormUri(expression);
				} else if (ELEMENT_FORMURIVIEW.equalsIgnoreCase(parentNodeName)) {
					process.setFormUriView(expression);
				} else if (ELEMENT_TASKSUBJECT.equalsIgnoreCase(parentNodeName)) {
					process.setSubject(expression);
				}
			}
		}
	}
	
	@SuppressWarnings("rawtypes")
	private String parseExpression(Element element) {
		Node node = null;
		for (Iterator iterator = element.nodeIterator(); iterator.hasNext();) {
			node = (Node) iterator.next();
			if (Element.CDATA_SECTION_NODE == node.getNodeType()) {
				return node.getText();
			}
		}
		return null;
	}
}