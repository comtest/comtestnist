package citlab.model

import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage
import org.eclipse.emf.common.util.BasicEMap$Entry
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EcoreFactory
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.xtext.GeneratedMetamodel
import org.eclipse.xtext.xtext.ecoreInference.IXtext2EcorePostProcessor
//import citlab.model.citL.CitLPackage

class CitLPostProcessor implements IXtext2EcorePostProcessor {
	     
	    override void process(GeneratedMetamodel metamodel) {
	        metamodel.EPackage.process
	    }
	     
	    def process(EPackage p) {
	        for (c : p.EClassifiers.filter(typeof(EClass))) {
	            if (c.name == "Enumerative") {
	                c.handle
	            }
	        }
	    }

	     
	    def handle (EClass c) {
	        val op = EcoreFactory::eINSTANCE.createEOperation
	        op.name = "getType"
	        op.EType = EcorePackage::eINSTANCE.EString
	        //op.EType = CitLPackage::eINSTANCE.getEnumerativeType()
	        val body = EcoreFactory::eINSTANCE.createEAnnotation
	        body.source = GenModelPackage::eNS_URI
	        val map = EcoreFactory::eINSTANCE.create(EcorePackage::eINSTANCE.getEStringToStringMapEntry()) as BasicEMap$Entry<String,String>
	        map.key = "body"
	        //map.value = "return (getNamedType() != null ? getNamedType() : getAtype());"
	        map.value = "return null;"
	        body.details.add(map)
	        op.EAnnotations += body
	        c.EOperations += op
	    }
	

	
}