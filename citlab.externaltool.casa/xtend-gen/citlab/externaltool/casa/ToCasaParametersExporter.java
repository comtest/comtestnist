package citlab.externaltool.casa;

import citlab.model.citL.CitModel;
import citlab.model.citL.Element;
import citlab.model.citL.Enumerative;
import citlab.model.citL.EnumerativeType;
import citlab.model.citL.ModelUtils;
import citlab.model.citL.Numbers;
import citlab.model.citL.Parameter;
import citlab.model.citL.Range;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class ToCasaParametersExporter {
  public void doGenerate(final Resource resource, final IFileSystemAccess fsa, final int n) {
    String _className = this.className(resource);
    String _plus = (_className + ".citmodel");
    CharSequence _casaModel = this.getCasaModel(resource, n);
    fsa.generateFile(_plus, _casaModel);
  }
  
  public CharSequence getCasaModel(final Resource resource, final int n) {
    EList<EObject> _contents = resource.getContents();
    EObject _head = IterableExtensions.<EObject>head(_contents);
    return this.toCasaCode(((CitModel) _head), n);
  }
  
  public String className(final Resource res) {
    URI _uRI = res.getURI();
    String name = _uRI.lastSegment();
    int _indexOf = name.indexOf(".");
    return name.substring(0, _indexOf);
  }
  
  public CharSequence toCasaCode(final CitModel sm, final int n) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(n, "");
    _builder.newLineIfNotEmpty();
    EList<Parameter> _parameters = sm.getParameters();
    int _size = _parameters.size();
    _builder.append(_size, "");
    _builder.newLineIfNotEmpty();
    {
      EList<Parameter> _parameters_1 = sm.getParameters();
      for(final Parameter param : _parameters_1) {
        CharSequence _size_1 = this.getSize(param);
        _builder.append(_size_1, "");
        _builder.append(" ");
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence getSize(final Parameter param) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (param instanceof Enumerative) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        EnumerativeType _enumerativeType = ModelUtils.getEnumerativeType(((Enumerative) param));
        EList<Element> _elements = _enumerativeType.getElements();
        int _size = _elements.size();
        _builder.append(_size, "");
        _switchResult = _builder;
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
        EList<Integer> _values = ((Numbers) param).getValues();
        int _size = _values.size();
        _builder.append(_size, "");
        _switchResult = _builder;
      }
    }
    if (!_matched) {
      if (param instanceof Range) {
        _matched=true;
        CharSequence _xifexpression = null;
        int _step = ((Range) param).getStep();
        boolean _notEquals = (_step != 0);
        if (_notEquals) {
          StringConcatenation _builder = new StringConcatenation();
          Integer _end = ((Range) param).getEnd();
          Integer _begin = ((Range) param).getBegin();
          int _minus = ((_end).intValue() - (_begin).intValue());
          int _step_1 = ((Range) param).getStep();
          int _divide = (_minus / (((Integer) Integer.valueOf(_step_1))).intValue());
          String _string = Integer.valueOf(_divide).toString();
          _builder.append(_string, "");
          _xifexpression = _builder;
        } else {
          StringConcatenation _builder_1 = new StringConcatenation();
          Integer _end_1 = ((Range) param).getEnd();
          Integer _begin_1 = ((Range) param).getBegin();
          int _minus_1 = ((_end_1).intValue() - (_begin_1).intValue());
          String _string_1 = ((Integer) Integer.valueOf(_minus_1)).toString();
          _builder_1.append(_string_1, "");
          _xifexpression = _builder_1;
        }
        _switchResult = _xifexpression;
      }
    }
    return _switchResult;
  }
}
