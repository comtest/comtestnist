package citlab.cvsexporter.generator;

import citlab.model.citL.Parameter;
import citlab.testsuite.Assignment;
import citlab.testsuite.Test;
import citlab.testsuite.TestSuite;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.IFileSystemAccess;

@SuppressWarnings("all")
public class ToCSV {
  public void doGenerate(final TestSuite input, final String filename, final IFileSystemAccess fsa) {
    CharSequence _cSVcode = this.toCSVcode(input);
    fsa.generateFile(filename, _cSVcode);
  }
  
  public CharSequence toCSVcode(final TestSuite input) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Test> _tests = input.getTests();
      Test _get = _tests.get(0);
      EList<Assignment> _assignments = _get.getAssignments();
      for(final Assignment assignment : _assignments) {
        {
          EList<Test> _tests_1 = input.getTests();
          Test _get_1 = _tests_1.get(0);
          EList<Assignment> _assignments_1 = _get_1.getAssignments();
          int _indexOf = _assignments_1.indexOf(assignment);
          boolean _notEquals = (_indexOf != 0);
          if (_notEquals) {
            _builder.append(", ");
            Parameter _parameter = assignment.getParameter();
            String _name = _parameter.getName();
            _builder.append(_name, "");
          } else {
            Parameter _parameter_1 = assignment.getParameter();
            String _name_1 = _parameter_1.getName();
            _builder.append(_name_1, "");
          }
        }
      }
    }
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    {
      EList<Test> _tests_2 = input.getTests();
      for(final Test test : _tests_2) {
        {
          EList<Assignment> _assignments_2 = test.getAssignments();
          for(final Assignment assignment_1 : _assignments_2) {
            {
              EList<Assignment> _assignments_3 = test.getAssignments();
              int _indexOf_1 = _assignments_3.indexOf(assignment_1);
              boolean _notEquals_1 = (_indexOf_1 != 0);
              if (_notEquals_1) {
                _builder.append(", ");
                String _value = assignment_1.getValue();
                _builder.append(_value, "");
              } else {
                String _value_1 = assignment_1.getValue();
                _builder.append(_value_1, "");
              }
            }
          }
        }
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
}
