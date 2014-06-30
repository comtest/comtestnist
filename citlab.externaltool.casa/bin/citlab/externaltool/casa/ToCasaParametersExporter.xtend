package citlab.externaltool.casa;

import citlab.model.citL.Boolean

import citlab.model.citL.Enumerative
import citlab.model.citL.ModelUtils
import citlab.model.citL.Numbers
import citlab.model.citL.Parameter
import citlab.model.citL.Range
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess

class ToCasaParametersExporter  {
  

// exports 	the part of the model containign the paramters (not the constraints)

def void doGenerate(Resource resource, IFileSystemAccess fsa, int n) {
		fsa.generateFile(resource.className+".citmodel",getCasaModel(resource,n));
	}

def CharSequence getCasaModel(Resource resource,int n){
	return toCasaCode(resource.contents.head as citlab.model.citL.CitModel, n);
}	

def className(Resource res) {
		var name = res.URI.lastSegment
		return name.substring(0, name.indexOf('.'))
	}
def toCasaCode(citlab.model.citL.CitModel sm,int n){
	'''
	«n»
	«sm.getParameters.size»
	«FOR param :sm.getParameters»«param.getSize» «ENDFOR»
	'''
	
}

def getSize(Parameter param){
	switch (param) {
		Enumerative: '''«ModelUtils::getEnumerativeType(param as Enumerative).elements.size»''' 
		Boolean :'''2''' 
 		Numbers :'''«(param as Numbers).getValues.size»''' 
  		Range:{
  		if ((param as Range).step!=0)
  		'''«(((param as Range).end-(param as Range).begin)/(param as Range).step as Integer).toString»'''
  		else
  		'''«(((param as Range).end-(param as Range).begin) as Integer).toString»'''}
	}
}
}