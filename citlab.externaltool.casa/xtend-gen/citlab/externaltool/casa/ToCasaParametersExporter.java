package citlab.externaltool.casa;

import citlab.model.citL.CitModel;
import citlab.model.citL.Enumerative;
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
    _builder.append("\ufffd\ufffdn\ufffd\ufffd");
    _builder.newLine();
    _builder.append("\ufffd\ufffdsm.getParameters.size\ufffd\ufffd");
    _builder.newLine();
    _builder.append("\ufffd\ufffdFOR param :sm.getParameters\ufffd\ufffd\ufffd\ufffdparam.getSize\ufffd\ufffd \ufffd\ufffdENDFOR\ufffd\ufffd");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence getSize(final Parameter param) {
    CharSequence _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (param instanceof Enumerative) {
        _matched=true;
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("\ufffd\ufffdModelUtils::getEnumerativeType(param as Enumerative).elements.size\ufffd\ufffd");
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
        _builder.append("\ufffd\ufffd(param as Numbers).getValues.size\ufffd\ufffd");
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
          _builder.append("\ufffd\ufffd(((param as Range).end-(param as Range).begin)/(param as Range).step as Integer).toString\ufffd\ufffd");
          _xifexpression = _builder;
        } else {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("\ufffd\ufffd(((param as Range).end-(param as Range).begin) as Integer).toString\ufffd\ufffd");
          _xifexpression = _builder_1;
        }
        _switchResult = _xifexpression;
      }
    }
    return _switchResult;
  }
}
