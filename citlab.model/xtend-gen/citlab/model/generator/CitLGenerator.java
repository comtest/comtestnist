/**
 * NO LOGER USED... (generator must be an extension of a proper extension point
 * TODO delete from here (AG March 2012)
 */
package citlab.model.generator;

import citlab.model.citL.AnonymousType;
import citlab.model.citL.CitModel;
import citlab.model.citL.Element;
import citlab.model.citL.Enumerative;
import citlab.model.citL.NamedType;
import citlab.model.citL.Numbers;
import citlab.model.citL.Parameter;
import citlab.model.citL.Range;
import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class CitLGenerator implements IGenerator {
  public void doGenerate(final Resource resource, final IFileSystemAccess fsa) {
    String _className = this.className(resource);
    String _plus = (_className + ".java");
    EList<EObject> _contents = resource.getContents();
    EObject _head = IterableExtensions.<EObject>head(_contents);
    CharSequence _javaCode = this.toJavaCode(((CitModel) _head));
    fsa.generateFile(_plus, _javaCode);
    String _className_1 = this.className(resource);
    String _plus_1 = (_className_1 + ".model");
    EList<EObject> _contents_1 = resource.getContents();
    EObject _head_1 = IterableExtensions.<EObject>head(_contents_1);
    CharSequence _casaCode = this.toCasaCode(((CitModel) _head_1));
    fsa.generateFile(_plus_1, _casaCode);
  }
  
  public String className(final Resource res) {
    URI _uRI = res.getURI();
    String name = _uRI.lastSegment();
    int _indexOf = name.indexOf(".");
    return name.substring(0, _indexOf);
  }
  
  public CharSequence toCasaCode(final CitModel sm) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("�sm.parameters.size-1�");
    _builder.newLine();
    _builder.append("�sm.parameters.size�");
    _builder.newLine();
    _builder.append("�FOR param :sm.parameters��param.getSize� �ENDFOR�");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence toJavaCode(final CitModel sm) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.ArrayList;");
    _builder.newLine();
    _builder.append("import java.util.Arrays;");
    _builder.newLine();
    _builder.append("import java.util.Collections;");
    _builder.newLine();
    _builder.append("import java.util.List;");
    _builder.newLine();
    _builder.append("import combinatorial.util.CombinationGeneratorList;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class �sm.eResource.className� {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void main(String[] args) {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("List<List<String>> problema = new ArrayList<List<String>>();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("�FOR param :sm.parameters�");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("�param.switchExpression�");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("�ENDFOR�");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("stampaCombinazioni(problema, 3);");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static <T> void stampaCombinazioni(List<List<T>> problema, int i) {");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("CombinationGeneratorList<List<T>> gen = new CombinationGeneratorList<List<T>>(");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("problema, i);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("while (gen.hasNext()) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("List<List<T>> vs = gen.next();");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("List<List<T>> lE = allT(vs);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("for (List<T> ecl : lE) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("System.out.println(ecl);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* given a list of list of elements, return all the possible combinations");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static <T> List<List<T>> allT(List<List<T>> et) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return allT(et, et.size() - 1);");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* ");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* @param et");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* @param n");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* @return");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private static <T> List<List<T>> allT(List<List<T>> et, int n) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("List<T> t = et.get(n);");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("List<List<T>> result = new ArrayList<List<T>>();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("if (n == 0) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("for (T ec : t) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("result.add(Collections.singletonList(ec));");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return result;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("} else {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("List<List<T>> partial = allT(et, n - 1);");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("for (List<T> i : partial) {");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("for (T ec : t) {");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("List<T> partialRes = new ArrayList<T>(i);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("partialRes.add(ec);");
    _builder.newLine();
    _builder.append("\t\t\t\t\t");
    _builder.append("result.add(partialRes);");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return result;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence switchExpression(final Parameter param) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (param instanceof Enumerative) {
        _matched=true;
        CharSequence _xifexpression = null;
        NamedType _namedType = ((Enumerative) param).getNamedType();
        boolean _equals = Objects.equal(_namedType, null);
        if (_equals) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("problema.add(Arrays.asList(�FOR element : (param as Enumerative).atype.elements��writeElements(element,param)��ENDFOR�));");
          _xifexpression = _builder;
        } else {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("problema.add(Arrays.asList(�FOR element : ((param as Enumerative).namedType).elements��writeElements(element,(param as Enumerative).namedType)��ENDFOR�));");
          _xifexpression = _builder_1;
        }
        _switchResult = _xifexpression;
      }
    }
    if (!_matched) {
      if (param instanceof citlab.model.citL.Boolean) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("problema.add(Arrays.asList(\"�param.name�=true\",\"�param.name�=false\"));");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (param instanceof Numbers) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("problema.add(Arrays.asList(\"�param.name�=0\",\"�param.name�=�(param as Number).value�\"));");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (param instanceof Range) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("problema.add(Arrays.asList(\"�param.name�=�(param as Range).beging�\",\"�param.name�=�(param as Range).end�\"));");
        _switchResult = _builder;
      }
    }
    return _switchResult;
  }
  
  public CharSequence writeElements(final Element element, final Parameter param) {
    CharSequence _xifexpression = null;
    AnonymousType _atype = ((Enumerative) param).getAtype();
    EList<Element> _elements = _atype.getElements();
    int _indexOf = _elements.indexOf(element);
    boolean _notEquals = (_indexOf != 0);
    if (_notEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(",\"�param.name�=�element.name�\"");
      _xifexpression = _builder;
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("\"�param.name�=�element.name�\"");
      _xifexpression = _builder_1;
    }
    return _xifexpression;
  }
  
  public CharSequence writeElements(final Element element, final NamedType param) {
    CharSequence _xifexpression = null;
    EList<Element> _elements = param.getElements();
    int _indexOf = _elements.indexOf(element);
    boolean _notEquals = (_indexOf != 0);
    if (_notEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(",\"�param.name�=�element.name�\"");
      _xifexpression = _builder;
    } else {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("\"�param.name�=�element.name�\"");
      _xifexpression = _builder_1;
    }
    return _xifexpression;
  }
  
  public CharSequence getSize(final Parameter param) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (param instanceof Enumerative) {
        _matched=true;
        CharSequence _xifexpression = null;
        NamedType _namedType = ((Enumerative) param).getNamedType();
        boolean _equals = Objects.equal(_namedType, null);
        if (_equals) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("�(param as Enumerative).atype.elements.size�");
          _xifexpression = _builder;
        } else {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("�((param as Enumerative).namedType).elements.size�");
          _xifexpression = _builder_1;
        }
        _switchResult = _xifexpression;
      }
    }
    if (!_matched) {
      if (param instanceof citlab.model.citL.Boolean) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("2");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (param instanceof Numbers) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("1");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (param instanceof Range) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("3");
        _switchResult = _builder;
      }
    }
    return _switchResult;
  }
}
