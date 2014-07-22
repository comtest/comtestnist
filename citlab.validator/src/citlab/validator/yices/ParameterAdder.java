/*******************************************************************************
 * Copyright (c) 2013 University of Bergamo - Italy
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Paolo Vavassori - initial API and implementation
 *   Angelo Gargantini - utils and architecture
 ******************************************************************************/
package citlab.validator.yices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import citlab.core.util.ParameterElementsGetter;
import citlab.model.citL.Boolean;
import citlab.model.citL.Element;
import citlab.model.citL.Enumerative;
import citlab.model.citL.EnumerativeType;
import citlab.model.citL.ModelUtils;
import citlab.model.citL.NamedType;
import citlab.model.citL.Range;
import citlab.model.citL.util.CitLSwitch;

import com.sun.jna.Pointer;

/**
 * add a parameter (and return the parameter added) with the right type
 * 
 * @author garganti
 * 
 */
public class ParameterAdder extends CitLSwitch<Pointer> {
	
	private static final Logger logger = Logger.getLogger(ParameterAdder.class);


	static YicesLibrary yices = YicesLibrary.INSTANCE;

	private Pointer ctx;

	private Map<EnumerativeType, Pointer> declaredTypes = new HashMap<>();
	private Map<String, String> declaredElements;

	ParameterAdder(Pointer ctx, Map<String, String> declaredElements2 ) {
		this.ctx = ctx;
		this.declaredElements = declaredElements2;
	}

	@Override
	public Pointer caseEnumerative(Enumerative enumerative) {
		EnumerativeType type = ModelUtils.getEnumerativeType(enumerative);
		// check if already declared
		Pointer ytype = declaredTypes.get(type);
		String elements = "";
		String enumName = enumerative.getName();
		for (Element e : type.getElements()) {
			String typeName = "";
			typeName = getEnumTypeYicesName(type, enumName);
			String elementYicesName = getElementYicesName(typeName, e);
			declaredElements.put(e.getName().concat(enumName), elementYicesName);
			elements += " " + elementYicesName;
		}
		if (ytype == null) {
			// add the type
			ytype = addEnumType(type, enumName,elements);
			declaredTypes.put(type, ytype);
		}
		Pointer adecl = yices.yices_mk_var_decl(ctx, enumName, ytype);
		Pointer a = yices.yices_mk_var_from_decl(ctx, adecl);
		if (logger.isDebugEnabled())
			yices.yices_dump_context(ctx);
		return a;
	}
	/**
	 * 
	 * @param type
	 * @param enumName nome dell'enumerativo (necessary in case of anonymous types)
	 * @param elements2 
	 * @return
	 */
	private Pointer addEnumType(EnumerativeType type, String enumName, String elements2) {
		Pointer pointerType = null;
		String command = " (scalar";
		
		String typeName = "";
		typeName = getEnumTypeYicesName(type, enumName);
		
		
		command=command.concat(elements2);
		command=command.concat(")");
		String definetype = "(define-type " + typeName	+ command + ")";
		logger.debug(" adding " + definetype);
		int res = yices.yices_parse_command(ctx, definetype);
		assert 1 == res : yices.yices_get_last_error_message();
		pointerType = yices.yices_mk_type(ctx, typeName);
		if (logger.isDebugEnabled())
			yices.yices_dump_context(ctx);
		return pointerType;
	}

	static String getEnumTypeYicesName(EnumerativeType type, String enumName) {
		String typeName;
		if (type instanceof NamedType)
			typeName = ((NamedType) type).getName();
		else {
			typeName = "unamedT" + enumName;
		}
		return typeName;
	}

	/**
	 * 
	 * @param elements
	 * @param typeName
	 * @param e
	 * @return
	 */
	static String getElementYicesName(String typeName, Element e) {
		if(!Character.isDigit(e.getName().charAt(0)) )
		return e.getName()+typeName;
		else return "E"+ e.getName()+typeName;
	}

	@Override
	public Pointer caseBoolean(Boolean boolParam) {
		Pointer e1 = yices.yices_mk_bool_var(ctx, boolParam.getName());
		return e1;
	}

	@Override
	public Pointer caseRange(Range range) {
		Pointer p = null;
		Pointer type = null;
		String command = new String();
		if (range.getStep() != 0 || range.getStep() > 1) {
			String typeName = range.getName()+"type";
			ArrayList<String> values = new ArrayList<String>(
					ParameterElementsGetter.eInstance.caseRange(range));
			if (values.size() > 1) {
				command = "(subtype (" + typeName + "::int) (or ";
				for (String v : values) {
					command=command.concat("(= "+typeName + " " + v + ") ");
				}
				command=command.concat("))");
				// "(subtype (n::int) (or (= n 2) (= n 8) ))"
				 type = yices.yices_parse_type(ctx, command);
				
			} else
				throw new RuntimeException("Not valid ");
		} else {
			 type = yices.yices_parse_type(ctx, "(subrange "+range.getBegin() +" "+range.getEnd()+")");
		}
		Pointer adecl = yices.yices_mk_var_decl(ctx, range.getName(), type);
		p = yices.yices_mk_var_from_decl(ctx, adecl);
		return p;
	}

	@Override
	public Pointer caseNumbers(citlab.model.citL.Numbers n) {
		Pointer p = null;
		String command = new String();

		ArrayList<String> values = new ArrayList<String>(
				ParameterElementsGetter.eInstance.caseNumbers(n));
		if (values.size() > 1) {
			command = "(subtype (" + n.getName()+"type" + "::int) (or ";
			for (String v : values) {
				command=command.concat("(= "+n.getName()+"type " + v + ") ");
			}
			command=command.concat("))");
			// "(subtype (n::int) (or (= n 2) (= n 8) ))"
			logger.debug(command);
			Pointer type = yices.yices_parse_type(ctx, command);
			Pointer adecl = yices.yices_mk_var_decl(ctx, n.getName(), type);
			p = yices.yices_mk_var_from_decl(ctx, adecl);
		} else
			throw new RuntimeException("Not valid ");

		return p;
	}
}
