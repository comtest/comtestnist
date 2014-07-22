package citlab.core.ui.utils;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import citlab.model.citL.CitModel;
import citlab.model.citL.Parameter;
import citlab.model.citL.Rule;
import citlab.model.citL.Seed;
import citlab.model.util.ListPairsToSeed;
import citlab.model.util.ParameterToPairElements;
import citlab.model.util.TupleIterator;
import citlab.model.util.Utils.Pair;
import citlab.model.validation.RuleEvaluator;

/**
 * count all the combinations
 */
public class CombCounterJob extends Job {
	private int counter = 0;
	private CitModel citModel;
	@Inject
	Shell shell;

	public CombCounterJob(String name, CitModel citModel) {
		super(name);
		this.citModel = citModel;
	}

	public int getCounter() {
		return counter;
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		List<List<Pair<Parameter, ?>>> elements = ParameterToPairElements
				.getListPairsParameterValues(citModel);
		// AlwaysTrueFilter filter = new AlwaysTrueFilter();
		// List<List<Pair<Parameter, ?>>> paramsCleaned =
		// filter.RemoveImmutableAssignment(citModel, elements);
		// System.out.println("cleaned " + paramsCleaned);
		Iterator<List<Pair<Parameter, ?>>> tuples = new TupleIterator<Pair<Parameter, ?>>(
				elements);

		while (tuples.hasNext()) {
			List<Pair<Parameter, ?>> req = tuples.next();
			Seed myseed = ListPairsToSeed.convertToSeed(req);
			boolean check = true;

			for (Rule rule : citModel.getConstraints()) {
				if (monitor.isCanceled())
					return Status.CANCEL_STATUS;
				check = checkRuleAndSeed(rule, myseed);
				if (!check)
					break;
			}
			if (check) {
				counter++;
				System.out.println(req);
			}

		}
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				MessageDialog.openInformation(shell, "Your Popup ",
						String.valueOf(counter));
			}
		});

		// TODO Auto-generated method stub
		return Status.OK_STATUS;
	}

	public static java.lang.Boolean checkRuleAndSeed(Rule rule, Seed seed) {
		return (new RuleEvaluator(seed).evaluateRule(rule));
	}

}
