/*
 * NO LOGER USED... (generator must be an extension of a proper extension point
 * TODO delete from here (AG March 2012)
 * 
 */
package citlab.model.generator

import citlab.model.citL.Boolean
import citlab.model.citL.Element
import citlab.model.citL.Enumerative
import citlab.model.citL.CitModel
import citlab.model.citL.NamedType
import citlab.model.citL.Numbers
import citlab.model.citL.Parameter
import citlab.model.citL.Range
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator

class CitLGenerator implements IGenerator {
	

	
override void doGenerate(Resource resource, IFileSystemAccess fsa) {
		fsa.generateFile(resource.className+".java", toJavaCode(resource.contents.head as citlab.model.citL.CitModel))
		fsa.generateFile(resource.className+".model",toCasaCode(resource.contents.head as citlab.model.citL.CitModel))
	}

def className(Resource res) {
		var name = res.URI.lastSegment
		return name.substring(0, name.indexOf('.'))
	}
def toCasaCode(citlab.model.citL.CitModel sm){
	'''
	�sm.parameters.size-1�
	�sm.parameters.size�
	�FOR param :sm.parameters��param.getSize� �ENDFOR�
	'''
	
}
def toJavaCode(citlab.model.citL.CitModel sm) {
	
	'''
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import combinatorial.util.CombinationGeneratorList;

public class �sm.eResource.className� {

	public static void main(String[] args) {

		List<List<String>> problema = new ArrayList<List<String>>();
		�FOR param :sm.parameters�
		�param.switchExpression�
		�ENDFOR�
		

		stampaCombinazioni(problema, 3);

	}

	private static <T> void stampaCombinazioni(List<List<T>> problema, int i) {

		CombinationGeneratorList<List<T>> gen = new CombinationGeneratorList<List<T>>(
				problema, i);
		while (gen.hasNext()) {
			List<List<T>> vs = gen.next();
			List<List<T>> lE = allT(vs);
			for (List<T> ecl : lE) {
				System.out.println(ecl);
			}
		}
	}

	/**
	 * given a list of list of elements, return all the possible combinations
	 * 
	 */
	public static <T> List<List<T>> allT(List<List<T>> et) {
		return allT(et, et.size() - 1);
	}

	/**
	 * 
	 * @param et
	 * @param n
	 * @return
	 */
	private static <T> List<List<T>> allT(List<List<T>> et, int n) {
		List<T> t = et.get(n);
		List<List<T>> result = new ArrayList<List<T>>();
		if (n == 0) {
			for (T ec : t) {
				result.add(Collections.singletonList(ec));
			}
			return result;
		} else {
			List<List<T>> partial = allT(et, n - 1);
			for (List<T> i : partial) {
				for (T ec : t) {
					List<T> partialRes = new ArrayList<T>(i);
					partialRes.add(ec);
					result.add(partialRes);
				}
			}
			return result;
		}

	}

}
'''

}

def switchExpression(Parameter param) {
		switch (param) {


 Enumerative:
  if((param as Enumerative).namedType==null)
	 '''problema.add(Arrays.asList(�FOR element : (param as Enumerative).atype.elements��writeElements(element,param)��ENDFOR�));''' 
  else
	 '''problema.add(Arrays.asList(�FOR element : ((param as Enumerative).namedType).elements��writeElements(element,(param as Enumerative).namedType)��ENDFOR�));'''
   Boolean :
     '''problema.add(Arrays.asList("�param.name�=true","�param.name�=false"));''' 
    Numbers : 
    '''problema.add(Arrays.asList("�param.name�=0","�param.name�=�(param as Number).value�"));''' 
     Range:
      '''problema.add(Arrays.asList("�param.name�=�(param as Range).beging�","�param.name�=�(param as Range).end�"));''' 
	}
	}
	
	

def writeElements(Element element,Parameter param)	{
	if((param as Enumerative).atype.elements.indexOf(element)!=0)
	 ''',"�param.name�=�element.name�"'''  	
	else '''"�param.name�=�element.name�"'''
	
}

def writeElements(Element element,NamedType param)	{
	if(param.elements.indexOf(element)!=0)
	 ''',"�param.name�=�element.name�"'''  	
	else '''"�param.name�=�element.name�"'''
	
}
def getSize(Parameter param){
	switch (param) {


 Enumerative:
  if((param as Enumerative).namedType==null)
	 '''�(param as Enumerative).atype.elements.size�''' 
  else
	 '''�((param as Enumerative).namedType).elements.size�'''
   Boolean :'''2''' 
   Numbers :'''1''' 
   Range:'''3'''
	}
	
}
	
}
