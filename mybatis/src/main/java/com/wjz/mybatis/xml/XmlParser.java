package com.wjz.mybatis.xml;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.ibatis.builder.xml.XMLMapperEntityResolver;
import org.apache.ibatis.io.Resources;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * <b>Xml文件DOM方式解析内幕</b>
 * <p>
 * org.apache.ibatis.parsing.XNode创建的时候将org.apache.ibatis.parsing.XPathParser
 * 注入了进去，使用了委派模式，XNode获得其子节点时（root.evalNode("properties")）委派XPathParser继续解析。
 * </p>
 * 
 * 委派者和被委派者具有相同的行为
 * 
 * @param args
 * @see org.apache.shiro.session.mgt.AbstractNativeSessionManager
 * 
 */
public class XmlParser {

	public static void main(String[] args) {
		try {
			String xmlPath = "mybatis-config.xml";
			InputStream is = Resources.getResourceAsStream(xmlPath);
			Document document = createDocument(is);
			Node configuration = evalNode(document, "/configuration");
			// 获得<configuration>标签下的<mappers>标签对象
			Node mappers = evalNode(configuration, "mappers");
			NodeList nodeList = mappers.getChildNodes();
			if (nodeList != null) {
				for (int i = 0, n = nodeList.getLength(); i < n; i++) {
					Node node = nodeList.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						String nodeName = node.getNodeName();
						System.out.println("Node Name is : " + nodeName);
						NamedNodeMap attributes = node.getAttributes();
						for (int j = 0; j < attributes.getLength(); j++) {
							String nodeValue = attributes.item(j).getNodeValue();
							System.out.println("Node Value is : " + nodeValue);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Document createDocument(InputStream inputStream) {
		return createDocument(new InputSource(inputStream));
	}

	private static Document createDocument(InputSource inputSource) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			// 在解析文档时是否验证文档
			factory.setValidating(true);
			// 是否支持Xml命名空间
			factory.setNamespaceAware(false);
			// 是否忽略注释
			factory.setIgnoringComments(true);
			// 是否消除Xml元素中的空格
			factory.setIgnoringElementContentWhitespace(false);
			// 是否将CDATA节点转换为Text节点
			factory.setCoalescing(false);
			// 是否扩展实体引用节点
			factory.setExpandEntityReferences(true);

			DocumentBuilder builder = factory.newDocumentBuilder();
			// 根据Xml文档上的声明加载本地DTD文件（避免网络加载的延迟），以便对文档的进行验证
			builder.setEntityResolver(new XMLMapperEntityResolver());
			builder.setErrorHandler(new ErrorHandler() {
				@Override
				public void warning(SAXParseException exception) throws SAXException {
					// do nothing
				}

				@Override
				public void fatalError(SAXParseException exception) throws SAXException {
					throw exception;
				}

				@Override
				public void error(SAXParseException exception) throws SAXException {
					throw exception;
				}
			});
			return builder.parse(inputSource);
		} catch (Exception e) {
			throw new RuntimeException("Error creating document instance.  Cause: " + e, e);
		}
	}

	/**
	 * 
	 * @param item
	 * @param expression 表达式：'/'代表根目录（/configuration），'//'代表某一个节点（//mappers）
	 * @return
	 */
	public static Node evalNode(Object item, String expression) {
		try {
			XPathFactory factory = XPathFactory.newInstance();
			XPath xPath = factory.newXPath();
			XPathExpression pathExpression = xPath.compile(expression);
			return (Node) pathExpression.evaluate(item, XPathConstants.NODE);
//			return (Node) xPath.evaluate(expression, item, XPathConstants.NODE);
		} catch (Exception e) {
			throw new RuntimeException("Error evaluating XPath.  Cause: " + e, e);
		}
	}
}
