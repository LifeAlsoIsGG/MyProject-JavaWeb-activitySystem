package Tool;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XmlValidator {
	//��֤һ��XML�ļ�����Ч��
	public static boolean validate(String xmlPath, String xsdPath) {
		boolean flag = false;
		xmlPath =xmlPath;
		xsdPath =xsdPath;
		try {
		//1.����ģʽ����SchemaFactory
		SchemaFactory sf = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
		//2.ͨ��XSD�ļ�����ģʽSchema
		File f = new File(xsdPath);
		Schema s = sf.newSchema(f);
		//3.��ģʽ������֤��Validator
		Validator v = s.newValidator();
		//4.ʵ����֤����֤XML�ļ�
		Source so = new StreamSource(xmlPath);
		v.validate(so);
		flag = true;
		} catch (SAXException e) {		
			e.printStackTrace();
		}catch(IOException e) {
			System.out.println("XML��֤ʧ��......");
			e.printStackTrace();
		}
		return flag;
	}

}